/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4punto9;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Taxi {
    private Semaphore semTaxi;
    private Semaphore semTaxista;
    private Semaphore semCliente;
    
    public Taxi(){
        semTaxi = new Semaphore(1);
        semTaxista = new Semaphore(0);
        semCliente = new Semaphore(1);
    }
    
    public boolean entrar(String unNombre) {
        System.out.println("Soy el cliente "+unNombre+", estoy entrando al taxi");
        return semTaxi.tryAcquire();
    }
    
    public void solicitarViaje(String unNombre) {
        System.out.println("Soy el cliente "+unNombre+", estoy solicitando un viaje");
        semTaxista.release();
        try {
            semCliente.acquire();
        } catch (InterruptedException ex) {
            System.out.println("El taxista no me quiere atender");
        }
    }
    
    public void esperarCliente() {
        try {
            semTaxista.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void terminarAtencion() {
        semCliente.release();
        System.out.println("Soy el taxista, ya terminé de atender");
    }
    
    public void salir(String nombreCliente) {
        semTaxi.release();
        System.out.println("Soy "+nombreCliente+", ya me bajé del taxi");
    }
}
