package jerarquicas;
import lineales.dinamicas.*;
public class ArbolBin {
	private NodoArbol raiz;
	public ArbolBin() {
		this.raiz = null;
	}

	public boolean insertar(Object elemNuevo, Object padre, char pos) {
		boolean exito = false;
		NodoArbol nodoPadre;
		if (this.raiz == null ) {
			this.raiz = new NodoArbol(elemNuevo);
			exito = true;
		} else {
			nodoPadre = auxInsertar(padre, this.raiz);
			if (nodoPadre != null) {
				if ((pos == 'i' || pos == 'I') && nodoPadre.getIzquierdo() == null) {
					nodoPadre.setIzquierdo(new NodoArbol(elemNuevo));
					exito = true;
				} else {
					if ((pos == 'd' || pos == 'D') && nodoPadre.getDerecho() == null) {
						nodoPadre.setDerecho(new NodoArbol(elemNuevo));
						exito = true;
					}

				}
			}
		}
		return exito;
	}

	private NodoArbol auxInsertar(Object padre, NodoArbol flagNodo) {
		NodoArbol nodoPadre = null;
		if (flagNodo != null) {
			if (flagNodo.getElem().equals(padre)) {
				nodoPadre = flagNodo;
			} else {
				nodoPadre = auxInsertar(padre, flagNodo.getIzquierdo());
				if (nodoPadre == null) {
					nodoPadre = auxInsertar(padre, flagNodo.getDerecho());
				}
			}
		}
		return nodoPadre;
	}

	public boolean esVacio() {
		return this.raiz == null;
	}

	public Object padre(Object elem) {
		Object padre = null;
		if (this.raiz!=null && elem != null) {
			padre = auxPadre(elem, this.raiz);
		}
		return padre;
	}

	private Object auxPadre(Object elem, NodoArbol flagNodo) {
		Object padre = null;
		if (flagNodo != null) {
			if ((flagNodo.getIzquierdo() != null && flagNodo.getIzquierdo().getElem().equals(elem))
					|| (flagNodo.getDerecho() != null && flagNodo.getDerecho().getElem().equals(elem))) {
				padre = flagNodo.getElem();
			} else {
				padre = auxPadre(elem, flagNodo.getIzquierdo());
				if (padre == null) {
					padre = auxPadre(elem, flagNodo.getDerecho());
				}
			}
		}
		return padre;
	}

	public int altura() {
		int altura=-1;
		if(this.raiz!=null) {
			altura=auxAltura(this.raiz);
		}
		return altura;
	}

	private int auxAltura(NodoArbol flagNodo) {
		int alturaIzq = 0;
		int alturaDer = 0;
		int alturaMax;
		if (flagNodo != null) {
			
			alturaIzq = auxAltura(flagNodo.getIzquierdo()) + 1;
			
			alturaDer = auxAltura(flagNodo.getDerecho()) + 1;
			
		}
		
		alturaMax = alturaIzq;
		if (alturaDer > alturaMax) {
			alturaMax = alturaDer;
		}

		return alturaMax;
	}

	public int nivel(Object elem) {
		int nivel = -1;
		if (this.raiz != null) {
			nivel = auxNivel(this.raiz, elem, -1);
		}
		return nivel;
	}

	private int auxNivel(NodoArbol flagNodo, Object elem, int nivel) {
		int resultado = -1;
		if (flagNodo != null) {
			if (flagNodo.getElem().equals(elem)) {
				resultado = nivel+1;
			} else {
				resultado = auxNivel(flagNodo.getIzquierdo(), elem, nivel + 1);
				if (resultado == -1) {
					resultado = auxNivel(flagNodo.getDerecho(), elem, nivel + 1);
				}
			}
		}
		
		return resultado;
	}

	public void vaciar() {
		this.raiz = null;
	}

	public ArbolBin clonar() {
		ArbolBin clon = new ArbolBin();
		clone(this.raiz, clon, clon.raiz);
		return clon;
	}

	private void clone(NodoArbol flagNodo, ArbolBin clon, NodoArbol flagClon) {
		if (flagNodo != null) {
			if (flagNodo == this.raiz) {
				clon.raiz = new NodoArbol(this.raiz.getElem());
				flagClon = clon.raiz;
			}

			if (flagNodo.getIzquierdo() != null) {
				flagClon.setIzquierdo(new NodoArbol(flagNodo.getIzquierdo().getElem()));
			}
			if (flagNodo.getDerecho() != null) {
				flagClon.setDerecho(new NodoArbol(flagNodo.getDerecho().getElem()));
			}
			clone(flagNodo.getIzquierdo(), clon, flagClon.getIzquierdo());
			clone(flagNodo.getDerecho(), clon, flagClon.getDerecho());
		}

	}

	public String toString() {
		String cadena="(Vacio)";
		if(this.raiz!=null) {
			cadena=auxToString(this.raiz);
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
			cadena+=auxToString(flagNodo.getIzquierdo());
			cadena+=auxToString(flagNodo.getDerecho());
		}
		return cadena;
	}
	
	public Lista listarPreorden() {
		Lista lista= new Lista();
		preOrden(this.raiz,lista);
		return lista;
	}
	
	private void preOrden(NodoArbol flagNodo, Lista lista) {
		if(flagNodo!=null) {
			lista.insertar(flagNodo.getElem(), (lista.longitud()+1));
			preOrden(flagNodo.getIzquierdo(),lista);
			preOrden(flagNodo.getDerecho(),lista);
		}

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
	
	public Lista listarPosorden() {
		Lista lista= new Lista();
		posOrden(this.raiz,lista);
		return lista;
	}
	
	private void posOrden(NodoArbol flagNodo,Lista lista) {
		if(flagNodo!=null) {
			posOrden(flagNodo.getIzquierdo(), lista);
			posOrden(flagNodo.getDerecho(),lista);
			lista.insertar(flagNodo.getElem(), (lista.longitud()+1));
		}
	}
	
	public Lista listarNiveles() {
		Lista lista= new Lista();
		Cola cola= new Cola();
		NodoArbol nodo;
		cola.poner(this.raiz);
		while(!cola.esVacia()) {
			nodo=(NodoArbol) cola.obtenerFrente();
			cola.sacar();
			lista.insertar(nodo.getElem(), 1);
			if(nodo.getIzquierdo()!=null) {
				cola.poner(nodo.getIzquierdo());
			}
			if(nodo.getDerecho()!=null) {
				cola.poner(nodo.getDerecho());
			}
		}
		lista=lista.invertir();
		return lista;
	}
	
	public NodoArbol obtenerNodo(Object elem) {
		NodoArbol nodo=null;
		if(this.raiz!=null) {
			nodo=auxObtenerNodo(this.raiz,elem);
		}
		return nodo;
	}
	
	private NodoArbol auxObtenerNodo(NodoArbol flagNodo,Object elem) {
		NodoArbol nodo=null;
		if(flagNodo!=null) {
			if(flagNodo.getElem().equals(elem)) {
				nodo=flagNodo;
			}else {
				nodo=auxObtenerNodo(flagNodo.getIzquierdo(),elem);
				if(nodo==null) {
				nodo=auxObtenerNodo(flagNodo.getDerecho(),elem);
				}
			}
		}
		return nodo;
	}
	
	public Lista obtenerAncestros(Object elem) {
		Lista lista=new Lista();
		if(this.raiz!=null) {
			auxAncestros(this.raiz,elem,lista,null);
		}
		return lista;
	}
	
	private boolean auxAncestros(NodoArbol flagNodo,Object elem, Lista lista, NodoArbol flagPadre) {
		boolean encontrado=false;
		if(flagNodo!=null) {
			if((flagNodo.getElem().equals(elem))) {
				encontrado=true;
			}else {
				encontrado=auxAncestros(flagNodo.getIzquierdo(),elem,lista,flagNodo);
				if(encontrado==false) {
				encontrado=auxAncestros(flagNodo.getDerecho(),elem,lista,flagNodo);
				}
			}
			
			if(flagPadre!=null && encontrado) {
				lista.insertar(flagPadre.getElem(), lista.longitud()+1);
			}
			
		}
		
		return encontrado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
