package Conjuntistas;

import lineales.dinamicas.*;

import jerarquicas.NodoArbol;

public class ABB {
	private NodoArbol raiz;

	public void ABB() {
		this.raiz = null;
	}

	public boolean insertar(Comparable elem) {
		boolean exito;
		if (this.raiz == null) {
			this.raiz = new NodoArbol(elem);
			exito = true;
		} else {
			exito = auxInsertar(this.raiz, elem);
		}
		return exito;

	}

	private boolean auxInsertar(NodoArbol flagNodo, Comparable elem) {
		boolean exito = true;
		if (elem.compareTo(flagNodo.getElem()) == 0) {
			exito = false;
		} else {
			if (elem.compareTo(flagNodo.getElem()) < 0) {
				if (flagNodo.getIzquierdo() != null) {
					exito = auxInsertar(flagNodo.getIzquierdo(), elem);
				} else {
					flagNodo.setIzquierdo(new NodoArbol(elem));
				}
			} else {
				if (flagNodo.getDerecho() != null) {
					exito = auxInsertar(flagNodo.getDerecho(), elem);
				} else {
					flagNodo.setDerecho(new NodoArbol(elem));
				}
			}
		}
		return exito;
	}

	public boolean eliminar(Comparable elem) {
		boolean exito = false;
		if (this.raiz != null) {
			exito = auxEliminar(this.raiz, elem);
		}

		return exito;
	}

	private boolean auxEliminar(NodoArbol flagNodo, Comparable elem) {
		boolean exito = false;
		NodoArbol candidato;
		if (flagNodo != null) {

			if (elem.compareTo(flagNodo.getElem()) < 0) {
				if (flagNodo.getIzquierdo() != null && elem.compareTo(flagNodo.getIzquierdo().getElem()) == 0) {
					exito = caso1(flagNodo, flagNodo.getIzquierdo());
					if (!exito) {
						exito = caso2(flagNodo, flagNodo.getIzquierdo());
					}

				}
				if (!exito) {
					exito = auxEliminar(flagNodo.getIzquierdo(), elem);
				}
			} else {
				if (elem.compareTo(flagNodo.getElem()) > 0) {
					if (flagNodo.getDerecho() != null && elem.compareTo(flagNodo.getDerecho().getElem()) == 0) {
						exito = caso1(flagNodo, flagNodo.getDerecho());
						if (!exito) {
							exito = caso2(flagNodo, flagNodo.getDerecho());
						}
					}
					if (!exito) {
						exito = auxEliminar(flagNodo.getDerecho(), elem);
					}
				} else {
					if (elem.compareTo(flagNodo.getElem()) == 0) {
						exito = caso3(flagNodo);
					}
				}
			}
		}

		return exito;
	}

	private boolean caso1(NodoArbol flagNodo, NodoArbol flagNodoElem) {
		boolean exito = false;

		if (flagNodoElem.getIzquierdo() == null && flagNodoElem.getDerecho() == null) {
			if (flagNodo.getIzquierdo() == flagNodoElem) { // Si mi elemento es el hijo izquierdo lo seteo en null ya
															// que es hoja
				flagNodo.setIzquierdo(null);
				exito = true;
			} else {
				if (flagNodo.getDerecho() == flagNodoElem) { // Si mi elemento es el hijo derecho lo seteo en null ya
																// que es hoja
					flagNodo.setDerecho(null);
					exito = true;
				}
			}
		}
		return exito;
	}

	private boolean caso2(NodoArbol flagNodo, NodoArbol flagNodoElem) {
		boolean exito = false;
		if (flagNodoElem.getIzquierdo() != null && flagNodoElem.getDerecho() == null) {// Si tiene
																						// hijo
																						// izquierdo
			if (flagNodo.getIzquierdo() == flagNodoElem) {
				flagNodo.setIzquierdo(flagNodoElem.getIzquierdo());
			} else {
				if (flagNodo.getDerecho() == flagNodoElem) {
					flagNodo.setDerecho(flagNodoElem.getIzquierdo());
				}
			}
			exito = true;
		} else {
			if (flagNodoElem.getIzquierdo() == null && flagNodoElem.getDerecho() != null) {// Si
																							// tiene
																							// hijo
																							// derecho
				if (flagNodo.getIzquierdo() == flagNodoElem) {
					flagNodo.setIzquierdo(flagNodoElem.getDerecho());
				} else {
					if (flagNodo.getDerecho() == flagNodoElem) {
						flagNodo.setDerecho(flagNodoElem.getDerecho());
					}
				}
				exito = true;
			}
		}
		return exito;
	}

	private boolean caso3(NodoArbol flagNodo) {
		Comparable candidato;
		boolean exito = false;
		if (flagNodo.getIzquierdo().getDerecho() == null) { // si el hijo izq de mi elemento es mi candidato
			candidato = (Comparable) flagNodo.getIzquierdo().getElem(); // Solo me interesa el valor
			if (!caso1(flagNodo, flagNodo.getIzquierdo())) { // Elimino al nodo de candidato
				caso2(flagNodo, flagNodo.getIzquierdo());
			}
		} else {// SI el hijo izquierdo tiene hijo derecho
			candidato = buscoCandidato(flagNodo.getIzquierdo()); // Bajo uno a la izquierda de mi elemento

		}
		flagNodo.setElem(candidato);
		exito = true;
		return exito;
	}

	private Comparable buscoCandidato(NodoArbol flagNodo) { // Siempre voy atener un hijo derecho al inicio
		Comparable candidato = null;
		if (flagNodo.getDerecho().getDerecho() == null && candidato == null) { // Si mi hijo derecho es hoja es decir el
																				// mayor elemento
			candidato = (Comparable) flagNodo.getDerecho().getElem();
			if (!caso1(flagNodo, flagNodo.getDerecho())) { // Elimino el candidato con caso 1 o 2
				caso2(flagNodo, flagNodo.getDerecho());
			} else {
				candidato = buscoCandidato(flagNodo.getDerecho());
			}
		}

		return candidato;
	}

	public boolean pertenece(Comparable elem) {
		boolean pertenece = false;
		if (this.raiz != null) {
			pertenece = auxPertenece(this.raiz, elem);
		}
		return pertenece;
	}

	private boolean auxPertenece(NodoArbol flagNodo, Comparable elem) {
		boolean pertenece = false;
		if (flagNodo != null) {
			if (elem.compareTo(flagNodo.getElem()) == 0) {
				pertenece = true;
			} else {
				if (elem.compareTo(flagNodo.getElem()) < 0) {
					pertenece = auxPertenece(flagNodo.getIzquierdo(), elem);
				} else {
					pertenece = auxPertenece(flagNodo.getDerecho(), elem);
				}
			}
		}
		return pertenece;
	}

	public Lista listar() {
		Lista lista = new Lista();
		if (this.raiz != null) {
			auxLista(this.raiz, lista);
		}
		return lista;
	}

	private void auxLista(NodoArbol flagNodo, Lista lista) {
		if (flagNodo != null) {
			auxLista(flagNodo.getIzquierdo(), lista);
			lista.insertar(flagNodo.getElem(), (lista.longitud() + 1));
			auxLista(flagNodo.getDerecho(), lista);
		}

	}

	public Lista listarRango(Comparable elemMin, Comparable elemMax) {
		Lista lista = new Lista();
		if (this.raiz != null) {
			auxListarRango(this.raiz, lista, elemMin, elemMax);
		}
		return lista;
	}

	private void auxListarRango(NodoArbol flagNodo, Lista lista, Comparable elemMin, Comparable elemMax) {
		if (flagNodo != null) {
			if (elemMin.compareTo(flagNodo.getElem()) < 0) { // si mi flagNodo es mayor igual al minimo
				auxListarRango(flagNodo.getIzquierdo(), lista, elemMin, elemMax);
			}
			if (elemMin.compareTo(flagNodo.getElem()) <= 0 && elemMax.compareTo(flagNodo.getElem()) >= 0) {
				lista.insertar(flagNodo.getElem(), (lista.longitud() + 1));
			}
			if (elemMax.compareTo(flagNodo.getElem()) > 0) {
				auxListarRango(flagNodo.getDerecho(), lista, elemMin, elemMax);
			}
		}
	}

	public Comparable minimoElem() {
		Comparable elem = null;
		if (this.raiz != null) {
			elem = auxMinimoElem(this.raiz);
		}
		return elem;
	}

	private Comparable auxMinimoElem(NodoArbol flagNodo) {
		Comparable elem = null;
		if (flagNodo != null) {
			if (flagNodo.getIzquierdo() == null) {
				elem = (Comparable) flagNodo.getElem();
			} else {
				elem = auxMinimoElem(flagNodo.getIzquierdo());
			}
		}
		return elem;
	}

	public Comparable maximoElem() {
		Comparable elem = null;
		if (this.raiz != null) {
			elem = auxMaximoElem(this.raiz);
		}
		return elem;
	}

	private Comparable auxMaximoElem(NodoArbol flagNodo) {
		Comparable elem = null;
		if (flagNodo != null) {
			if (flagNodo.getDerecho() == null) {
				elem = (Comparable) flagNodo.getElem();
			} else {
				elem = auxMaximoElem(flagNodo.getDerecho());
			}
		}
		return elem;
	}

	public boolean vacio() {
		return this.raiz == null;
	}

	public String toString() {
		String cadena = "(Vacio)";
		if (this.raiz != null) {
			cadena = auxToString(this.raiz);
		}
		return cadena;
	}

	private String auxToString(NodoArbol flagNodo) {
		String cadena = "";
		if (flagNodo != null) {
			if (flagNodo == this.raiz) {
				cadena += "RAIZ: ";
			}
			cadena += "(" + flagNodo.getElem() + ", ";

			if (flagNodo.getIzquierdo() != null) {
				cadena += "HI: " + flagNodo.getIzquierdo().getElem() + ", ";
			} else {
				cadena += "HI: null, ";
			}

			if (flagNodo.getDerecho() != null) {
				cadena += "HD: " + flagNodo.getDerecho().getElem() + "), ";
			} else {
				cadena += "HD: null), ";
			}
			cadena += auxToString(flagNodo.getIzquierdo());
			cadena += auxToString(flagNodo.getDerecho());
		}
		return cadena;
	}

	public Lista listarMayoresQue(Comparable valor, Comparable elem) {
		Lista lista = new Lista();
		if (this.raiz != null) {
			NodoArbol nodoElem = buscoElem(this.raiz, elem);
			if (nodoElem != null) {
				auxListarMayoresQue(nodoElem, lista, valor);
			}
		}
		return lista;
	}

	private void auxListarMayoresQue(NodoArbol flagNodo, Lista lista, Comparable valor) {
		if (flagNodo != null) {
			if (valor.compareTo(flagNodo.getElem()) < 0) {
				lista.insertar(flagNodo.getElem(), lista.longitud() + 1);
			}
			auxListarMayoresQue(flagNodo.getIzquierdo(), lista, valor);
			auxListarMayoresQue(flagNodo.getDerecho(), lista, valor);
		}
	}

	private NodoArbol buscoElem(NodoArbol flagNodo, Comparable elem) {
		NodoArbol nodoElem = null;
		if (flagNodo != null) {
			if (elem.compareTo(flagNodo.getElem()) == 0) {
				nodoElem = flagNodo;
			} else {
				if (elem.compareTo(flagNodo.getElem()) < 0) {
					nodoElem = buscoElem(flagNodo.getIzquierdo(), elem);
				} else {
					nodoElem = buscoElem(flagNodo.getDerecho(), elem);
				}
			}
		}
		return nodoElem;
	}

	public void eliminarMin() {
		if (this.raiz != null) {
			eliminarMinAux(this.raiz);
		}
	}

	private boolean eliminarMinAux(NodoArbol flagNodo) {
		boolean eliminado = false;
		if (flagNodo != null) {
			if (this.raiz.getIzquierdo() == null) {
				this.raiz = this.raiz.getDerecho();
				eliminado = true;
			} else {
				if (flagNodo.getIzquierdo() != null && flagNodo.getIzquierdo().getIzquierdo() == null) {
					flagNodo.setIzquierdo(flagNodo.getIzquierdo().getDerecho());
					eliminado = true;
				} else {
					eliminado = eliminarMinAux(flagNodo.getIzquierdo());
				}
			}
		}
		return eliminado;
	}

	public boolean equals(ABB otro) {
		boolean iguales = false;
		iguales = auxEquals(this.raiz, otro.raiz, otro);
		return iguales;
	}

	private boolean auxEquals(NodoArbol flagNodo, NodoArbol flagNodoOtro, ABB otro) {
		boolean iguales = true;
		if (flagNodo != null && flagNodoOtro != null) {
			if (flagNodo == this.raiz && flagNodoOtro == otro.raiz) {
				if (!flagNodo.getElem().equals(flagNodoOtro.getElem())) {
					iguales = false;
				}
			}
			if ((flagNodo.getIzquierdo() == null && flagNodoOtro.getIzquierdo() != null)
					|| (flagNodo.getIzquierdo() != null && flagNodoOtro.getIzquierdo() == null)) {
				iguales = false;
			} else {
				if ((flagNodo.getDerecho() == null && flagNodoOtro.getDerecho() != null)
						|| (flagNodo.getDerecho() != null && flagNodoOtro.getDerecho() == null)) {
					iguales = false;
				} else {
					if (flagNodo.getIzquierdo() != null && flagNodo.getDerecho() != null
							&& flagNodoOtro.getIzquierdo() != null && flagNodoOtro.getDerecho() != null) {
						if (!flagNodo.getIzquierdo().getElem().equals(flagNodoOtro.getIzquierdo().getElem())
								|| !flagNodo.getDerecho().getElem().equals(flagNodoOtro.getDerecho().getElem())) {
							iguales = false;
						}
					}
				}
			}
			if (iguales) {
				iguales = auxEquals(flagNodo.getIzquierdo(), flagNodoOtro.getIzquierdo(), otro);
				iguales = auxEquals(flagNodo.getDerecho(), flagNodoOtro.getDerecho(), otro);
			}
		}
		return iguales;
	}
}
