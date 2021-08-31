import java.util.concurrent.RecursiveAction;

public class Cocinero extends RecursiveAction {

   
    private int cantidadPlatos;

    public Cocinero(int cant) {
        this.cantidadPlatos = cant;
    }

    @Override
    protected void compute() {
        if (cantidadPlatos > 100) {
            System.out.println("Demasiados platos para uno solo, dividamos la tarea! "+cantidadPlatos);
            Cocinero c1 = new Cocinero(cantidadPlatos / 2);
            Cocinero c2 = new Cocinero(cantidadPlatos / 2);
            c1.fork();
            c2.fork();
        }
        else{
            System.out.println("piola, hago todo solo, es poco: "+cantidadPlatos);
        }
    }

}
