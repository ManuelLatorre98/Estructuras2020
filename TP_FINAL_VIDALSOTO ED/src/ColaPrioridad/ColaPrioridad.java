package ColaPrioridad;
public class ColaPrioridad {

    private final int TAM = 3;
    private final Cola[] arrayPrioridades = new Cola[TAM];

    public ColaPrioridad() {
        for (int i = 0; i < TAM; i++) {
            arrayPrioridades[i] = new Cola();
        }
    }

    public boolean insertar(Object elem, int prioridad) {
        arrayPrioridades[prioridad].ingresarEnCola(elem);
        return true;
    }

    public boolean eliminarFrente() {
        int i = 0;
        boolean exito = false;

        while (i < this.TAM && arrayPrioridades[i].esVacia()) {
            i++;
        }

        if (i < TAM) {
            exito = arrayPrioridades[i].sacarDeEspera();
        }

        return exito;
    }

    public Object recuperarFrente() {
        int i = 0;
        Object frente = null;

        while (i < this.TAM && arrayPrioridades[i].esVacia()) {
            i++;
        }

        if (i < TAM) {
            frente = arrayPrioridades[i].getFrente();
        }

        return frente;
    }

    public boolean esVacia() {
        boolean vacia = true;
        int i = 0;
        while (i < this.TAM && vacia) {
            if (!this.arrayPrioridades[i].esVacia()) {
                vacia = false;
            }
            i++;
        }
        return vacia;
    }

    public void vaciar() {
        for (int i = 0; i < TAM; i++) {
            this.arrayPrioridades[i].vaciar();
        }
    }

}
