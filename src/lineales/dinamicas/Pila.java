package lineales.dinamicas;

public class Pila {
	private Nodo tope;

	public Pila() {
		this.tope = null;
	}

	public boolean apilar(Object elem) {
		Nodo nodo = new Nodo(elem, this.tope);
		this.tope = nodo;
		return true;
	}

	public boolean desapilar() {
		boolean desapilo = false;
		if (this.tope != null) {
			this.tope = this.tope.getEnlace();
			desapilo = true;
		}
		return desapilo;
	}

	public Object obtenerTope() {
		Object elemTope;
		if (this.tope == null) {
			elemTope = "LA PILA ESTA VACIA";
		} else {
			elemTope = this.tope.getElem();
		}

		return elemTope;
	}

	public boolean esVacia() {
		return this.tope == null;
	}

	public void vaciar() {
		this.tope = null;
	}

	public Pila clone() {
		Nodo aux = this.tope; // Sigue a mi pila original
		Pila clon = new Pila();
		Nodo posicionClon; // Sigue a la pila clon

		if (this.tope != null) {

			Nodo nodoClon = new Nodo(this.tope.getElem(), this.tope.getEnlace());
			clon.tope = nodoClon;
			aux = aux.getEnlace();
			posicionClon = clon.tope.getEnlace();

			while (aux != null) {
				posicionClon.setEnlace(aux.getEnlace());
				posicionClon = posicionClon.getEnlace();
				aux = aux.getEnlace();
			}
		}
		return clon;
	}

	public String toString() {
		Nodo aux = this.tope;
		String cadena = "TOPE ---> ";
		while (aux != null) {
			cadena += aux.getElem();
			aux = aux.getEnlace();
			if (aux != null) {
				cadena += ", ";
			}
		}
		cadena += "]";
		return cadena;
	}

}
