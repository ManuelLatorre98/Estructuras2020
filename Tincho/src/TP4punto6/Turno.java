/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4punto6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Martín
 */
public class Turno {
    private int turno = 1;
    private int repeticiones; //cantidad de "vueltas"
    private int cantidad; //cantidad de turnos
    private Semaphore mutex = new Semaphore(1);

    public Turno(int rep, int cant) {
        repeticiones = rep;
        cantidad = cant;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public int getTurno() {
        return turno;
    }

    public void pasarTurno() {
        if (mutex.tryAcquire()) {
            turno = turno + 1;
            if (turno > cantidad && repeticiones >= 0) {
                turno = 1;
                repeticiones--;
            }
            mutex.release();
        }
    }
}
