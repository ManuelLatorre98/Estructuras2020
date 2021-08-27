/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

import Lista.Lista;

/**
 *
 * @author Felipe
 */
public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public boolean insertarPuerto(Object unPuerto, Comparable key) {
        boolean estado = false;

        if (!pertenece(key)) {
            if (this.raiz == null) { //En caso de que el arbol este vacio el nodo a insertar sera el nodo raiz.
                this.raiz = new NodoAVL(unPuerto, key);
                estado = true;
            } else { //En caso contrario, se creara el nodo y se utilizara un metodo privado recursivo el cual se encargara de insertar el nodo de manera balanceada.
                NodoAVL temp = insertarPuertoAux(this.raiz, unPuerto, key);
                if (temp != null) {
                    this.raiz = temp;
                    estado = true;
                }
            }
        }
        return estado;
    }

    private NodoAVL insertarPuertoAux(NodoAVL nodo, Object unPuerto, Comparable key) {

        NodoAVL aux;
        if (nodo.compareTo(key) != 0) {

            if (nodo.compareTo(key) < 0) { //Verifico en que rama deberia ir el nuevo nodo, en este caso hacia la derecha
                if (nodo.getDerecho() == null) { //Si hay lugar en la rama derecha lo inserto como hijo derecho
                    nodo.setDerecho(new NodoAVL(unPuerto, key));
                } else { //Si no hay lugar, reposiciono el nodo derecho
                    aux = insertarPuertoAux(nodo.getDerecho(), unPuerto, key);
                    nodo.setDerecho(aux);
                }

            } else if (nodo.compareTo(key) > 0) {  //Verifico en que rama deberia ir el nuevo nodo, en este caso hacia la izquierda
                if (nodo.getIzquierdo() == null) { //Si hay lugar en la rama izquierda lo inserto como hijo izquierdo
                    nodo.setIzquierdo(new NodoAVL(unPuerto, key));
                } else { //Si no hay lugar, reposiciono el nodo izquierdo
                    aux = insertarPuertoAux(nodo.getIzquierdo(), unPuerto, key);
                    nodo.setIzquierdo(aux);
                }
            }

            if (nodo != null) {

                nodo.calcularAltura();
                if (this.balance(nodo) > 1 || this.balance(nodo) < -1) { //Comprobamos el balance del arbol una vez insertado el nodo 
                    nodo = balancear(nodo);                          // y lo balanceamos en caso de ser necesario
                }
            }
        }
        return nodo;
    }

    private NodoAVL balancear(NodoAVL aux) {
        NodoAVL reemplazado1;
        NodoAVL reemplazado2;

        if (aux != null) {
            if (this.balance(aux) == -2) {
                if (this.balance(aux.getDerecho()) == 1) {//Rotacion doble derecha izquierda

                    NodoAVL hijoDer = aux.getDerecho();
                    reemplazado1 = this.rotacionDerecha(hijoDer);
                    hijoDer = reemplazado1;
                    aux.setDerecho(hijoDer);
                    aux = this.rotacionIzquierda(aux);
                } else {//Rotacion simple izquierda
                    aux = this.rotacionIzquierda(aux);

                }
            } else if (this.balance(aux) == 2) {
                if (this.balance(aux.getIzquierdo()) == -1) {//Rotacion doble izquierda derecha
                    NodoAVL hijoIzq = aux.getIzquierdo();
                    reemplazado2 = this.rotacionIzquierda(hijoIzq);
                    hijoIzq = reemplazado2;
                    aux.setIzquierdo(hijoIzq);
                    aux = this.rotacionDerecha(aux);
                } else {//Rotacion simple derecha
                    reemplazado1 = this.rotacionDerecha(aux);
                    aux = reemplazado1;
                }
            }
        }
        return aux;
    }

    private int balance(NodoAVL nodo) {

        int alt1 = -1, alt2 = -1, bal = 0;
        if (nodo.getIzquierdo() != null || nodo.getDerecho() != null) {
            if (nodo.getIzquierdo() != null) {
                alt1 = nodo.getIzquierdo().getAltura();
            }
            if (nodo.getDerecho() != null) {
                alt2 = nodo.getDerecho().getAltura();
            }
            bal = alt1 - alt2;
        }
        return bal;
    }

    //METODO PARA LA ROTACION IZQUIERDA
    private NodoAVL rotacionIzquierda(NodoAVL nodo) { //Simple a izquierda
        NodoAVL h = nodo.getDerecho();
        NodoAVL temp = h.getIzquierdo();
        h.setIzquierdo(nodo);
        nodo.setDerecho(temp);
        nodo.calcularAltura();
        h.calcularAltura();
        return h;
    }
    //METODO PARA LA ROTACION DERECHA

    private NodoAVL rotacionDerecha(NodoAVL nodo) { //Simple a derecha
        NodoAVL h = nodo.getIzquierdo();
        NodoAVL temp = h.getDerecho();
        h.setDerecho(nodo);
        nodo.setIzquierdo(temp);
        nodo.calcularAltura();
        h.calcularAltura();
        return h;
    }

    public boolean pertenece(Comparable clave) {
        return (obtenerNodo(this.raiz, clave, null) != null);
    }

    //METODO ELIMINAR
    public boolean eliminarPuerto(Comparable key) {

        boolean estado = false;
        if (pertenece(key)) {   //Verifico si el puerto ingresado existe
            if (this.raiz != null) {
                if ((this.raiz.compareTo(key) == 0) && (this.raiz.getIzquierdo() == null) && (this.raiz.getDerecho() == null)) {
                    this.raiz = null;       //Caso en que la raiz sea el unico elemento del árbol.
                } else {
                    this.raiz = eliminarPuertoAux(key, this.raiz, estado);
                }
                estado = true;
            }
        }
        return estado;
    }

    private NodoAVL eliminarPuertoAux(Comparable buscado, NodoAVL aux, boolean estado) {

        if (aux != null) {
            if (aux.compareTo(buscado) == 0) {
                estado = true;
                //CASO HOJA
                if (aux.getIzquierdo() == null && aux.getDerecho() == null) {
                    aux = null;
                } else {
                    //CASO UN HIJO 
                    if ((aux.getIzquierdo() != null && aux.getDerecho() == null) || (aux.getIzquierdo() == null && aux.getDerecho() != null)) {
                        aux = caso_2(aux);
                    } else {
                        //CASO 2 HIJOS
                        if (aux.getIzquierdo() != null && aux.getDerecho() != null) {
                            aux = caso_3(aux, buscado);
                        }
                    }
                }
            } else {
                if (aux.compareTo(buscado) > 0) {
                    aux.setIzquierdo(eliminarPuertoAux(buscado, aux.getIzquierdo(), estado));
                } else if (aux.compareTo(buscado) < 0) {
                    aux.setDerecho(eliminarPuertoAux(buscado, aux.getDerecho(), estado));
                }
            }
        }

        if (aux != null) {
            aux.calcularAltura();
            if (this.balance(aux) > 1 || this.balance(aux) < -1) { //Compruebo el balance del arbol una vez borrado el nodo y lo balanceo en caso de ser necesario
                aux = balancear(aux);
            }
        }
        return aux;
    }

    //METODO caso_2 SI TIENE UN SOLO HIJO
    private NodoAVL caso_2(NodoAVL aux) {
        if (aux != null) {
            if (aux.getIzquierdo() != null) {
                aux = aux.getIzquierdo();
            } else {
                aux = aux.getDerecho();
            }
        }
        return aux;
    }

    //Metodo caso_3 si tiene dos hijos
    private NodoAVL caso_3(NodoAVL aux, Comparable pBuscado) {
        if (aux.compareTo(pBuscado) == 0) {
            // ELEGIMOS EL ELEMENTO MAXIMO DEL SUB-ARBOL izquierdo
            NodoAVL c1 = candidato1(aux.getIzquierdo());
            eliminarPuertoAux(c1.getClave(), this.raiz, false);
            aux.setElem(c1.getElem());
            aux.setClave(c1.getClave());
        }
        return aux;
    }

    //Devuelve el elemento Maximo del subarbol izquierdo
    private NodoAVL candidato1(NodoAVL aux) {
        while (aux.getDerecho() != null) {
            aux = aux.getDerecho();
        }
        return aux;
    }

    //Devuelve el elemento minimo del subarbol derecho
    private NodoAVL candidato2(NodoAVL aux) {
        while (aux.getIzquierdo() != null) {
            aux = aux.getIzquierdo();
        }
        return aux;
    }

    public NodoAVL obtenerNodo(NodoAVL nodo, Comparable buscado, NodoAVL p) {

        if (nodo != null) {
            if (nodo.compareTo(buscado) == 0) {
                p = nodo;
            } else {
                if (nodo.compareTo(buscado) > 0) {
                    p = obtenerNodo(nodo.getIzquierdo(), buscado, p);
                } else if (nodo.compareTo(buscado) < 0) {
                    p = obtenerNodo(nodo.getDerecho(), buscado, p);
                }
            }
        }
        return p;
    }

    public NodoAVL getRaiz() {
        return raiz;
    }

    public boolean esVacio() {
        return (this.raiz == null);
    }

    // 08.
    public Lista listarAlfabeticamente() {
        Lista l = new Lista();

        return listarAlfabAux(l, this.raiz);
    }

    private Lista listarAlfabAux(Lista l, NodoAVL aux) {
        if (aux != null) {

            if (aux.getIzquierdo() != null) {
                l = listarAlfabAux(l, aux.getIzquierdo());
            }
            l.insertar(aux.getClave(), l.longitud() + 1);
            if (aux.getDerecho() != null) {
                l = listarAlfabAux(l, aux.getDerecho());
            }
        }
        return l;
    }

    //04.
    public Lista listarRango(Comparable p1, Comparable p2) {
        Lista unaLista = new Lista();
        if (p1.compareTo(p2) <= 0) {
            unaLista = listarRangoAux(unaLista, this.raiz, p1, p2);
        }
        return unaLista;
    }

    private Lista listarRangoAux(Lista unaLista, NodoAVL aux, Comparable p1, Comparable p2) {

        if (aux != null) {
            if ((aux.compareTo(p2) < 0) && (aux.getDerecho() != null)) {
                unaLista = listarRangoAux(unaLista, aux.getDerecho(), p1, p2);
            }

            if ((aux.compareTo(p1) >= 0) && (aux.compareTo(p2) <= 0)) {
                //Con el 1 guarda en la primer posicion, sino queda invertido
                unaLista.insertar(aux.getClave(), 1);
            }
            if ((aux.compareTo(p1) > 0) && (aux.getIzquierdo() != null)) {
                unaLista = listarRangoAux(unaLista, aux.getIzquierdo(), p1, p2);
            }
        }
        return unaLista;
    }

    public NodoAVL minimoElem() {
        NodoAVL aux = this.raiz;
        while (aux.getIzquierdo() != null) {
            aux = aux.getIzquierdo();
        }
        return aux;
    }

    public NodoAVL maximoElem() {
        NodoAVL aux = this.raiz;
        while (aux.getDerecho() != null) {
            aux = aux.getDerecho();
        }
        return aux;
    }

    public Lista listarAltura() {
        Lista l = new Lista();

        return listarAltAux(l, this.raiz);
    }

    private Lista listarAltAux(Lista l, NodoAVL aux) {
        if (aux != null) {

            if (aux.getIzquierdo() != null) {
                l = listarAltAux(l, aux.getIzquierdo());
            }
            String s = "Altura de " + aux.getClave() + " -> " + aux.getAltura() + " \n";
            l.insertar(s, l.longitud() + 1);
            if (aux.getDerecho() != null) {
                l = listarAltAux(l, aux.getDerecho());
            }
        }
        return l;
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoAVL n) {
        String s = "";
        if (n != null) {
            s = "[" + n.getAltura() + "] " + n.getClave();
            if (n.getIzquierdo() != null) {
                s += " < Hijo Izq: " + n.getIzquierdo().getClave() + " > ";
            }

            if (n.getDerecho() != null) {
                s += " < Hijo Der: " + n.getDerecho().getClave() + " >";
            }

            s += "\n";
            s += toStringAux(n.getIzquierdo());
            s += toStringAux(n.getDerecho());
        }
        return s;
    }
}
