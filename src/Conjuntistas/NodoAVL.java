package Conjuntistas;

public class NodoAVL {
	private Comparable elem;
	private int altura;
	private NodoAVL derecho;
	private NodoAVL izquierdo;

	public NodoAVL(Comparable elemen, NodoAVL hijoIzq, NodoAVL hijoDer) {
		this.elem = elemen;
		this.izquierdo = hijoIzq;
		this.derecho = hijoDer;
		auxRecalcularAltura(this);
	}
	
	public NodoAVL(Comparable elemen) {
		this.elem = elemen;
		this.izquierdo = null;
		this.derecho = null;
		auxRecalcularAltura(this);
	}

	public Comparable getElem() {
		return this.elem;
	}

	public int getAltura() {
			System.out.println("hola");
		
		return this.altura;
	}

	public NodoAVL getIzquierdo() {
		return this.izquierdo;
	}

	public NodoAVL getDerecho() {
		return this.derecho;
	}

	public void setElem(Comparable elemen) {
		this.elem = elemen;
	}

	public void setIzquierdo(NodoAVL hijoIzq) {
		this.izquierdo = hijoIzq;
	}

	public void setDerecho(NodoAVL hijoDer) {
		this.derecho = hijoDer;
	}
	
	private int auxRecalcularAltura(NodoAVL flagNodo) {
		int alturaIzq = -1;
		int alturaDer = -1;

		if (flagNodo != null) {

			alturaIzq = auxRecalcularAltura(flagNodo.getIzquierdo()) + 1;

			alturaDer = auxRecalcularAltura(flagNodo.getDerecho()) + 1;

		}

		this.altura = alturaIzq;
		if (alturaDer > this.altura) {
			this.altura = alturaDer;
		}
		return this.altura;
	}
}
