package Objetos;

import java.util.concurrent.Semaphore;

public class Taxi {

    private Semaphore semManejar = new Semaphore(1);
    private Semaphore semSubir = new Semaphore(0);
    private Semaphore semBajar = new Semaphore(1);

    public boolean subirTaxi() {
        return semSubir.tryAcquire();
    }

    public void viajar() throws InterruptedException {
        semManejar.release();
        semBajar.acquire();
    }

    public void manejar() throws InterruptedException {
        semManejar.acquire();
        System.out.println("Comienza el recorrido.");
        Thread.sleep(8000);
        System.out.println("termina el recorrido.");
        semBajar.release();

    }

}
