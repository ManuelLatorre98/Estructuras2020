/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4punto9;

/**
 *
 * @author Martín
 */
public class Taxista implements Runnable {
    private Taxi miTaxi;
    private String nombre;
    
    public Taxista(Taxi miTacho, String unNombre) {
        miTaxi = miTacho;
        nombre = unNombre;
    }
    
    private void atender() {
        System.out.println("Atendiendo a cliente");
        try {
            Thread.sleep((int) Math.random()*10000);
        } catch (InterruptedException ex) {
            System.out.println("Trabajo interrumpido");
        }
    }
    
    public void run() {
        System.out.println("Soy el taxista "+nombre+", estoy durmiendo");
        while (true) {
            miTaxi.esperarCliente();
            this.atender();
            miTaxi.terminarAtencion();
        }
    }
}
