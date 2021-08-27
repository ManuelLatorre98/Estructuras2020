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
public class Testigo {
    private Semaphore mutex = new Semaphore(1);
    
    public Testigo(){
        
    }
    
    public void obtenerTestigo() throws InterruptedException{
        mutex.acquire();
    }
    
    public void entregarTestigo(){
        mutex.release();
    }
}
