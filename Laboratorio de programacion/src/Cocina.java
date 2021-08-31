import java.util.concurrent.ForkJoinPool;


public class Cocina {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(8);//La variable entera indica el nivel de paralelismo (Estoy limitado a la cantidad de procesadores? o puedo meter todos los threads que quiera?) 
        Cocinero cocinero = new Cocinero(1000);//La variable entera indica la cantidad de tareas a realizar por cada uno
     
        pool.invoke(cocinero);
    }
    
    

}
