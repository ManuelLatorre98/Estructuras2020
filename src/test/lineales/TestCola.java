package test.lineales;
import lineales.dinamicas.Cola;
public class TestCola {
    public static void main(String[] args) {
 
        Cola cola= new Cola();
        Cola clon;
        
        //Apila
        System.out.println("Poner: "+poner(cola));
        System.out.println(cola.toString());
        
        
        //Saca
        System.out.println("\nSacar: "+sacar(cola));
        System.out.println(cola.toString());
        
        //Clona una pila en base a otra
       
        System.out.println("\nClon: "+cola.clone().toString());
        
        
        //Obtiene el elemento que esta en el tope
        System.out.println("\nFrente: "+obtenerFrente(cola));
        
        //Verifica si la pila es vacia
        System.out.println("\nEs vacia?: "+esVacia(cola));
        
        //Vacia la pila
        cola.vaciar();
        System.out.println("\nSe vacio correctamente: "+esVacia(cola));
        System.out.println("\nFrente: "+obtenerFrente(cola));

        
       
       
    }
    public static boolean poner(Cola cola) {
        cola.poner("1");
        cola.poner("2");
        cola.poner("3");
        cola.poner("4");
        
        return true;//Como lo utilizo para probar y se que apila 
    }
    public static boolean sacar(Cola cola){
        return cola.sacar();
    }
    public static Cola clonar(Cola cola) {
        return  cola.clone();
        
    }
    public static Object obtenerFrente(Cola cola){
        return cola.obtenerFrente();
    }
    public static boolean esVacia(Cola cola) {
        return cola.esVacia();
    }
    public static void vaciar(Cola cola) {
        cola.vaciar();
    }
  
    
}
