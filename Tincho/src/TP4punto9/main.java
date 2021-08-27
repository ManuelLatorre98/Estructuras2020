/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4punto9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class main {
    public static void main(String [] args) {
        Taxi unTaxi = new Taxi();
        Taxista unTaxista = new Taxista(unTaxi, "Travis Bickle");
        Cliente unCliente = new Cliente(unTaxi, "Martin Scorsese");
        
        Thread hiloTaxista = new Thread(unTaxista);
        Thread hiloCliente = new Thread(unCliente);
        
        hiloTaxista.start();
        hiloCliente.start();
        
        try {
            Thread.sleep( (int) Math.random()*10000);
        }   catch (InterruptedException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
