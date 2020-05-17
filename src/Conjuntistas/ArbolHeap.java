package Conjuntistas;

public class ArbolHeap {
	private int tamaño = 10;
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
			while (heap[posPadre].compareTo(heap[posElem]) > 0 && posElem != 1) {
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
		boolean exito=false;
		int posElem;
		Comparable auxHijo;
		if (ultimo > 0) {
			heap[1] = heap[ultimo];
			ultimo--;
			posElem = 1;
			while (((posElem*2)+1)<=(tamaño-1) && heap[posElem].compareTo(heap[posElem * 2]) > 0
					|| heap[posElem].compareTo(heap[(posElem * 2) + 1]) > 0) {

				if (heap[(posElem * 2)].compareTo(heap[((posElem * 2) + 1)]) < 0) { // hijo izquierdo menor que el derecho
					auxHijo = heap[(posElem * 2)];
					heap[posElem * 2] = heap[posElem];
					heap[posElem] = auxHijo;
					posElem = posElem * 2;

				} else {// hijo derecho menor igual que el izquierdo
					auxHijo=heap[((posElem *2) +1)];
					heap[(posElem*2)+1]= heap[posElem];
					heap[posElem]=auxHijo;
					posElem= (posElem*2)+1;
				}
			}
			exito=true;
		}
		return exito;
	}
	
	public Comparable recuperarCima() {
		Comparable cima=null;
		if(ultimo>0) {
			cima= heap[1];
		}
		return cima;
	}
	
	public boolean esVacio() {
		return ultimo==0;
	}
	
	
}
