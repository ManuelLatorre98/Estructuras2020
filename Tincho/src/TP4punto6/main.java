/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4punto6;

/**
 *
 * @author Martín
 */
public class main {
    public static void main(String[] args) {
        Letra a, b, c;
        Thread t1, t2, t3;
        Turno turno;
        int i = (int) (Math.random() * 10 + 1);
        turno = new Turno(i, 3);
        a = new Letra('A', 1, 1, turno);
        b = new Letra('B', 2, 2, turno);
        c = new Letra('C', 3, 3, turno);
        t1 = new Thread(a);
        t2 = new Thread(b);
        t3 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("catch");
        }
    }
}
