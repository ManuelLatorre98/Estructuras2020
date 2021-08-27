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
public class Cliente implements Runnable {
    private String miNombre;
    private Taxi elTaxi;
    
    public Cliente(Taxi elTacho, String unNombre) {
        miNombre = unNombre;
        elTaxi = elTacho;
    }
    
    private void buscarTaxi() {
        System.out.println("Soy el cliente "+this.miNombre+" y estoy buscando un taxi");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println("Interrumpieron mi búsqueda");
        }
        System.out.println("SALEEEEEEEEEE");
    }
    
    public void run() {
        this.buscarTaxi();
        if (elTaxi.entrar(miNombre)) {
            elTaxi.solicitarViaje(miNombre);
            elTaxi.salir(miNombre);
        } else {
            System.out.println("Soy "+this.miNombre+", el taxista no atiende");
        }
    }
}
