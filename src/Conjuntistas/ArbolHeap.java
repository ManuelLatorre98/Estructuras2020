package Conjuntistas;

import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;

public class ArbolHeap {
	private int tamaño = 100;
	private Comparable[] heap;
	private int ultimo = 0;

	public ArbolHeap() {
		heap = new Comparable[this.tamaño];// array de 10 posiciones trabajo del 1 al 9
	}

	public boolean insertar(Comparable elem) {
		boolean exito = false;
		int posPadre;
		int posElem;
		Comparable auxElemPadre;
		if (this.ultimo < (this.tamaño - 1)) {
			ultimo++;
			heap[ultimo] = elem;
			posPadre = ultimo / 2;
			posElem = ultimo;
			while ((heap[posPadre] != null && heap[posElem] != null) && heap[posPadre].compareTo(heap[posElem]) > 0
					&& posElem != 1) {
				auxElemPadre = heap[posPadre];
				heap[posPadre] = heap[posElem];
				heap[posElem] = auxElemPadre;

				posElem = posPadre;
				posPadre = posElem / 2;

			}
			exito = true;
		}
		return exito;
	}

	public boolean eliminarCima() {
		boolean exito;
		if (this.ultimo == 0) {
			exito = false;
		} else {
			this.heap[1] = this.heap[ultimo];
			this.ultimo--;
			hacerBajar(1);
			exito = true;
		}
		return exito;
	}

	private void hacerBajar(int posPadre) {
		int posH;
		Comparable temp = this.heap[posPadre];
		boolean salir = false;
		while (!salir) {
			posH = posPadre * 2;
			if (posH <= this.ultimo) {
				if (posH < this.ultimo) {
					if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
						posH++;
					}
				}
				if (this.heap[posH].compareTo(temp) < 0) {
					this.heap[posPadre] = this.heap[posH];
					this.heap[posH] = temp;
					posPadre = posH;
				} else {
					salir = true;
				}
			} else {
				salir = true;
			}
		}

	}

	public ArbolHeap clone() {
		ArbolHeap clon = new ArbolHeap();
		clon.heap = this.heap.clone();
		clon.ultimo=this.ultimo;
		return clon;
	}

	public Comparable recuperarCima() {
		Comparable cima = null;
		if (ultimo > 0) {
			cima = heap[1];
		}
		return cima;
	}

	public boolean esVacio() {
		return ultimo == 0;
	}

	public String toString() {
		String cadena = "";
		int flagPos = 1;
		while (flagPos <= this.ultimo) {
			if((flagPos*2)> this.ultimo) {
				cadena += this.heap[flagPos] + ": HI--> null";
			}else {
				cadena += this.heap[flagPos] + ": HI--> " + this.heap[flagPos * 2];
			}
			
			
			if(((flagPos*2)+1)> this.ultimo) {
				cadena+=" HD--> null \n";
			}else {
				cadena+=" HD--> "+ this.heap[(flagPos * 2) + 1] + "\n";
			}
			flagPos++;
		}

		return cadena;
	}
	
	public Lista listarInorden() {
		Lista lista= new Lista();
		inOrden(this.raiz,lista);
		return lista;
	}
	
	private void inOrden(NodoArbol flagNodo, Lista lista) {
		if(flagNodo!=null) {
			inOrden(flagNodo.getIzquierdo(),lista);
			lista.insertar(flagNodo.getElem(), (lista.longitud()+1));
			inOrden(flagNodo.getDerecho(),lista);
		}
		
	}

}
