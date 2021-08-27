package ColaPrioridad;

import Lista.Lista;

public class Cola {

    private NodoColaPrioridad frente;
    private NodoColaPrioridad fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean ingresarEnCola(Object b) {
        NodoColaPrioridad nuevoNodo = new NodoColaPrioridad(b);

        if (this.frente == null) {
            this.frente = nuevoNodo;
            this.fin = nuevoNodo;
        } else {
            this.fin.setSiguiente(nuevoNodo);
            this.fin = nuevoNodo;
        }
        return true;
    }

    public boolean sacarDeEspera() {
        boolean exito = false;

        if (this.frente != null) {
            this.frente = this.frente.getSiguiente();
            exito = true;
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public Lista listaDeEspera() {
        Lista enEspera = new Lista();
        NodoColaPrioridad aux = this.frente;
        while (aux != null) {
            enEspera.insertar(aux.getElem(), enEspera.longitud() + 1);
            aux = aux.getSiguiente();
        }
        return enEspera;
    }

    public Object getFrente() {
        return frente.getElem();
    }

    public boolean esVacia() {
        return this.frente == null;
    }

    public void vaciar() {

        this.fin = null;
        this.frente = null;
    }

    @Override
    public String toString() {

        NodoColaPrioridad aux = this.frente;
        String cad = " ";

        while (aux != null) {
            cad = cad + aux.getElem() + " ";
            aux = aux.getSiguiente();
        }
        return cad;

    }
}
