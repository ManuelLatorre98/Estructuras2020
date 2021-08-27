/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO;

import AVL.ArbolAVL;
import AVL.NodoAVL;
import Grafos.Grafo;
import Lista.Lista;
import java.util.HashMap;
import java.util.Iterator;
import utiles.TecladoIn;

/**
 *
 * @author Felipe
 */
public class NavegantesMaritimos {

    public static void main(String[] args) {

        ArbolAVL unArbol = new ArbolAVL();
        Grafo unGrafo = new Grafo();
        HashMap<String, Barco> unaTabla = new HashMap<String, Barco>();

        iniciar(unGrafo, unArbol, unaTabla);

        System.out.println("====> AVL <====");
        System.out.println(unArbol.toString());

        System.out.println("--------------------------------------------");

        System.out.println("====> GRAFO <====");
        System.out.println(unGrafo.toString());

        System.out.println("--------------------------------------------");
        System.out.println("====> HASH MAP <====");
        mostrarBarcos(unaTabla);

        int opcion = -1;

        do {
            menu();
            System.out.print("Seleccionar opcion: ");
            opcion = TecladoIn.readLineInt();
            switch (opcion) {

                case 1:
                    altaBajaPuerto(unArbol, unGrafo);
                    break;
                case 2:
                    altaBajaRutaMaritima(unGrafo, unArbol);
                    break;
                case 3:
                    altaBarco(unaTabla, unArbol);
                    break;
                case 4:
                    mostrarRangoPuertos(unArbol);
                    break;
                case 5:
                    verificarYviajar(unArbol, unaTabla);
                    break;
                case 6:
                    verificarCaminoMenorM(unGrafo, unArbol);
                    break;
                case 7:
                    caminoMenor(unGrafo, unArbol);
                    break;
                case 8:
                    mostrarAlfabeticamente(unArbol);
                    break;
                case 9:
                    actualizarDarsenasPuerto(unArbol);
                    break;
                case 10:
                    mostrarDatosBarco(unaTabla);
                    break;
                case 11:
                    mostrarBarcosEnEsperaPrioridad(unArbol);
                    break;
                case 12:
                    devolverCaminoSinPuertoN(unGrafo, unArbol);
                    break;
                case 13:
                    mostrarMenorKm(unGrafo, unArbol);
                    break;
                case 14:
                    System.out.print("Puertos con barcos en espera: ");
                    System.out.println(puertosConBarcosEnEspera(unArbol).toString());
                    break;
                case 15:
                    System.out.print("Ingresar puerto: ");
                    String nom = TecladoIn.readLine().toUpperCase();
                    System.out.println(mostrarBarcosEnDarsenas(unArbol, nom));
                    break;
                case 16:
                    System.out.println("====> ÁRBOL AVL <====");
                    System.out.print(unArbol.toString());
                    break;
                case 17:
                    System.out.println("====> GRAFO <====");
                    System.out.print(unGrafo.toString());
                    break;
                case 18:
                    System.out.println("====> HASH MAP <====");
                    mostrarBarcos(unaTabla);
                    break;
                case 19:
                    verificarCaminoMenorLong(unGrafo,unArbol);
                    break;
                case 0:
                    System.out.println(">>>>>>> PROGRAMA FINALIZADO <<<<<<<");
                    break;
                default:
                    System.out.println("¡ERROR! Opcion incorrecta. ");
                    break;
            }
        } while (opcion != 0);

    }

//Menu de opciones.
    public static void menu() {
        System.out.println("");
        System.out.println("------------------------------------------ MENU ------------------------------------------");
        System.out.println("(1) Dar de alta o baja un puerto. ");
        System.out.println("(2) Dar de alta o baja un ruta maritima. ");
        System.out.println("(3) Dar de alta un barco.");
        System.out.println("(4) Dado P1 y P2, muestra alfabeticamente los puertos en el rango.");
        System.out.println("(5) Dado un barco B, dos puertos O y D, verifica si B está en alguna darsena de O y B viaja hacia D.");
        System.out.println("(6) Dados los puertos O y D, y una cantidad 'n' de km, verifica si existe un camino de O a D que no supere 'n' km.");
        System.out.println("(7) Dados O y D, devuelve el camino menor entre O y D. ");
        System.out.println("(8) Mostrar los puertos ordenados alfabeticamente.");
        System.out.println("(9) Dado un puerto P, actualizar el ingreso de barcos a las darsenas. ");
        System.out.println("(10) Dado un barco B, mostrar sus datos. ");
        System.out.println("(11) Dado un puerto P, mostrar los barcos en espera según la prioridad.");
        System.out.println("(12) Dado tres puertos O D y N, devolver el camino de puertos entre O y D, pero que no pase por N. ");
        System.out.println("(13) Dado dos puertos O y D, devolver la menor cantidad de km para llegar de O hasta D. ");
        System.out.println("(14) Mostrar todos los puertos con barcos en espera.");
        System.out.println("(15) Dado un puerto P, mostrar barcos en sus darsenas.");
        System.out.println("(16) Mostrar Arbol.");
        System.out.println("(17) Mostrar Grafo.");
        System.out.println("(18) Mostrar Barcos.");

        System.out.println("(0) SALIR.");

    }

//Carga los datos de puertos y barcos.
    public static void iniciar(Grafo unGrafo, ArbolAVL unArbol, HashMap<String, Barco> unaTabla) {

        //CREACION DE PUERTOS       NOMBRE      PAIS    CANT DARSENAS
        Puerto p1 = new Puerto("MAR DEL PLATA", "ARG", 6);
        Puerto p2 = new Puerto("CADIZ", "ESP", 3);
        Puerto p3 = new Puerto("SAN ANTONIO ESTE", "ARG", 3);
        Puerto p4 = new Puerto("MONTEVIDEO", "URU", 5);
        Puerto p5 = new Puerto("PUERTO MADRYN", "ARG", 4);
        Puerto p6 = new Puerto("PORTO ALEGRE", "BRA", 2);
        Puerto p7 = new Puerto("RIO DE JANEIRO", "BRA", 3);
        Puerto p8 = new Puerto("GUYANA", "BRA", 1);
        Puerto p9 = new Puerto("PUNTA DEL ESTE", "URU", 2);
        Puerto p10 = new Puerto("HAVANA", "CUB", 4);
        Puerto p11 = new Puerto("CALDERA", "CR", 3);
        Puerto p12 = new Puerto("MIAMI", "USA", 5);
        Puerto p13 = new Puerto("FORTALEZA", "BRA", 2);
        Puerto p14 = new Puerto("LISBOA", "POR", 3);
        Puerto p15 = new Puerto("SINES", "POR", 2);
        Puerto p16 = new Puerto("ESMERALDAS", "ECU", 3);
        Puerto p17 = new Puerto("LAUTOKA", "FIJ", 6);
        Puerto p18 = new Puerto("DUBLIN", "IRL", 3);
        Puerto p19 = new Puerto("AMSTERDAM", "HOL", 4);
        Puerto p20 = new Puerto("MANAUS", "BRA", 2);
        Puerto p21 = new Puerto("CAGLIARI", "ITA", 4);
        Puerto p22 = new Puerto("YOKOHAMA", "JPN", 5);
        Puerto p23 = new Puerto("SAN DIEGO", "USA", 3);

        //CREACION DE BARCOS
        Barco b1 = new Barco("001", "CARGA", "ARG");
        Barco b2 = new Barco("002", "CARGA", "CHI");
        Barco b3 = new Barco("015", "PASAJEROS", "ARG");
        Barco b4 = new Barco("016", "PASAJEROS", "JPN");
        Barco b5 = new Barco("033", "PESQUERO", "BRA");
        Barco b6 = new Barco("034", "PESQUERO", "USA");
        Barco b7 = new Barco("040", "PESQUERO", "USA");
        Barco b8 = new Barco("041", "CARGA", "CHI");
        Barco b9 = new Barco("055", "PESQUERO", "URU");
        Barco b10 = new Barco("056", "PASAJEROS", "URU");
        Barco b11 = new Barco("058", "PESQUERO", "URU");
        Barco b12 = new Barco("059", "CARGA", "JPN");
        Barco b13 = new Barco("061", "CARGA", "ESP");
        Barco b14 = new Barco("062", "CARGA", "POR");

        //CARGA DE TABLA HASH MAP
        unaTabla.put("001", b1);
        unaTabla.put("002", b2);
        unaTabla.put("015", b3);
        unaTabla.put("016", b4);
        unaTabla.put("033", b5);
        unaTabla.put("034", b6);
        unaTabla.put("040", b7);
        unaTabla.put("041", b8);
        unaTabla.put("055", b9);
        unaTabla.put("056", b10);
        unaTabla.put("058", b11);
        unaTabla.put("059", b12);
        unaTabla.put("061", b13);
        unaTabla.put("062", b14);

        //INGRESO DE BARCOS EN PUERTOS
        //Barco|Prioridad
        p7.darAltaBarco(b1, 2);
        p5.darAltaBarco(b2, 2);
        p7.darAltaBarco(b3, 1);
        p7.darAltaBarco(b4, 1);
        p15.darAltaBarco(b5, 0);
        p7.darAltaBarco(b6, 0);
        p10.darAltaBarco(b7, 0);
        p18.darAltaBarco(b8, 1);
        p18.darAltaBarco(b9, 0);
        p11.darAltaBarco(b10, 1);
        p8.darAltaBarco(b11, 0);
        p8.darAltaBarco(b12, 2);
        p7.darAltaBarco(b13, 2);
        p7.darAltaBarco(b14, 2);

        //CARGA DE ARBOL AVL CON PUERTOS
        unArbol.insertarPuerto(p1, p1.getNombre());
        unArbol.insertarPuerto(p2, p2.getNombre());
        unArbol.insertarPuerto(p3, p3.getNombre());
        unArbol.insertarPuerto(p4, p4.getNombre());
        unArbol.insertarPuerto(p5, p5.getNombre());
        unArbol.insertarPuerto(p6, p6.getNombre());
        unArbol.insertarPuerto(p7, p7.getNombre());
        unArbol.insertarPuerto(p8, p8.getNombre());
        unArbol.insertarPuerto(p9, p9.getNombre());
        unArbol.insertarPuerto(p10, p10.getNombre());
        unArbol.insertarPuerto(p11, p11.getNombre());
        unArbol.insertarPuerto(p12, p12.getNombre());
        unArbol.insertarPuerto(p13, p13.getNombre());
        unArbol.insertarPuerto(p14, p14.getNombre());
        unArbol.insertarPuerto(p15, p15.getNombre());
        unArbol.insertarPuerto(p16, p16.getNombre());
        unArbol.insertarPuerto(p17, p17.getNombre());
        unArbol.insertarPuerto(p18, p18.getNombre());
        unArbol.insertarPuerto(p19, p19.getNombre());
        unArbol.insertarPuerto(p20, p20.getNombre());
        unArbol.insertarPuerto(p21, p21.getNombre());
        unArbol.insertarPuerto(p22, p22.getNombre());
        unArbol.insertarPuerto(p23, p23.getNombre());

        // CARGA DE GRAFO CON PUERTOS
        unGrafo.insertarVertice(p1);
        unGrafo.insertarVertice(p2);
        unGrafo.insertarVertice(p3);
        unGrafo.insertarVertice(p4);
        unGrafo.insertarVertice(p5);
        unGrafo.insertarVertice(p6);
        unGrafo.insertarVertice(p7);
        unGrafo.insertarVertice(p8);
        unGrafo.insertarVertice(p9);
        unGrafo.insertarVertice(p10);
        unGrafo.insertarVertice(p11);
        unGrafo.insertarVertice(p12);
        unGrafo.insertarVertice(p13);
        unGrafo.insertarVertice(p14);
        unGrafo.insertarVertice(p15);
        unGrafo.insertarVertice(p16);
        unGrafo.insertarVertice(p17);
        unGrafo.insertarVertice(p18);
        unGrafo.insertarVertice(p19);
        unGrafo.insertarVertice(p20);
        unGrafo.insertarVertice(p21);
        unGrafo.insertarVertice(p22);
        unGrafo.insertarVertice(p23);

        //RUTAS MARITIMAS
        unGrafo.insertarArco("MAR DEL PLATA", "CADIZ", 5357);
        unGrafo.insertarArco("MAR DEL PLATA", "PORTO ALEGRE", 1192);
        unGrafo.insertarArco("MAR DEL PLATA", "PUERTO MADRYN", 930);
        unGrafo.insertarArco("MAR DEL PLATA", "SAN ANTONIO ESTE", 930);
        unGrafo.insertarArco("PORTO ALEGRE", "CADIZ", 5078);
        unGrafo.insertarArco("PORTO ALEGRE", "FORTALEZA", 4396);
        unGrafo.insertarArco("FORTALEZA", "MANAUS", 2098);
        unGrafo.insertarArco("MANAUS", "ESMERALDAS", 6412);
        unGrafo.insertarArco("MONTEVIDEO", "PORTO ALEGRE", 903);
        unGrafo.insertarArco("MONTEVIDEO", "PUNTA DEL ESTE", 138);
        unGrafo.insertarArco("SAN ANTONIO ESTE", "RIO DE JANEIRO", 3094);
        unGrafo.insertarArco("PORTO ALEGRE", "RIO DE JANEIRO", 1710);
        unGrafo.insertarArco("RIO DE JANEIRO", "MIAMI", 8382);
        unGrafo.insertarArco("RIO DE JANEIRO", "HAVANA", 10968);
        unGrafo.insertarArco("HAVANA", "MIAMI", 5254);
        unGrafo.insertarArco("MIAMI", "AMSTERDAM", 7586);
        unGrafo.insertarArco("MIAMI", "SAN DIEGO", 7578);
        unGrafo.insertarArco("AMSTERDAM", "SINES", 2078);
        unGrafo.insertarArco("AMSTERDAM", "CAGLIARI", 3931);
        unGrafo.insertarArco("CAGLIARI", "SINES", 1836);
        unGrafo.insertarArco("SINES", "LISBOA", 106);
        unGrafo.insertarArco("LISBOA", "DUBLIN", 1705);
        unGrafo.insertarArco("YOKOHAMA", "SAN DIEGO", 9126);
        unGrafo.insertarArco("YOKOHAMA", "LAUTOKA", 7610);
        unGrafo.insertarArco("LAUTOKA", "CALDERA", 11254);
        unGrafo.insertarArco("CALDERA", "DUBLIN", 9229);
        unGrafo.insertarArco("MANAUS", "GUYANA", 889);
        unGrafo.insertarArco("ESMERALDAS", "DUBLIN", 9264);

    }

//OPCION 1
    public static void altaBajaPuerto(ArbolAVL unArbol, Grafo unGrafo) {
        boolean exito = false;
        int n = -1;

        do {
            System.out.println("(1) Alta Puerto.");
            System.out.println("(2) Baja Puerto.");
            System.out.print("Seleccionar opcion: ");
            n = TecladoIn.readLineInt();

        } while (n != 1 && n != 2);

        if (n == 1) {
            String nombre, pais;
            int cantDarsenas;

            System.out.print("Ingrese nombre del puerto: ");
            nombre = TecladoIn.readLine().toUpperCase();
            System.out.print("Ingrese pais donde se encuentra: ");
            pais = TecladoIn.readLine().toUpperCase();
            System.out.print("Ingrese cantidad de darsenas: ");
            cantDarsenas = TecladoIn.readLineInt();

            if (!unArbol.pertenece(nombre)) {
                Puerto unPuerto = new Puerto(nombre, pais, cantDarsenas);
                exito = unArbol.insertarPuerto(unPuerto, unPuerto.getNombre());
                unGrafo.insertarVertice(unPuerto);
            }
            if (!exito) {
                System.out.println("¡ERROR! El puerto " + nombre + " ya existe.");
            } else {
                System.out.println("¡Puerto registrado exitosamente!");
            }
        } else {

            System.out.print("Ingrese nombre del puerto a eliminar: ");
            String nombre = TecladoIn.readLine().toUpperCase();

            if (unArbol.pertenece(nombre)) {
                exito = unArbol.eliminarPuerto(nombre);
                unGrafo.eliminarVertice(nombre);
            }
            if (!exito) {
                System.out.println("¡ERROR! El puerto " + nombre + " no existe.");
            } else {
                System.out.println("¡Puerto eliminado exitosamente!");
            }
        }

    }

//OPCION 2
    public static void altaBajaRutaMaritima(Grafo unGrafo, ArbolAVL unArbol) {
        boolean exito = false;
        int n = -1;

        do {
            System.out.println("(1) Alta Ruta.");
            System.out.println("(2) Baja Ruta.");
            System.out.print("Seleccionar opcion: ");
            n = TecladoIn.readLineInt();

        } while (n != 1 && n != 2);

        String origen, destino;

        if (n == 1) {

            int km;

            System.out.print("Ingrese nombre del puerto origen: ");
            origen = TecladoIn.readLine().toUpperCase();
            System.out.print("Ingrese nombre del puerto destino: ");
            destino = TecladoIn.readLine().toUpperCase();
            if (unArbol.pertenece(origen) && unArbol.pertenece(destino)) {
                System.out.print("Ingrese distancia en km: ");
                km = TecladoIn.readLineInt();
                exito = unGrafo.insertarArco(origen, destino, km);
            }
            if (!exito) {
                System.out.println("¡ERROR! No se pudo dar de alta la ruta.");
            } else {
                System.out.println("¡Ruta [" + origen + " --> " + destino + "] creada exitosamente!");
            }
        } else {
            System.out.print("Ingrese nombre del puerto origen: ");
            origen = TecladoIn.readLine().toUpperCase();
            System.out.print("Ingrese nombre del puerto destino: ");
            destino = TecladoIn.readLine().toUpperCase();
            if (unArbol.pertenece(origen) && unArbol.pertenece(destino)) {
                exito = unGrafo.eliminarRuta(origen, destino);
            }
            if (!exito) {
                System.out.println("¡ERROR! No existe la ruta [" + origen + " --> " + destino + "]. ");
            } else {
                System.out.println("¡Ruta [" + origen + " --> " + destino + "] eliminada exitosamente!");
            }
        }
    }

    //OPCION 3
    public static void altaBarco(HashMap<String, Barco> tablaBarcos, ArbolAVL unArbol) {

        System.out.print("Ingrese codigo de barco: ");
        String key = TecladoIn.readLine();
        System.out.print("Ingrese tipo de barco 'Pesquero'/'Pasajeros'/'Carga': ");
        String tipo = TecladoIn.readLine().toUpperCase();
        System.out.print("Ingrese bandera: ");
        String bandera = TecladoIn.readLine();

        if (!tablaBarcos.containsKey(key)) {     //Verifica si el barco no existe en HashMap

            Barco unBarco = new Barco(key, tipo, bandera);
            unBarco.actualizarTipo();

            tablaBarcos.put(key, unBarco);

            System.out.println("¡ÉXITO! El barco " + key + " fue registrado.");

            ingresarBarcoEnPuerto(unBarco, unArbol);

        } else {
            System.out.println("¡ERROR! El barco " + key + " ya existe.");
        }

    }

    //OPCION 4
    public static void mostrarRangoPuertos(ArbolAVL unArbol) {
        String origen, destino;

        do {
            System.out.print("Ingresar puerto origen: ");
            origen = TecladoIn.readLine().toUpperCase();;
            System.out.print("Ingresar puerto destino: ");
            destino = TecladoIn.readLine().toUpperCase();;
        } while (!unArbol.pertenece(origen) || !unArbol.pertenece(destino));

        System.out.println(unArbol.listarRango(origen, destino));

    }

    public static void ingresarBarcoEnPuerto(Barco unBarco, ArbolAVL unArbol) {
        String unPuerto;
        do {
            System.out.print("Ingresar puerto donde quiere ubicar el barco: ");
            unPuerto = TecladoIn.readLine().toUpperCase();;
        } while (!unArbol.pertenece(unPuerto));

        Puerto destino = (Puerto) unArbol.obtenerNodo(unArbol.getRaiz(), unPuerto, null).getElem();

        destino.darAltaBarco(unBarco, unBarco.getPrioridad());

        System.out.println("¡ÉXITO! Barco: " + unBarco.getCodigo() + " ingresado en Puerto: " + unPuerto);

    }

//OPCION 5
    public static void verificarYviajar(ArbolAVL unArbol, HashMap<String, Barco> tablaBarcos) {
        String origen, destino;
        boolean exito = false;

        do {
            System.out.print("Ingresar puerto origen: ");
            origen = TecladoIn.readLine().toUpperCase();;
            System.out.print("Ingresar puerto destino: ");
            destino = TecladoIn.readLine().toUpperCase();;
        } while (!unArbol.pertenece(origen) || !unArbol.pertenece(destino));

        System.out.println(mostrarBarcosEnDarsenas(unArbol, origen));

        System.out.print("Ingrese clave de barco: ");
        String key = TecladoIn.readLine();

        if (tablaBarcos.containsKey(key)) {     //Verifica si el barco existe en HashMap
            Barco unBarco = (Barco) tablaBarcos.get(key);

            exito = realizarViaje(unArbol, unBarco, origen, destino);
        } else {
            System.out.println("¡ERROR! NO existe barco.");
        }

        if (exito) {
            System.out.println("¡ÉXITO! Viaje realizado.");
        } else {
            System.out.println("¡ERROR! NO se pudo realizar el viaje.");
        }
    }

    public static boolean realizarViaje(ArbolAVL unArbol, Barco b, String p1, String p2) {
        boolean estado = false;
        Puerto origen = (Puerto) unArbol.obtenerNodo(unArbol.getRaiz(), p1, null).getElem();
        Puerto dest = (Puerto) unArbol.obtenerNodo(unArbol.getRaiz(), p2, null).getElem();

        if (origen.existeBarcoEnDarsena(b.getCodigo())) {
            dest.darAltaBarco(b, b.getPrioridad());
            origen.darBajaBarco(b.getCodigo());
            estado = true;
        }

        return estado;
    }

//OPCION 6
    public static void verificarCaminoMenorM(Grafo unGrafo, ArbolAVL unArbol) {
        String origen, destino;
        boolean exito = false;

        do {
            System.out.print("Ingresar puerto origen: ");
            origen = TecladoIn.readLine().toUpperCase();;
            System.out.print("Ingresar puerto destino: ");
            destino = TecladoIn.readLine().toUpperCase();;
        } while (!unArbol.pertenece(origen) || !unArbol.pertenece(destino));

        System.out.print("Ingrese km: ");
        int km = TecladoIn.readLineInt();

        exito = unGrafo.existeCaminoMenorKm(origen, destino, km);

        if (exito) {
            System.out.println("¡ÉXITO! Existe un camino desde " + origen + " a " + destino + " menor a " + km + " km.");
        } else {
            System.out.println("¡FRACASO! NO existe un camino desde " + origen + " a " + destino + " menor a " + km + " km.");
        }
    }
    
    public static void verificarCaminoMenorLong(Grafo unGrafo, ArbolAVL unArbol) {
        String origen, destino;
        boolean exito = true;

        do {
            System.out.print("Ingresar puerto origen: ");
            origen = TecladoIn.readLine().toUpperCase();;
            System.out.print("Ingresar puerto destino: ");
            destino = TecladoIn.readLine().toUpperCase();;
        } while (!unArbol.pertenece(origen) || !unArbol.pertenece(destino));

        System.out.print("Ingrese max vert: ");
        int km = TecladoIn.readLineInt();

        Lista unaLista=unGrafo.caminoMenorLong(origen, destino, km);

        if (exito) {
            System.out.println("¡ÉXITO! Existe un camino desde " + origen + " a " + destino + " menor a " + km + " VERTICES.");
            System.out.println("ES: "+unaLista.toString());
        } else {
            System.out.println("¡FRACASO! NO existe un camino desde " + origen + " a " + destino + " menor a " + km + " km.");
        }
    }

//OPCION 7
    public static void caminoMenor(Grafo unGrafo, ArbolAVL unArbol) {
        String origen, destino;
        do {
            System.out.print("Ingresar puerto origen: ");
            origen = TecladoIn.readLine().toUpperCase();
            System.out.print("Ingresar puerto destino: ");
            destino = TecladoIn.readLine().toUpperCase();
        } while (!unArbol.pertenece(origen) || !unArbol.pertenece(destino));

        System.out.println("El camino mas corto entre "
                + origen + " y " + destino + " es: " + unGrafo.caminoMasCorto(origen, destino).toString());
    }

//OPCION 8
    public static void mostrarAlfabeticamente(ArbolAVL unArbol) {
        System.out.println("Lista: " + unArbol.listarAlfabeticamente());
    }

//OPCION 9
    public static void actualizarDarsenasPuerto(ArbolAVL unArbol) {
        boolean exito = false;
        String unPuerto;

        do {
            System.out.print("Ingresar puerto: ");
            unPuerto = TecladoIn.readLine().toUpperCase();
        } while (!unArbol.pertenece(unPuerto));

        exito = actualizarPuerto(unArbol, unPuerto);

        if (exito) {
            System.out.println("¡ÉXITO! Puerto " + unPuerto + " actualizado.");
        } else {
            System.out.println("¡ERROR! No se pudo actualizar.");
        }
    }

    public static boolean actualizarPuerto(ArbolAVL unArbol, String puertoBuscado) {
        boolean estado = true;
        Puerto unPuerto = (Puerto) unArbol.obtenerNodo(unArbol.getRaiz(), puertoBuscado, null).getElem();

        if (unPuerto != null) {
            estado = unPuerto.actualizarDarsenas();
        } else {
            estado = false;
        }
        return estado;
    }

//OPCION 9
    public static void mostrarDatosBarco(HashMap<String, Barco> tabla) {
        System.out.print("Ingresar codigo del barco: ");
        String codigo = TecladoIn.readLine();
        boolean exito = false;
        Iterator it = tabla.keySet().iterator();

        while (it.hasNext() && !exito) {
            String key = (String) it.next();
            if (key.equalsIgnoreCase(codigo)) {
                exito = true;
                Barco unBarco = (Barco) tabla.get(key);
                System.out.println(unBarco.getDatos());
            }
        }
    }

//OPCION 11
    public static void mostrarBarcosEnEsperaPrioridad(ArbolAVL unArbol) {
        System.out.print("Ingresar puerto: ");
        String unPuerto = TecladoIn.readLine().toUpperCase();;

        System.out.println("Barcos en espera: " + "\n" + mostrarEsperaPuerto(unArbol, unPuerto));
    }

    public static String mostrarEsperaPuerto(ArbolAVL unArbol, String p) {
        Puerto unPuerto = (Puerto) unArbol.obtenerNodo(unArbol.getRaiz(), p, null).getElem();

        return unPuerto.mostrarListaDeEspera();
    }

//OPCION 12
    public static void devolverCaminoSinPuertoN(Grafo unGrafo, ArbolAVL unArbol) {
        String origen, destino, excep;

        do {
            System.out.print("Ingresar puerto origen: ");
            origen = TecladoIn.readLine().toUpperCase();
            System.out.print("Ingresar puerto destino: ");
            destino = TecladoIn.readLine().toUpperCase();
            System.out.print("Ingresar puerto excepción: ");
            excep = TecladoIn.readLine().toUpperCase();
        } while (!unArbol.pertenece(origen) || !unArbol.pertenece(destino) || !unArbol.pertenece(excep));

        System.out.println("Camino entre "
                + origen + " y " + destino
                + " sin pasar por " + excep + ": " + unGrafo.caminoConExcepcion(origen, destino, excep));

    }

//OPCION 13
    public static void mostrarMenorKm(Grafo unGrafo, ArbolAVL unArbol) {
        String origen, destino;

        do {
            System.out.print("Ingresar puerto origen: ");
            origen = TecladoIn.readLine().toUpperCase();
            System.out.print("Ingresar puerto destino: ");
            destino = TecladoIn.readLine().toUpperCase();
        } while (!unArbol.pertenece(origen) || !unArbol.pertenece(destino));

        System.out.println("La menor cantidad de km para viajar desde " + origen
                + " a " + destino + " es de: " + unGrafo.caminoMenorKm(origen, destino));

    }

//OPCION 14
    public static Lista puertosConBarcosEnEspera(ArbolAVL unArbol) {
        Lista unaLista = new Lista();
        return puertoConBarcosEnEsperaAux(unaLista, unArbol.getRaiz());
    }

    private static Lista puertoConBarcosEnEsperaAux(Lista l, NodoAVL n) {
        if (n != null) {

            Puerto unPuerto = (Puerto) n.getElem();

            if (unPuerto.barcosEnEspera()) {
                l.insertar(unPuerto.getNombre(), l.longitud() + 1);
            }
            if (n.getIzquierdo() != null) {
                l = puertoConBarcosEnEsperaAux(l, n.getIzquierdo());
            }
            if (n.getDerecho() != null) {
                l = puertoConBarcosEnEsperaAux(l, n.getDerecho());
            }
        }
        return l;
    }

//OPCION 15    
    public static String mostrarBarcosEnDarsenas(ArbolAVL unArbol, String nombrePuerto) {
        NodoAVL nodo = (unArbol.obtenerNodo(unArbol.getRaiz(), nombrePuerto, null));

        if (nodo != null) {
            Puerto unPuerto = (Puerto) nodo.getElem();

            return unPuerto.getDatosPuerto();
        } else {
            return "¡NO EXISTE PUERTO!";
        }
    }

//OPCION 16
    public static void mostrarBarcos(HashMap<String, Barco> unaTabla) {
        System.out.println("BARCOS: ");
        Iterator it = unaTabla.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Barco unBarco = (Barco) unaTabla.get(key);
            System.out.println(unBarco.getDatos());
        }
    }
}
