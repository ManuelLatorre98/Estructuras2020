/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4punto8;

/**
 *
 * @author Martín
 */
public class Carrera {
    public static void main(String [] args) {
        Testigo testigo = new Testigo();
        Atleta[] atletas = new Atleta[4];
        Thread[] hilos = new Thread[4];
        for (int i=0; i<4 ; i++) {
            atletas[i] = new Atleta(testigo);
        }
        for (int i=0; i<4; i++) {
            hilos[i] = new Thread(atletas[i]);
        }
        for (int i=0; i<4; i++) {
            hilos[i].start();
        }
    }
}
