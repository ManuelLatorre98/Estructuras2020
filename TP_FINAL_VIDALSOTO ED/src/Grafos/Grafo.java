/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import Lista.Lista;

/**
 *
 * @author Felipe
 */
public class Grafo {

    private NodoVert inicio = null;

    public Grafo(NodoVert inicio) {
        this.inicio = inicio;
    }

    public Grafo() {
    }

    public boolean insertarVertice(Object unPuerto) { //Inserta un puerto

        boolean exito = false;

        if (this.inicio == null) {
            this.inicio = new NodoVert(unPuerto, this.inicio);
            exito = true;
        } else {
            exito = insertarVerticeAux(unPuerto, this.inicio);
        }

        return exito;
    }

    private boolean insertarVerticeAux(Object unPuerto, NodoVert aux) {
        boolean estado = false;
        if (aux != null) {
            NodoVert p = ubicarVertice(unPuerto);
            if (p == null) {

                if (aux.getSigVertice() != null) {
                    insertarVerticeAux(unPuerto, aux.getSigVertice());
                } else {
                    aux.setSigVertice(new NodoVert(unPuerto));
                    estado = true;
                }
            }
        }
        return estado;
    }

    private NodoVert ubicarVertice(Object buscado) {    //Busca un puerto por su nombre y devuelve el Nodo
        NodoVert aux = this.inicio;
        while (aux != null && !aux.getElem().equals(buscado)) {
            aux = aux.getSigVertice();
        }
        return aux;
    }

    public boolean eliminarVertice(Object buscado) {    //Eliminar puerto por su nombre
        boolean exito = false;
        if (this.inicio != null) {

            if (this.inicio.getElem().equals(buscado)) {
                if (this.inicio.getSigVertice() == null) //Un solo vertice en todo el grafo
                {
                    this.inicio = null;
                } else {
                    NodoAdy ady = this.inicio.getPrimerAdy();
                    eliminarArcos(ady, buscado);
                    this.inicio = this.inicio.getSigVertice();
                    exito = true;
                }
            } else {
                exito = eliminarVerticeAux(buscado, this.inicio, this.inicio.getSigVertice());
            }
        }

        return exito;
    }

    private boolean eliminarVerticeAux(Object buscado, NodoVert anterior, NodoVert nodo) {
        boolean exito = false;
        NodoAdy ady;
        if (nodo != null) {
            while (nodo != null && !(exito)) {
                //SI ES UN NODO SIGUIENTE A LA RAIZ EL ELEMENTO QUE BUSCO
                if (nodo.getElem().equals(buscado)) {
                    //POR CADA ADYACENTE RECUPERO EL VERTICE Y ELIMINO DE SUS ADYACENTES AL VERTICE QUE ELIMINE
                    ady = nodo.getPrimerAdy();
                    eliminarArcos(ady, buscado);
                    anterior.setSigVertice(nodo.getSigVertice());//UNA VEZ QUE ELIMINA LOS ARCOS ENLAZO EL SIGUIENTE
                    exito = true;
                } else { //Si no es el vertice buscado, pasamos al siguiente
                    nodo = nodo.getSigVertice();
                    anterior = anterior.getSigVertice();
                }
            }
        }
        return exito;
    }

    public boolean insertarArco(Object origen, Object destino, int km) {    //Inserta una ruta desde una puerto A a un puerto B, con X cantidad de distancia en km.
        boolean estado = false;
        NodoVert inicio = ubicarVertice(origen);
        NodoVert fin = ubicarVertice(destino);

        //Se crean dos arcos, uno de origen a fin y otro de fin a origen
        if (inicio != null && fin != null) {

            if (!existeArco(origen, destino)) { //Arco de origen a fin
                if (inicio.getPrimerAdy() == null) {
                    inicio.setPrimerAdy(new NodoAdy(fin, km));
                } else {
                    NodoAdy aux = inicio.getPrimerAdy();
                    while (aux.getSigAdyacente() != null) {
                        aux = aux.getSigAdyacente();
                    }
                    aux.setSigAdyacente(new NodoAdy(fin, km));
                }

                if (fin.getPrimerAdy() == null) { // Arco de fin a origen
                    fin.setPrimerAdy(new NodoAdy(inicio, km));
                } else {
                    NodoAdy aux = fin.getPrimerAdy();
                    while (aux.getSigAdyacente() != null) {
                        aux = aux.getSigAdyacente();
                    }
                    aux.setSigAdyacente(new NodoAdy(inicio, km));
                }
                estado = true;
            }
        }
        return estado;
    }

    public boolean existeArco(Object origen, Object destino) { //Comprueba mediante los nombres de dos puertos, si existe un arco entre ellos

        boolean existe = false;
        NodoVert ini = this.ubicarVertice(origen);
        NodoVert fin = this.ubicarVertice(destino); //Ubico los nodos vertices con los que voy a trabajar para hallar sus nodos de adyacencia (Puertos)

        if (ini != null) {
            NodoAdy aux = ini.getPrimerAdy(); //Nodo de adyacencia para iterar en la lista de nodos adyacentes
            while (aux != null && !existe) {
                if (aux.getVertice().getElem().equals(destino)) { //Si llego a un nodo adyacente que representa el arco con el nodo vertice de destino, entonces se que existe la ruta 
                    existe = true;
                }
                aux = aux.getSigAdyacente();
            }
        }
        return existe;
    }

    // METODO ELIMINAR ARCO, ingresa un puerto de origen y un puerto destino
    public boolean eliminarRuta(Object origen, Object destino) {
        boolean estado = false;
        if (!esVacio()) {
            NodoVert inicio = ubicarVertice(origen);
            NodoVert fin = ubicarVertice(destino);
            if (inicio != null && fin != null) {
                if (inicio.getPrimerAdy() != null) {
                    NodoAdy primerAdy = inicio.getPrimerAdy();
                    //CASO BASE: SI EL PRIMER ADYACENTE ES IGUAL AL QUE BUSCO 
                    if (primerAdy.getVertice().getElem().equals(destino)) {
                        if (primerAdy.getSigAdyacente() == null) { // ES EL UNICO ADYACENTE DEL VERTICE
                            inicio.setPrimerAdy(null);
                        } else {
                            inicio.setPrimerAdy(primerAdy.getSigAdyacente());
                        }
                        estado = true;

                    } else {//SI NO ES EL PRIMER ADYACENTE
                        if (primerAdy.getSigAdyacente() != null) {
                            estado = eliminarRutaAux(primerAdy, primerAdy.getSigAdyacente(), destino, false);
                        }
                    }
                }
                //SI SE ELIMINÓ EL ARCO DE ORIGEN A DESTINO, ME ENCARGO DE ELIMINAR EL OTRO ARCO DE DESTINO A ORIGEN
                if (estado) {
                    if (fin.getPrimerAdy() != null) {
                        NodoAdy primerAdy = fin.getPrimerAdy();
                        if (primerAdy.getVertice().getElem().equals(origen)) {
                            if (primerAdy.getSigAdyacente() == null) {
                                fin.setPrimerAdy(null);
                            } else {
                                fin.setPrimerAdy(primerAdy.getSigAdyacente());
                            }
                        } else {
                            if (primerAdy.getSigAdyacente() != null) {
                                estado = eliminarRutaAux(primerAdy, primerAdy.getSigAdyacente(), origen, false);
                            }
                        }
                    }
                }
            }
        }
        return estado;
    }

    // ELIMINAR EL NODO ADYACENTE QUE NO SEA EL PRIMERO
    private boolean eliminarRutaAux(NodoAdy adyAnt, NodoAdy ady, Object buscado, boolean estado) {

        if (ady.getVertice().getElem().equals(buscado)) {
            if (ady.getSigAdyacente() != null) {//SI ady NO ES EL ULTIMO    
                adyAnt.setSigAdyacente(ady.getSigAdyacente());
            } else {//SI ady ES EL ULTIMO                           
                adyAnt.setSigAdyacente(null);
            }
            estado = true;
        } else {
            if (ady.getSigAdyacente() != null) {
                estado = eliminarRutaAux(adyAnt.getSigAdyacente(), ady.getSigAdyacente(), buscado, estado);
                //                          ady,            ady.getSigAdyacente(),      buscado
            }
        }
        return estado;
    }

    private void eliminarArcos(NodoAdy ady, Object buscado) { // CUANDO ELIMINO UN VERTICE, ELIMINO TODOS SUS ARCOS.

        while (ady != null) {
            boolean estado = false;
            NodoVert vAdy = ady.getVertice();//Vertice del adyacente de mi vertice a eliminar
            NodoAdy adyAux = vAdy.getPrimerAdy();// Primer Adyacente del Vertice anterior
            if (adyAux.getVertice().getElem().equals(buscado)) {
                vAdy.setPrimerAdy(adyAux.getSigAdyacente());
            } else {
                while (adyAux != null && !(estado)) {
                    if (adyAux.getSigAdyacente() != null) {
                        if (adyAux.getSigAdyacente().getVertice().getElem().equals(buscado)) {
                            adyAux.setSigAdyacente(adyAux.getSigAdyacente().getSigAdyacente());
                            estado = true;
                        }
                    }
                    adyAux = adyAux.getSigAdyacente();
                }
            }
            ady = ady.getSigAdyacente();
        }
    }

    public String toString() { //Devuelve una cadena de los puertos y sus rutas
        String cadena = "Vacio";
        NodoVert ini = this.inicio;
        if (ini != null) {
            cadena = "";
        }

        while (ini != null) {
            cadena = cadena + ini.getElem() + " --> ";
            NodoAdy iniA = ini.getPrimerAdy();
            while (iniA != null) {
                cadena = cadena + "[ " + iniA.getVertice().getElem() + " a " + iniA.getKm() + " km ] ";
                iniA = iniA.getSigAdyacente();
            }
            cadena = cadena + "\n";

            ini = ini.getSigVertice();

        }
        return cadena;
    }

    public boolean esVacio() {
        return (this.inicio == null);
    }

    public boolean existeVertice(Comparable buscado) {
        return (ubicarVertice(buscado) != null);
    }

    //06.
    public boolean existeCaminoMenorKm(Object origen, Object destino, int cantKm) {
        NodoVert inicio = ubicarVertice(origen);

        int kmRecorridos = 0;
        boolean exito = false;
        Lista unaLista = new Lista();

        if (this.existeCamino(origen, destino)) {
            exito = existeCaminoMenorKmAux(exito, kmRecorridos, cantKm, unaLista, inicio, destino);
        }
//        if (kmRecorridos != 0) {
//            exito = true;
//        }
        return exito;
    }

    private boolean existeCaminoMenorKmAux(boolean exito, int kmRecorridos, int limiteKm, Lista listaRecorrido, NodoVert nodo, Object destino) {

        if (nodo != null) {

            listaRecorrido.insertar(nodo.getElem(), listaRecorrido.longitud() + 1);

            if (nodo.getElem().equals(destino)) {
                if (kmRecorridos < limiteKm) {
                    exito = true;
                }
            } else {
                NodoAdy ady = nodo.getPrimerAdy();
                while (ady != null && !exito) {
                    if (listaRecorrido.localizar(ady.getVertice().getElem()) < 0) {
                        if (kmRecorridos + ady.getKm() < limiteKm) {
                            exito = existeCaminoMenorKmAux(exito, kmRecorridos + ady.getKm(), limiteKm, listaRecorrido, ady.getVertice(), destino);
                        }
                    }
                    ady = ady.getSigAdyacente();
                }
            }
            listaRecorrido.eliminar(listaRecorrido.longitud());
            //Elimino el ultimo nodo agregado para proceder con otros nodos de la estructura
            // ya que llegó al limite y no va a pertenecer al camino que estamos buscando
        }
        return exito;
    }

    //METODO TEORIA 
    public boolean existeCamino(Object inicio, Object fin) { //Comprueba que existe un camino para llegar desde un nodo vertice a otro, dados los nombres de los puertos

        boolean exito = false;
        NodoVert origen = ubicarVertice(inicio); //Obtengo el nodo vertice que corresponde al nombre ini
        NodoVert destino = ubicarVertice(fin); //Obtengo el nodo vertice que corresponde al nombre fin
        if (origen != null && destino != null) {
            Lista vis = new Lista();
            exito = existeCaminoAux(origen, destino.getElem(), vis);
            //exito = existeCaminoAux(origen, destino.getElem(), vis);
        }
        return exito;
    }

    private boolean existeCaminoAux(NodoVert ini, Object fin, Lista visitados) {
        boolean exito = false;
        if (ini != null) { //Verificamos que el nodo ini enviado por parametro no sea nulo
            if (ini.getElem().equals(fin)) { //Si el elemento del nodo ini es el mismo que el puerto buscado, entonces existe un camino entre inicio y fin.
                exito = true;

            } else { //Si no es el buscado, iteramos
                visitados.insertar(ini.getElem(), visitados.longitud() + 1); //Agrego el elemento a la lista visitados para saber que ya lo visite
                NodoAdy ady = ini.getPrimerAdy();
                while (!exito && ady != null) { //Itero hasta encontrar el puerto destino o hasta que se me termine la lista de adyacencias
                    if (visitados.localizar(ady.getVertice().getElem()) < 0) { //Si todavia no visite el puerto, entonces hago una llamada recursiva del metodo existeCaminoAux
                        exito = existeCaminoAux(ady.getVertice(), fin, visitados); //Hago la llamada con el nodo vertice que le corresponde al nodo adyacente
                    }
                    ady = ady.getSigAdyacente(); //Una vez que vuelvo de la llamada recursiva, obtengo el siguiente nodo adyacente y pruebo un nuevo camino
                }
            }
        }
        return exito;
    }

    // 07.
    public Lista caminoMasCorto(Object origen, Object destino) {

        Lista recorrido = new Lista();
        Lista caminoCorto = new Lista();

        NodoVert inicio = ubicarVertice(origen);
        NodoVert fin = ubicarVertice(destino);

        if (inicio != null && fin != null) {
            caminoCorto = caminoMasCortoAux(inicio, destino, recorrido, caminoCorto);
        }
        return caminoCorto;
    }

    private Lista caminoMasCortoAux(NodoVert aux, Object dest, Lista recorrido, Lista caminoCorto) {

        if (aux != null) {
            recorrido.insertar(aux.getElem().toString(), recorrido.longitud() + 1);

            if (aux.getElem().equals(dest)) {
                if ((recorrido.longitud() < caminoCorto.longitud()) || caminoCorto.longitud() == 0) {
                    caminoCorto = recorrido.clonar();
                }
//                recorrido.eliminar(recorrido.longitud());
            } else {
                NodoAdy ady = aux.getPrimerAdy();
                while (ady != null) {
                    if (recorrido.localizar(ady.getVertice().getElem()) < 0) {
                        if (caminoCorto.longitud() == 0 || (recorrido.longitud() + 1) < caminoCorto.longitud()) { //Corta si el recorrido ya supera el camino mas corto
                            caminoCorto = caminoMasCortoAux(ady.getVertice(), dest, recorrido, caminoCorto);
                        }
                    }
                    ady = ady.getSigAdyacente();
                }
//                recorrido.eliminar(recorrido.longitud()); //Elimino el ultimo nodo agregado para proceder con otros nodos de la estructura
            }
             recorrido.eliminar(recorrido.longitud());//Elimino el ultimo nodo agregado para proceder con otros nodos de la estructura
        }
        return caminoCorto;
    }
    
    public Lista caminoMenorLong (Object origen, Object destino, int longMax)
    {
        Lista recorrido = new Lista();
        Lista primerCamino = new Lista();
    
        NodoVert inicio= ubicarVertice(origen);
        NodoVert fin= ubicarVertice(destino);
        
        if(inicio!=null && fin!=null)
        {
            caminoMenorLongAux(inicio,destino,recorrido,primerCamino, longMax,false);
        
        }
    return primerCamino;
    }
    
    private boolean caminoMenorLongAux(NodoVert aux, Object dest, Lista recorrido, Lista primerCamino, int max, boolean exito) {

        if (aux != null) {
            System.out.println("Long antes de insertar: "+recorrido.longitud());
            recorrido.insertar(aux.getElem().toString(), recorrido.longitud() + 1);
            System.out.println("Long DESPUES de insertar: "+recorrido.longitud());
            if (aux.getElem().equals(dest)) {
                if (recorrido.longitud() <= max) {
                    System.out.println("LLEGÓ!!!");
                    primerCamino.setLista(recorrido.clonar());
                    exito=true;
                }
            } else {
                NodoAdy ady = aux.getPrimerAdy();
                while (ady != null && !exito) { //Corta si el recorrido ya fue encontrado
                    if (recorrido.localizar(ady.getVertice().getElem()) < 0 ) {
                        if ((recorrido.longitud()) <= max) { //Corta si el recorrido ya supera el camino mas corto
                            exito = caminoMenorLongAux(ady.getVertice(), dest, recorrido, primerCamino,max,exito);
                        }
                    }
                    ady = ady.getSigAdyacente();
                }
            }
            recorrido.eliminar(recorrido.longitud()); //Elimino el ultimo nodo agregado para proceder con otros nodos de la estructura
        }
        return exito;
    }

    public Grafo clonar() {

        Grafo clon = new Grafo();
        if (!esVacio()) {
            NodoVert vertice = clon.inicio;
            NodoVert aux = this.inicio;
            while (aux != null) {
                vertice.setPrimerAdy(aux.getPrimerAdy());
                NodoAdy adyClon = vertice.getPrimerAdy();
                if (aux.getPrimerAdy().getSigAdyacente() != null) {
                    NodoAdy auxAdy = aux.getPrimerAdy().getSigAdyacente();
                    while (auxAdy != null) {
                        adyClon.setSigAdyacente(auxAdy);
                        adyClon = adyClon.getSigAdyacente();
                        auxAdy = auxAdy.getSigAdyacente();
                    }
                }
                aux = aux.getSigVertice();
                vertice.setSigVertice(aux);
                vertice = vertice.getSigVertice();
            }
        }
        return clon;
    }

    // 012.
    public Lista caminoConExcepcion(Object ini, Object fin, Object excep) {

        NodoVert origen = this.ubicarVertice(ini);
        NodoVert destino = this.ubicarVertice(fin);
        NodoVert auxN = this.ubicarVertice(excep);
        //Buscamos los nodo vertice de cada puerto

        Lista resultado = new Lista(); //Lista que contendra el camino a retornar
        if (origen != null && destino != null) {
            Lista visitados = new Lista(); //Lista visitados para manejar los nodos visitados del grafo y asi no entrar en posibles bucles durante el recorrido del grafo
            resultado = caminoConExcepcionAux(origen, destino, auxN, visitados, resultado); //Para iterar sobre el grafo utilizo un metodo privado recursivo
        }

        return resultado;
    }

    private Lista caminoConExcepcionAux(NodoVert nodo, NodoVert fin, NodoVert excep, Lista visitados, Lista resultado) {

        if (nodo != null) {
            if (nodo != excep && (visitados.longitud() < resultado.longitud() || resultado.longitud() == 0)) {

                visitados.insertar(nodo.getElem(), visitados.longitud() + 1); //Inserto el nodo en la lista de visitados para luego no tenerlo en cuenta a la hora de buscar el recorrido
                //Compruebo que el nodo ini no sea excep, ya que en las llamadas recursivas, este nodo puede ser un nodo intermedio que sea igual a excep, y por lo que no seria valido para el camino
                //Como se que el nodo excep no esta en el camino, procedo a analizar el camino actual

                if (nodo == fin) { //Si llego a un camino que vaya de ini a fin y que tenga una distancia menor a un camino previamente hallado (o que no se haya encontrado otro camino valido)
                    resultado.setLista(visitados.clonar()); //Establezco la nueva lista que representa un camino de ini a fin, sin el nodo n

                } else { //En caso de que no haya encontrado todavia el camino, tengo que seguir buscando uno
                    NodoAdy ady = nodo.getPrimerAdy();
                    while (ady != null) { //Itero sobre los distintos nodos adyacentes del nodo ini
                        if (visitados.localizar(ady.getVertice().getElem()) < 0) { //Si el nodo todavia no fue visitado, seguimos el camino con ese nodo
                            caminoConExcepcionAux(ady.getVertice(), fin, excep, visitados, resultado); //Realizo la llamada recursiva con el siguiente nodo a comprobar
                        }
                        ady = ady.getSigAdyacente();
                    }
                }
                visitados.eliminar(visitados.longitud());  //Elimino el ultimo nodo agregado para proceder con otros nodos de la estructura
            }
        }
        return resultado;
    }

    // 013.
    public int caminoMenorKm(Object origen, Object destino) {
        NodoVert inicio = ubicarVertice(origen);

        int kmRecorridos = 0;
        Lista unaLista = new Lista();
        if (this.existeCamino(origen, destino)) {
            kmRecorridos = caminoMenorKmAux(kmRecorridos, 0, unaLista, inicio, destino);
        }
        return kmRecorridos;
    }

    private int caminoMenorKmAux(int kmRecorridos, int cantKm, Lista camino, NodoVert nodo, Object dest) {
        if (nodo != null) {
            camino.insertar(nodo.getElem(), camino.longitud() + 1);

            if (nodo.getElem().equals(dest)) {
                if (kmRecorridos > cantKm || kmRecorridos == 0) {
                    kmRecorridos = cantKm;
                }
            } else {
                NodoAdy ady = nodo.getPrimerAdy();
                while (ady != null) {
                    if (camino.localizar(ady.getVertice().getElem()) < 0) { // Si el vertice del adyacente no esta en la lista camino devuelve -1
                        if ((cantKm + ady.getKm()) < kmRecorridos || kmRecorridos == 0) {
                            kmRecorridos = caminoMenorKmAux(kmRecorridos, cantKm + ady.getKm(), camino, ady.getVertice(), dest);
                        }
                    }
                    ady = ady.getSigAdyacente();
                }
            }
            camino.eliminar(camino.longitud());
        }
        return kmRecorridos;
    }
}