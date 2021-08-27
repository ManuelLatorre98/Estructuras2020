/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lista;

/**
 *
 * @author Felipe
 */

//NODO DE LISTA
public class NodoLista {

    private Object elem;
    private NodoLista enlace;

    public NodoLista(Object elemento, NodoLista enlace) {
        this.elem = elemento;
        this.enlace = enlace;
    }

    public NodoLista(Object elemento) {
        this.elem = elemento;
        this.enlace = null;
    }

    public NodoLista() {
        this.elem = null;
        this.enlace = null;
    }

    public void setElem(Object elemento) {
        this.elem = elemento;
    }

    public Object getElem() {
        return this.elem;
    }

    public void setEnlace(NodoLista enlace) {
        this.enlace = enlace;
    }

    public NodoLista getEnlace() {
        return this.enlace;
    }
}
