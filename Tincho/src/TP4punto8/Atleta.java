/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4punto8;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Martín
 */
public class Atleta implements Runnable {
    private static Testigo testigo;
    
    public Atleta(Testigo t) {
        testigo = t;
    }
    @Override
    public void run() {
        double tiempo = Math.random()*2+9;
        try {
            testigo.obtenerTestigo();
            System.out.println(Thread.currentThread().getName()+
                    " tiene el testigo y comienza a correr");
            Thread.sleep( (long) tiempo*1000);
            System.out.println(Thread.currentThread().getName()+
                    " terminó la carrera en "+System.currentTimeMillis()+
                    " segundos y pasa el testigo");
            testigo.entregarTestigo();
        }
        catch (InterruptedException ex) {
        }
    }
}
