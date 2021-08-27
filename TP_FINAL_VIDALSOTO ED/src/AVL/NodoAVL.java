/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

/**
 *
 * @author Felipe
 */

public class NodoAVL implements Comparable {

    private Object elem;
    private Comparable clave;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    private int altura;

    public NodoAVL(Object elem, Comparable clave) {
        this.elem = elem;
        this.clave = clave;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 0;
    }

    public NodoAVL() {
        this.elem = null;
        this.clave = null;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 0;
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setClave(Comparable clave) {
        this.clave = clave;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }

    public int getAltura() {
        return altura;
    }

    public Comparable getClave() {
        return clave;
    }

    public int calcularAltura() {

        int alt = 0;

        if (this.izquierdo != null && this.derecho != null) {
            alt = Math.max(this.derecho.getAltura(), this.izquierdo.getAltura()) + 1;
        } else if (this.izquierdo != null && this.derecho == null) {
            alt = this.izquierdo.getAltura() + 1;
        } else if (this.derecho != null && this.izquierdo == null) {
            alt = this.derecho.getAltura() + 1;
        }

        this.altura = alt;

        return alt;
    }

    @Override
    public int compareTo(Object buscado) {
        return this.clave.compareTo(buscado);
    }

}
