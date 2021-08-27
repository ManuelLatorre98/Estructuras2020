package Objetos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Taxista implements Runnable {

    private String nombre;
    private Taxi taxi;

    public Taxista(String nom, Taxi t) {
        nombre = nom;
        taxi = t;
    }

    @Override
    public void run() {
        System.out.println(nombre + " está durmiendo");
        try {
            taxi.manejar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
