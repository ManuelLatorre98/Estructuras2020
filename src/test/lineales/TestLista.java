package test.lineales;
import lineales.dinamicas.Lista;

public class TestLista {
    public static void main(String[] args) {
        Lista lista= new Lista();
        System.out.println(lista.insertar(1, 1));
        System.out.println(lista.insertar(1, 2));
        System.out.println(lista.insertar(1, 3));
        System.out.println(lista.insertar(1, 4));
        System.out.println(lista.insertar(1, 5));
        System.out.println(lista.insertar(1, 6));
        System.out.println(lista.toString());
        lista.apariciones(1);
        System.out.println(lista.toString());
        //System.out.println(lista.eliminar(1));
        //System.out.println(lista.toString());
   
        /*System.out.println(lista.obtenerMultiplos(3).toString());
        lista.eliminarApariciones('D');
        System.out.println(lista.toString());
        lista.agregarProducto(2);*/
        //System.out.println(lista.toString());
        
    }
}
