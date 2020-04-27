package test.lineales;
import lineales.dinamicas.Lista;

public class TestLista {
    public static void main(String[] args) {
        Lista lista= new Lista();
        System.out.println(lista.insertar(1, 1));
        System.out.println(lista.insertar(2, 2));
        System.out.println(lista.insertar(3, 3));
        System.out.println(lista.insertar(4, 4));
        System.out.println(lista.insertar(15, 5));
        System.out.println(lista.insertar(6, 6));
        System.out.println(lista.toString());
        
        System.out.println(lista.toString());
        System.out.println(lista.localizar(15));
        //System.out.println(lista.eliminar(1));
        //System.out.println(lista.toString());
   
        /*System.out.println(lista.obtenerMultiplos(3).toString());
        lista.eliminarApariciones('D');
        System.out.println(lista.toString());
        lista.agregarProducto(2);*/
        //System.out.println(lista.toString());
        
    }
}
