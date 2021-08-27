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
public class NodoVert {

    private Object elem;
    private NodoVert sigVertice;
    private NodoAdy primerAdy;

    public NodoVert(Object elem, NodoVert sigVertice, NodoAdy primerAdy) {
        this.elem = elem;
        this.sigVertice = sigVertice;
        this.primerAdy = primerAdy;
    }

    public NodoVert(Object elem, NodoVert sigVertice) {
        this.elem = elem;
//        this.clave=clave;
        this.sigVertice = sigVertice;
    }

    public NodoVert(Object elem) {
        this.elem = elem;
        this.sigVertice = null;
        this.primerAdy = null;
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public NodoVert getSigVertice() {
        return sigVertice;
    }

    public void setSigVertice(NodoVert sigVertice) {
        this.sigVertice = sigVertice;
    }

    public NodoAdy getPrimerAdy() {
        return primerAdy;
    }

    public void setPrimerAdy(NodoAdy primerAdy) {
        this.primerAdy = primerAdy;
    }
}
