package jerarquicas;

import lineales.dinamicas.*;

public class ArbolGen {
	private NodoGen raiz;

	public ArbolGen() {
		this.raiz = null;
	}

	public boolean insertar(Object elem, Object elemPadre) {
		boolean exito = false;
		NodoGen flagNodo = this.raiz;
		if (this.raiz == null) {
			this.raiz = new NodoGen(elem, null, null);
			exito = true;
		} else {

			flagNodo = buscaElemPadre(this.raiz, elemPadre);// Busco al nodo padre

			if (flagNodo != null) { // Si encontre el padre
				if (flagNodo.getHijoIzq() == null) { // Si el padre no tiene ningun hijo entonces lo inserto ahi
					flagNodo.setHijoIzq(new NodoGen(elem, null, null));
					exito = true;
				} else {// Si ya tiene hijo izquierdo
					flagNodo = flagNodo.getHijoIzq();
					while (flagNodo.getHermanoDer() != null) { // Me desplazo hasta el ultimo hermano (Puede ser el
																// hijo izquierdo mismo)
						flagNodo = flagNodo.getHermanoDer();
					}
					flagNodo.setHermanoDer(new NodoGen(elem, null, null));
					exito = true;
				}
			}
		}
		return exito;
	}

	private NodoGen buscaElemPadre(NodoGen flagNodo, Object elemPadre) {
		NodoGen padre = null;
		if (flagNodo != null) {
			if (flagNodo.getElem().equals(elemPadre)) {
				padre = flagNodo;
			} else {
				padre = buscaElemPadre(flagNodo.getHijoIzq(), elemPadre);
				if (padre == null) {
					padre = buscaElemPadre(flagNodo.getHermanoDer(), elemPadre);
				}
			}
		}
		return padre;
	}

	public boolean pertenece(Object elem) {
		boolean encontrado = false;
		NodoGen nodoElem;
		if (this.raiz != null) {
			nodoElem=buscaElemPadre(this.raiz,elem); //Cumple la misma funcion que un auxBuscarElem
			if(nodoElem!=null) {
				encontrado=true;
			}
		}
		return encontrado;
	}


	public boolean esVacio() {
		return this.raiz == null;
	}

	public Object padre(Object elem) {
		Object padre = null;
		if (this.raiz != null) {
			padre = auxPadre(this.raiz, elem, null);
		}
		return padre;
	}

	private Object auxPadre(NodoGen flagNodo, Object elem, Object flagPadre) {
		Object padre = null;
		if (flagNodo != null) {
			if (flagNodo.getElem().equals(elem)) {
				padre = flagPadre;
			} else {
				padre = auxPadre(flagNodo.getHijoIzq(), elem, flagNodo.getElem());
				if (padre == null) {
					padre = auxPadre(flagNodo.getHermanoDer(), elem, flagPadre);
				}
			}
		}
		return padre;
	}

	public int altura() {
		int altura = -1;
		if (this.raiz != null) {
			altura = auxAltura(this.raiz);
		}
		return altura;
	}

	private int auxAltura(NodoGen flagNodo) {
		int altura1 = -1;
		int altura2 = -1;
		int alturaMax = -1;
		if (flagNodo != null) {
			altura1 = auxAltura(flagNodo.getHijoIzq()) + 1;
			altura2 = auxAltura(flagNodo.getHermanoDer());
		}
		alturaMax = altura1;
		if (altura2 > altura1) {
			alturaMax = altura2;
		}
		return alturaMax;
	}

	public int nivel(Object elem) {
		int nivel = -1;
		if (this.raiz != null) {
			nivel = auxNivel(this.raiz, elem, 0);
		}
		return nivel;
	}

	private int auxNivel(NodoGen flagNodo, Object elem, int cont) {
		int nivel = -1;
		if (flagNodo != null) {
			if (flagNodo.getElem().equals(elem)) {
				nivel = cont;
			} else {
				nivel = auxNivel(flagNodo.getHijoIzq(), elem, cont + 1);
				if (nivel == -1) {
					nivel = auxNivel(flagNodo.getHermanoDer(), elem, cont);
				}
			}
		}
		return nivel;
	}

	public Lista ancestros(Object elem) { // NO ME SALE
		Lista lista = new Lista();
		Pila pila = new Pila();
		if (this.raiz != null) {
			auxAncestros(this.raiz, elem, lista, pila);
		}
		return lista;
	}

	private void auxAncestros(NodoGen flagNodo, Object elem, Lista lista, Pila pila) {
		if (flagNodo != null) {
			if (flagNodo.getElem().equals(elem)) {
				while (!pila.esVacia()) {
					lista.insertar(pila.obtenerTope(), lista.longitud()+1);
					pila.desapilar();
				}
			} else {
				if (flagNodo.getHijoIzq() != null) {
					pila.apilar(flagNodo.getElem()); // Cada vez que paso por un HEI con hijos lo apilo (las hojas no ya
														// que no tendria sentido ya que no pueden ser acestros de
														// ningun nodo)
					auxAncestros(flagNodo.getHijoIzq(), elem, lista, pila);

					NodoGen hijo = flagNodo.getHijoIzq().getHermanoDer();
					while (hijo != null) {
						auxAncestros(hijo, elem, lista, pila);
						hijo = hijo.getHermanoDer();
					}

					if (!pila.esVacia()) { // A la vuelta de la recursion si todavia no encontre el elemento (Pila con elementos) desapilo 
											// hasta el ultimo HEI valido apilado
						pila.desapilar();
					}
				}
			}

		}

	}

	public ArbolGen clone() {
		ArbolGen clon = new ArbolGen();
		if (this.raiz != null) {
			clon.raiz = new NodoGen(this.raiz.getElem(), null, null);
			cloneAux(this.raiz, clon.raiz);
		}
		return clon;
	}

	public void cloneAux(NodoGen flagNodo, NodoGen flagClon) {
		if (flagNodo != null) {

			if (flagNodo.getHijoIzq() != null) {
				flagClon.setHijoIzq(new NodoGen(flagNodo.getHijoIzq().getElem(), null, null));
			}
			if (flagNodo.getHermanoDer() != null) {
				flagClon.setHermanoDer(new NodoGen(flagNodo.getHermanoDer().getElem(), null, null));
			}
			cloneAux(flagNodo.getHijoIzq(), flagClon.getHijoIzq());
			cloneAux(flagNodo.getHermanoDer(), flagClon.getHermanoDer());
		}
	}

	public void vaciar() {
		this.raiz = null;
	}

	public Lista listarPreOrden() {
		Lista lista = new Lista();
		if (this.raiz != null) {
			auxListarPreOrden(this.raiz, lista);
		}
		return lista;
	}

	private void auxListarPreOrden(NodoGen flagNodo, Lista lista) {
		if (flagNodo != null) {
			lista.insertar(flagNodo.getElem(), lista.longitud() + 1);
			if (flagNodo.getHijoIzq() != null) {
				NodoGen hijo = flagNodo.getHijoIzq();
				while (hijo != null) {
					auxListarPreOrden(hijo, lista);
					hijo = hijo.getHermanoDer();
				}
			}
		}
	}

	public Lista listarInOrden() {
		Lista lista = new Lista();
		if (this.raiz != null) {
			auxListarInOrden(this.raiz, lista);
		}
		return lista;
	}

	private void auxListarInOrden(NodoGen flagNodo, Lista lista) {
		if (flagNodo != null) {

			if (flagNodo.getHijoIzq() != null) {
				auxListarInOrden(flagNodo.getHijoIzq(), lista);
			}

			lista.insertar(flagNodo.getElem(), lista.longitud() + 1);

			if (flagNodo.getHijoIzq() != null) {
				NodoGen hijo = flagNodo.getHijoIzq().getHermanoDer();
				while (hijo != null) {
					auxListarInOrden(hijo, lista);
					hijo = hijo.getHermanoDer();
				}
			}
		}
	}

	public Lista listarPosOrden() {
		Lista lista = new Lista();
		if (this.raiz != null) {
			auxListarPosOrden(this.raiz, lista);
		}
		return lista;
	}

	private void auxListarPosOrden(NodoGen flagNodo, Lista lista) {
		if (flagNodo != null) {
			if (flagNodo.getHijoIzq() != null) {
				NodoGen hijo = flagNodo.getHijoIzq();
				while (hijo != null) {
					auxListarPosOrden(hijo, lista);
					hijo = hijo.getHermanoDer();
				}
			}
			lista.insertar(flagNodo.getElem(), lista.longitud() + 1);
		}
	}

	public Lista listarPorNiveles() {
		Lista lista = new Lista();
		if (this.raiz != null) {
			Cola cola = new Cola();
			cola.poner(this.raiz);
			while (!cola.esVacia()) {
				NodoGen nodo = (NodoGen) cola.obtenerFrente();
				cola.sacar();
				lista.insertar(nodo.getElem(), lista.longitud() + 1);
				nodo = nodo.getHijoIzq();
				while (nodo != null) {
					cola.poner(nodo);
					nodo = nodo.getHermanoDer();
				}
			}
		}
		return lista;

	}

	public String toString() {
		return toStringAux(this.raiz);
	}

	private String toStringAux(NodoGen flagNodo) {
		String cadena="";
		if(flagNodo!=null) {
			cadena+= flagNodo.getElem().toString()+" --> ";
			NodoGen hijo= flagNodo.getHijoIzq();
			while(hijo!=null) {
				cadena+=hijo.getElem().toString()+", ";
				hijo=hijo.getHermanoDer();
			}
			
			hijo=flagNodo.getHijoIzq();
			while(hijo!=null) {
				cadena+= "\n"+ toStringAux(hijo);
				hijo= hijo.getHermanoDer();
			}
		}
		return cadena;
	}
	public Lista frontera() {
		Lista lista= new Lista();
		if(this.raiz!=null) {
			auxFrontera(this.raiz, lista);
		}
		return lista;
	}
	private void auxFrontera(NodoGen flagNodo, Lista lista) {
		if (flagNodo != null) {
			if (flagNodo.getHijoIzq() != null) {
				NodoGen hijo = flagNodo.getHijoIzq();
				while (hijo != null) {
					auxFrontera(hijo, lista);
					hijo = hijo.getHermanoDer();
				}
			}
			if(flagNodo.getHijoIzq()==null) {
				lista.insertar(flagNodo.getElem(), lista.longitud()+1);
			}
		}
	}
	
	public Lista listaQueJustificaLaAltura() {//Camino de raiz a hoja mas lejana
		Lista camino=new Lista();
		Lista caminoMin=new Lista();
		if(this.raiz!=null) {
			caminoMin=auxListaQueJustificaLaAltura(this.raiz,camino,caminoMin);
		}
		return caminoMin;
	}
	
	private Lista auxListaQueJustificaLaAltura(NodoGen flagNodo,Lista camino, Lista caminoMin) {
		if(flagNodo!=null) {
			System.out.println(flagNodo.getElem());
			camino.insertar(flagNodo.getElem(), camino.longitud()+1);
			caminoMin=auxListaQueJustificaLaAltura(flagNodo.getHijoIzq(),camino,caminoMin);
			camino.eliminar(camino.longitud());
			caminoMin=auxListaQueJustificaLaAltura(flagNodo.getHermanoDer(),camino,caminoMin);
		}else {
			if(camino.longitud()>caminoMin.longitud()) {
				caminoMin=camino.clone();
			}
		}
		return caminoMin;
	}//Si busco el mas corto puede dar problema que hermano derecho sea null
	
	public int descendienteMasCercano(Object D) {
		int nivelMasCercano=-1;
		if(this.raiz!=null) {
			nivelMasCercano=auxDescendienteMasCercano(this.raiz,D, 0, -1);
		}
		return nivelMasCercano;
	}
	
	private int auxDescendienteMasCercano(NodoGen flagNodo,Object elem,int nivelAct, int nivelMin) {
		if(flagNodo!=null) {
			if(flagNodo.getElem().equals(elem)) {
				nivelMin=nivelAct;
			}else {
				nivelMin=auxDescendienteMasCercano(flagNodo.getHermanoDer(),elem,nivelAct,nivelMin);
				if(nivelMin==-1 || nivelAct<nivelMin) {
					nivelMin=auxDescendienteMasCercano(flagNodo.getHijoIzq(),elem,nivelAct+1,nivelMin);
				}
			}
		}
		return nivelMin;
	}
	
	public int descendienteMasLejano(Object d) {
		int menorNivel=-1;
		if(this.raiz!=null) {
			menorNivel=auxDescendienteMasLejano(this.raiz, d, 0, 0);
		}
		return menorNivel;
	}
	
	private int auxDescendienteMasLejano(NodoGen flagNodo,Object elem,int nivelAct, int nivelMax) {
		if(flagNodo!=null) {
			if(flagNodo.getElem().equals(elem) && nivelAct>nivelMax) {
				nivelMax=nivelAct;
			}
			nivelMax=auxDescendienteMasLejano(flagNodo.getHijoIzq(),elem, nivelAct+1,nivelMax);
			nivelMax=auxDescendienteMasLejano(flagNodo.getHermanoDer(),elem,nivelAct,nivelMax);
		}
		return nivelMax;
	}
	
	public Lista caminoHojaMasCercana() {
		Lista camino= new Lista();
		Lista caminoMin= new Lista();
		if(this.raiz!=null) {
			caminoMin=auxCaminoHojaMasCercana(this.raiz, camino,caminoMin);//Intercambiable
		}
		return caminoMin;
	}
	
	private Lista auxCaminoHojaMasCercana(NodoGen flagNodo, Lista camino, Lista caminoMin) {
		if(flagNodo!=null) {
			System.out.println(flagNodo.getElem());
			camino.insertar(flagNodo.getElem(), camino.longitud()+1);
			if(flagNodo.getHijoIzq()==null) {
				caminoMin=camino.clone();
			}else {
				if(camino.longitud()+1<caminoMin.longitud() || caminoMin.esVacia()) {
					caminoMin=this.auxCaminoHojaMasCercana(flagNodo.getHijoIzq(), camino, caminoMin);
					camino.eliminar(camino.longitud());
				}
				
				if(camino.longitud()<caminoMin.longitud() || caminoMin.esVacia()) {
					camino.eliminar(camino.longitud());
					caminoMin=this.auxCaminoHojaMasCercana(flagNodo.getHermanoDer(), camino, caminoMin);
				}
			}
		}
		return caminoMin;
	}
	
	private Lista auxCaminoHojaMasCercana2(NodoGen flagNodo, Lista camino, Lista caminoMin) {
		if(flagNodo!=null) {
			camino.insertar(flagNodo.getElem(), camino.longitud()+1);
			if(flagNodo.getHijoIzq()==null) {
				caminoMin=camino.clone();
			}else {
				if(caminoMin.esVacia() || camino.longitud()<caminoMin.longitud()) {
					if(flagNodo.getHermanoDer()!=null) {
						camino.eliminar(camino.longitud());
						caminoMin=this.auxCaminoHojaMasCercana2(flagNodo.getHermanoDer(), camino, caminoMin);
					}
				}
				if(caminoMin.esVacia() || camino.longitud()+1<caminoMin.longitud()) {
					caminoMin=this.auxCaminoHojaMasCercana2(flagNodo.getHijoIzq(), camino, caminoMin);
					camino.eliminar(camino.longitud());
				}
			}
		}
		return caminoMin;
	}

}
