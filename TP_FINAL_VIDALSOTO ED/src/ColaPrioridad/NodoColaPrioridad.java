/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColaPrioridad;

/**
 *
 * @author Felipe
 */
public class NodoColaPrioridad {

    private Object elem;
    private NodoColaPrioridad siguiente;
    private int prioridad;

    public NodoColaPrioridad(Object elem, int prioridad) {
        this.elem = elem;
        this.prioridad = prioridad;
        this.siguiente = null;
    }

    public NodoColaPrioridad(Object elem) {
        this.elem = elem;
    }
    
    public int getPrioridad() {
        return prioridad;
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public NodoColaPrioridad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoColaPrioridad siguiente) {
        this.siguiente = siguiente;
    }

}
