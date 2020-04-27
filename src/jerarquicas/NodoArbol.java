package jerarquicas;

public class NodoArbol {
	private Object elem;
	private NodoArbol izquierdo;
	private NodoArbol derecho;

	public NodoArbol(Object elemen) {
		this.elem = elemen;
	}

	public Object getElem() {
		return this.elem;
	}

	public NodoArbol getIzquierdo() {
		return this.izquierdo;
	}

	public NodoArbol getDerecho() {
		return this.derecho;
	}

	public void setElem(Object elemen) {
		this.elem = elemen;
	}

	public void setIzquierdo(NodoArbol izq) {
		this.izquierdo = izq;
	}

	public void setDerecho(NodoArbol der) {
		this.derecho = der;
	}
}