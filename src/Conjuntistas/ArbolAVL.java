package Conjuntistas;

import jerarquicas.NodoArbol;

public class ArbolAVL {
	private NodoAVL raiz;

	public ArbolAVL() {
		this.raiz = null;
	}

	public boolean insertar(Comparable elem) {
		boolean exito=false;
		if(this.raiz==null) {
			this.raiz.setElem(elem);
		}else {
			exito=auxInsertar(this.raiz,elem);
			balancear(this.raiz);
		}
		return exito;
	}

	private boolean auxInsertar(NodoAVL flagNodo, Comparable elem) {
		boolean exito = true;
		if (elem.compareTo(flagNodo.getElem()) == 0) {
			exito = false;
		} else {
			if (elem.compareTo(flagNodo.getElem()) < 0) {
				if (flagNodo.getIzquierdo() != null) {
					exito = auxInsertar(flagNodo.getIzquierdo(), elem);
				} else {
					flagNodo.setIzquierdo(new NodoAVL(elem));
				}
			} else {
				if (flagNodo.getDerecho() != null) {
					exito = auxInsertar(flagNodo.getDerecho(), elem);
				} else {
					flagNodo.setDerecho(new NodoAVL(elem));
				}
			}
		}
		return exito;
	}

	private void balancear(NodoAVL flagNodo) {
		int balanceNodo;
		int balanceHijo;
		NodoAVL auxPosActual;
		if (flagNodo != null) {
			balanceNodo= calcularBalance(flagNodo);
			if (balanceNodo == 2) { //Como da 2 esta caido hacia la izquierda, busco balance hijo izquierdo
				balanceHijo=calcularBalance(flagNodo.getIzquierdo());
				if(balanceHijo==1 || balanceHijo==0) {//Rotacion simple Derecha
					simpleADerecha(flagNodo);
				}else {
					if(balanceHijo==-1) {
						simpleAIzquierda(flagNodo.getIzquierdo());
						simpleADerecha(flagNodo);			
					}
				}
			}else {
				if(balanceNodo== -2) {//Esta caido hacia la derecha, busco balance de su hijo derecho;
					balanceHijo=calcularBalance(flagNodo.getDerecho());
					if(balanceHijo==-1 || balanceHijo==0) {//Rotacion simple Izquierda
						simpleADerecha(flagNodo);
					}else {
						if(balanceHijo==1) {
							simpleADerecha(flagNodo.getDerecho());
							simpleAIzquierda(flagNodo);
						}
					}
				}
			}
			
		}
	}
	
	private int calcularBalance(NodoAVL flagNodo) {
		int altIzq;
		int altDer;
		int balance;
		if (flagNodo.getIzquierdo() == null) { // Busco altura de los hijos
			altIzq = -1;
		} else {
			altIzq = flagNodo.getIzquierdo().getAltura();
		}

		if (flagNodo.getDerecho() == null) {
			altDer = -1;
		} else {
			altDer = flagNodo.getIzquierdo().getAltura();
		}

		balance= altIzq - altDer;
		return balance;
	}
	
	private void simpleADerecha(NodoAVL flagNodo) { //Recibe el nodo pivote a balancear
		NodoAVL auxHijoDerNodoIzq=flagNodo.getIzquierdo().getDerecho();
		flagNodo.getIzquierdo().setDerecho(flagNodo);
		flagNodo.setIzquierdo(auxHijoDerNodoIzq);
	}

	private void simpleAIzquierda(NodoAVL flagNodo) {
		NodoAVL auxHijoIzqNodoDer=flagNodo.getDerecho().getIzquierdo();
		flagNodo.getDerecho().setIzquierdo(flagNodo);
		flagNodo.setDerecho(auxHijoIzqNodoDer);
	}
}

