/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author Felipe
 */
public class NodoAdy {

    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    private int km; // etiqueta

    public NodoAdy(NodoVert vert, int km) {
        vertice = vert;
        sigAdyacente = null;
        this.km = km;
    }

    public NodoAdy(NodoVert vert, NodoAdy ady, int km) {
        this.vertice = vert;
        this.sigAdyacente = ady;
        this.km = km;
    }

    public NodoVert getVertice() {
        return vertice;
    }

    public void setVertice(NodoVert vertice) {
        this.vertice = vertice;
    }

    public NodoAdy getSigAdyacente() {
        return sigAdyacente;
    }

    public void setSigAdyacente(NodoAdy sigAdyacente) {
        this.sigAdyacente = sigAdyacente;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
