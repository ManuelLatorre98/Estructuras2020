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

public class Lista {

    private NodoLista cabecera;
    private int longitud=0;

    public Lista() {
        this.cabecera = null;
    }

    public int longitud() {
        return this.longitud;
    }

    public boolean insertar(Object elemento, int pos) {
        boolean exito = true;
        if (pos < 1 || this.longitud() + 1 < pos) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = new NodoLista(elemento, this.cabecera);
                this.longitud++;
            } else {
                NodoLista aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                NodoLista nuevo = new NodoLista(elemento, aux.getEnlace());
                aux.setEnlace(nuevo);
                this.longitud++;
            }
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = true;
        if (this.cabecera == null || (pos < 1 || pos > this.longitud() + 1)) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
                this.longitud--;
            } else {
                NodoLista aux = this.cabecera;
                int i = 1;
                
                while (i < (pos - 1) && aux != null) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
                this.longitud--;
            }
        }
        return exito;
    }

    public boolean esVacia() {
        return this.cabecera == null;
    }

    public Object recuperElem(int pos) {
        Object elem = null;
        NodoLista aux = this.cabecera;
        if (this.cabecera != null && !(pos < 1 || pos > this.longitud() + 1)) {
            if (pos == 1) {
                elem = this.cabecera.getElem();
            } else {
                int cont = 0;
                while (aux != null && cont < (pos - 1)) {
                    aux = aux.getEnlace();
                    cont++;
                }
                elem = aux.getElem();
            }
        }
        return elem;
    }

    public int localizar(Object elemento) {
        int pos = 1;
        boolean estado = false;
        NodoLista aux = this.cabecera;
        
        while (aux != null && !(estado)) {
            if (elemento.equals(aux.getElem())) {
                estado = true;
            } else {
                pos++;
                aux = aux.getEnlace();
            }
        }
        if (!(estado)) {
            pos = -1;
        }
        return pos;
    }

    public void vaciar() {
        if (!(esVacia())) {
            while (this.cabecera != null) {
                this.cabecera = this.cabecera.getEnlace();
            }
        }
    }

    public Lista clonar() {

        Lista clon = new Lista();
        NodoLista aux = this.cabecera;

        return clonAux(clon, aux);
    }

    private Lista clonAux(Lista l, NodoLista aux) {
        if (aux.getEnlace() != null) {
            l = clonAux(l, aux.getEnlace());
        }
        if (aux.getEnlace() == null) {
            l.cabecera = new NodoLista(aux.getElem(), null);
            l.longitud++;
        } else {
            l.cabecera = new NodoLista(aux.getElem(), l.cabecera);
            l.longitud++;
        }
        return l;
    }

    public String toString() {
        
        String cadena = "";
        NodoLista aux = this.cabecera;
        while (aux != null) {
            if (aux.getEnlace() != null) {
                cadena += aux.getElem() + ", ";
            } else {
                cadena += aux.getElem() + " ";
            }
            aux = aux.getEnlace();
        }
        return cadena;
    }
    
     public void setLista(Lista l) { //Dada una lista l enviada por parametro, setea el contenido de la lista actual a la lista l
        this.cabecera = l.cabecera;
        this.longitud = l.longitud;
    }
    
    public void setCabecera(NodoLista n){
        this.cabecera = n;
    }
}
