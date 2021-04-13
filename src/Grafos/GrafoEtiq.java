package Grafos;
import lineales.dinamicas.Lista;
public class GrafoEtiq {
	private NodoVert inicio = null;

	public GrafoEtiq() {
	}

	public boolean insertarVertice(Object nuevoVertice) {
		boolean exito = false;
		NodoVert aux = this.ubicarVertice(nuevoVertice);
		if (aux == null) {// Si no esta en la lista de nodos
			this.inicio = new NodoVert(nuevoVertice, this.inicio);// El nuevo nodo pasa a ser el inicio
			exito = true;
		}
		return exito;
	}

	private NodoVert ubicarVertice(Object buscado) {// Busca un vertice
		NodoVert aux = this.inicio;
		while (aux != null && !aux.getElem().equals(buscado)) {
			aux = aux.getSigVertice();
		}
		return aux;
	}

	public boolean eliminarVertice(Object verticeElim) {
		boolean exito = false;
		NodoVert anterior;
		NodoVert nodoActual = this.inicio;
		if (this.inicio != null) {
			if (this.inicio.getElem() == verticeElim) {
				this.inicio = this.inicio.getSigVertice();
				exito = true;
			} else {
				anterior = this.buscaAnterior(verticeElim);
				if (anterior != null) {
					anterior.setSigVert(anterior.getSigVertice().getSigVertice());
					while (nodoActual != null) {// Voy nodo por nodo verificando si son adyacentes con vertice elim
						this.eliminaArcos(nodoActual, verticeElim);
						nodoActual = nodoActual.getSigVertice();
					}
					exito = true;
				}
			}
		}
		return exito;
	}

	private NodoVert buscaAnterior(Object verticeElim) {
		NodoVert aux = this.inicio;
		while (aux.getSigVertice() != null && aux.getSigVertice().getElem() != verticeElim) {
			aux = aux.getSigVertice();
		}
		if(aux.getSigVertice()==null) {//Si estoy en el ultimo elemento, este no es anterior de nada entonces retorna null
			aux=null;
		}
		return aux;// Retorna el vertice anterior al que tengo que eliminar si no lo encuentra
					// retorna null
	}

	private void eliminaArcos(NodoVert nodoAct, Object verticeElim) {
		NodoVert nodo = nodoAct;
		NodoAdy ady=nodoAct.getPrimerAdy();//Me paro en el primer adyacente para comparar con el segundo
		while (ady!=null && ady.getSigAdyacente() != null) {//Mientras tenga adyacentes
			if (nodo.getPrimerAdy().getVertice().getElem() == verticeElim) {// Si el primer adyacente es el nodo eliminado
				nodo.setPrimerAdy(nodo.getPrimerAdy().getSigAdyacente());// Elimino ese adyacente (arco)
			}else {//Si el primer adyacente no es el nodo a eliminar
				if(ady.getSigAdyacente().getVertice().getElem()==verticeElim) {//Si el siguiente adyacente es el nodo a eliminar
					ady.setSigAdyacente(ady.getSigAdyacente().getSigAdyacente());//Lo elimino
				}
			}
			if (nodo.getPrimerAdy() != null) {// Por si no me quedan adyacentes por eliminar
				ady=ady.getSigAdyacente();//Me muevo al siguiente adyacente
			}
		}

	}
	
	public boolean existeVertice(Object elemVertice) {
		boolean existe=false;
		if(this.ubicarVertice(elemVertice)!=null) {
			existe=true;
		}
		return existe;
	}
	
	public boolean insertarArco(Object elemOrig, Object elemDest, int etiqueta) {
		NodoVert origen= this.ubicarVertice(elemOrig);
		NodoVert destino= this.ubicarVertice(elemDest);
		boolean exito=false;
		if(origen!=null && destino!=null) {
				origen.setPrimerAdy(new NodoAdy(destino,origen.getPrimerAdy(),etiqueta));
				exito=true;
		}
		return exito;
	}
	
	
	public boolean eliminarArco(Object elemOrig, Object elemDest) {
		boolean exito=false;
		NodoVert origen= this.ubicarVertice(elemOrig);
		NodoVert destino= this.ubicarVertice(elemDest);
		NodoAdy adyAnterior;
		if(origen.getPrimerAdy()!=null) {
			if(origen.getPrimerAdy().getVertice()==destino) {
				origen.setPrimerAdy(origen.getPrimerAdy().getSigAdyacente());
				exito=true;
			}else {
				adyAnterior= this.buscaAdyAnterior(origen.getPrimerAdy(), destino);
				if(adyAnterior!=null) {//Si encontre un arco
					adyAnterior.setSigAdyacente(adyAnterior.getSigAdyacente().getSigAdyacente());
					exito=true;
				}
			}
		}
		return exito;
	}
	
	private NodoAdy buscaAdyAnterior(NodoAdy adyActual, NodoVert destino) {
		NodoAdy adyAnterior=adyActual;
		while(adyAnterior.getSigAdyacente()!=null && adyAnterior.getSigAdyacente().getVertice()!=destino) {
			adyAnterior= adyAnterior.getSigAdyacente();
		}
		if(adyAnterior.getSigAdyacente()==null ) {//Si llegue al ultimo es que no hay arco
			adyAnterior=null;
		}
		return adyAnterior;
	}
	
	public boolean existeArco(Object elemOrigen, Object elemDestino) {
		boolean existe=false;
		NodoVert origen= this.ubicarVertice(elemOrigen);
		NodoVert destino= this.ubicarVertice(elemDestino);
		NodoAdy adyAnterior;
		if(origen!=null && origen.getPrimerAdy()!=null) {
			if(origen.getPrimerAdy().getVertice()==destino) {
				existe=true;
			}else {
				adyAnterior= this.buscaAdyAnterior(origen.getPrimerAdy(), destino);
				if(adyAnterior!=null) {//Si encontre un arco
					existe=true;
				}
			}
				
		}
		return existe;
	}
	
	public void modificarEtiquetaArco(Object elemOrigen, Object elemDestino,int nuevaEtiq) {
		NodoVert origen= this.ubicarVertice(elemOrigen);
		NodoVert destino= this.ubicarVertice(elemDestino);
		NodoAdy adyAnterior;
		if(origen.getPrimerAdy()!=null) {
			if(origen.getPrimerAdy().getVertice()==destino) {

				origen.getPrimerAdy().setEtiqueta(nuevaEtiq);
			}else {
				adyAnterior= this.buscaAdyAnterior(origen.getPrimerAdy(), destino);
				if(adyAnterior!=null) {//Si encontre un arco
					adyAnterior.getSigAdyacente().setEtiqueta(nuevaEtiq);
				}
			}
		}
	
	}
	
	public boolean existeCamino(Object origen, Object destino) {
		boolean exito=false;
		NodoVert auxO=null;
		NodoVert auxD=null;
		NodoVert aux=this.inicio;
		while((auxO==null|| auxD==null)&& aux!=null) {
			if(aux.getElem().equals(origen)) {
				auxO=aux;
			}
			if(aux.getElem().equals(destino)) {
				auxD=aux;
			}
			aux= aux.getSigVertice();
		}
		if(auxO!=null && auxD!=null) {
			Lista visitados= new Lista();
			exito=existeCaminoAux(auxO,destino, visitados);
		}
		return exito;
	}
	
	private boolean existeCaminoAux(NodoVert n, Object dest, Lista vis) {
		boolean exito=false;
		if(n!=null) {
			if(n.getElem().equals(dest)) {
				exito=true;
			}else {
				vis.insertar(n.getElem(), vis.longitud()+1);
				NodoAdy ady= n.getPrimerAdy();
				while(!exito && ady!=null) {
					if(vis.localizar(ady.getVertice().getElem())<0) {
						exito=existeCaminoAux(ady.getVertice(),dest,vis);
					}
					ady=ady.getSigAdyacente();
				}
			}
		}
		return exito;
	}
	
	public boolean vacio() {
		return this.inicio==null;
	}
	public Lista listarEnProfundidad() {
		Lista visitados = new Lista();
		NodoVert aux = this.inicio;
		while (aux != null) {
			if (visitados.localizar(aux.getElem()) < 0) {
				listarEnProfundidadAux(aux, visitados);
			}
			aux = aux.getSigVertice();
		}
		return visitados;
	}

	private void listarEnProfundidadAux(NodoVert n, Lista vis) {
		if(n!=null) {
			vis.insertar(n.getElem(), vis.longitud() + 1);
			NodoAdy ady = n.getPrimerAdy();
			while (ady != null) {
				if (vis.localizar(ady.getVertice().getElem()) < 0) {
					listarEnProfundidadAux(ady.getVertice(), vis);
				}
				ady = ady.getSigAdyacente();
			}
		}
	}
	
	public Lista caminoMenorLong(Object origen,Object destino) {
		Lista camino= new Lista();
		Lista masCorto=new Lista();
		NodoVert inicio=this.ubicarVertice(origen);
		NodoVert fin=this.ubicarVertice(destino);
		if(inicio!=null && fin!=null) {
			masCorto=caminoMasCortoAux(inicio,fin,camino,masCorto);
		}
		return masCorto;
	}
	
	private Lista caminoMasCortoAux(NodoVert flagNodo,Object destino,Lista camino, Lista masCorto) {
		if(flagNodo!=null) {
			camino.insertar(flagNodo.getElem().toString(), camino.longitud()+1);//inserto el destino
			if(flagNodo.getElem().equals(destino)) {//Si llegue al destino
				if((camino.longitud()<masCorto.longitud()) || masCorto.longitud()==0) {//Si el camino es menor al mas corto o es el primero sera el menor
					masCorto=camino.clone();
				}
			}else {
				NodoAdy ady=flagNodo.getPrimerAdy();//Veo el siguiente adyacente
				while(ady!=null) {
					if(camino.localizar(ady.getVertice().getElem().toString())<0) {
						if(masCorto.longitud()==0 || camino.longitud()+1<masCorto.longitud()) {
							masCorto=caminoMasCortoAux(ady.getVertice(),destino,camino,masCorto);
						}
					}
					ady=ady.getSigAdyacente();
				}
			}
			camino.eliminar(camino.longitud());
		}
		return masCorto;
	}
	
	public Lista caminoEnNVuelos(Object origen,Object destino, int nroMax) {
		Lista camino= new Lista();
		Lista masCorto=new Lista();
		NodoVert inicio=this.ubicarVertice(origen);
		NodoVert fin=this.ubicarVertice(destino);
		if(inicio!=null && fin!=null) {
			masCorto=caminoEnNVuelosAux(inicio,fin,camino,masCorto,nroMax,0);
		}
		return masCorto;
	}
	
	private Lista caminoEnNVuelosAux(NodoVert flagNodo ,Object destino,Lista camino, Lista masCorto,int nroMax, int nroRecorrido) {
		if(flagNodo!=null && nroRecorrido<=nroMax && masCorto.esVacia()) {//Corto si llegue al limite del recorrido o si ya tengo un camino que cumpla
			camino.insertar(flagNodo.getElem(), camino.longitud()+1);//Listo donde estoy parado
			//System.out.println(flagNodo.getElem()+"      "+nroRecorrido+"\n Lista visit: "+camino.toString()+"\nLista mas corto: "+masCorto.toString());
			if(flagNodo.equals(destino)) {//Si llegue al destino
				masCorto=camino.clone();
			}else {
				NodoAdy ady=flagNodo.getPrimerAdy();//Paso al siguiente adyacente
				while(ady!=null) {
					if(camino.localizar(ady.getVertice().getElem())<0) {//Si todavia no pase por el adyacente
						masCorto=this.caminoEnNVuelosAux(ady.getVertice(), destino, camino,masCorto,nroMax,nroRecorrido+1);//Voy a ese adyacente indicando que realizo un vuelo
					}
					ady=ady.getSigAdyacente();//Una vez termino el recorrido del ady va al siguiente
				}
			}
			camino.eliminar(camino.longitud());//del camino elimino el ultimo;
		}
		return masCorto;
	}
	
	public Object [] caminoMenorTiempo(Object origen,Object destino) {
		Lista camino= new Lista();
		Lista masCorto=new Lista();
		NodoVert inicio=this.ubicarVertice(origen);
		NodoVert fin=this.ubicarVertice(destino);
		Object [] array=new Object[2];
		if(inicio!=null && fin!=null) {
			camino.insertar(0, 1);//En la posicion 1 voy a guardar la longitud del camino mas corto hasta el momento
			masCorto.insertar(0, 1);
			masCorto=caminoMenorTiempoAux(inicio,fin,camino,masCorto,0);
			array[0]=masCorto.recuperar(1);//A la posicion 0 del arreglo le asigno el tiempo para imprimirlo si se desea
			masCorto.eliminar(1);//Elimino el tiempo de la lista
			array[1]=masCorto;//A la posicion 1 del arreglo le asigno la lista que contiene el camino de menor tiempo
		}
		return array;
	}
	
	private Lista caminoMenorTiempoAux(NodoVert flagNodo,Object fin,Lista camino, Lista masCorto,int tiempoRecorrido) {
		if(flagNodo!=null) {
			camino.insertar(flagNodo.getElem(), camino.longitud()+1);
			if(flagNodo.equals(fin)) {
				if((int)masCorto.recuperar(1)>tiempoRecorrido || (int)masCorto.recuperar(1)==0) {
					masCorto=camino.clone();//Reemplazo el recorrido mas corto
					masCorto.insertar(tiempoRecorrido, 1);//Guardo el tiempo,Se desplazan los otros uno a la derecha
				}
			}else {
				NodoAdy ady=flagNodo.getPrimerAdy();
				while(ady!=null ) {
					if(camino.localizar(ady.getVertice().getElem())<0) {//Mientras no haya pasado por el ady
						if((tiempoRecorrido + ((int)ady.getEtiqueta()))<(int)masCorto.recuperar(1) || (int)masCorto.recuperar(1)==0) {
							masCorto=caminoMenorTiempoAux(ady.getVertice(),fin,camino,masCorto,tiempoRecorrido+(int)ady.getEtiqueta());
						}
					}
					ady=ady.getSigAdyacente();
				}
			}
			camino.eliminar(camino.longitud());
			
		}
		return masCorto;
	}
	
	public Object[] caminoMasCortoConIntermedio(Object origen,Object destino, Object intermedio) {
		Lista camino= new Lista();
		Lista masCorto=new Lista();
		NodoVert inicio=this.ubicarVertice(origen);
		NodoVert fin=this.ubicarVertice(destino);
		NodoVert medio=this.ubicarVertice(intermedio);
		Object [] array=new Object[2];
		if(inicio!=null && fin!=null) {
			masCorto.insertar(0, 1);//En la posicion 1 voy a guardar la longitud del camino mas corto hasta el momento
			camino.insertar(0, 1);
			masCorto=caminoMasCortoConIntermedioAux(inicio,medio,fin,camino,masCorto,false,0);
			array[0]=masCorto.recuperar(1);//A la posicion 0 del arreglo le asigno el tiempo para imprimirlo si se desea
			masCorto.eliminar(1);//Elimino el tiempo de la lista
			array[1]=masCorto;//A la posicion 1 del arreglo le asigno la lista que contiene el camino de menor tiempo
		}
		return array;
	}
	
	public Lista caminoMasCortoConIntermedioAux(NodoVert flagNodo,Object intermedio,Object fin,Lista camino,Lista masCorto,boolean encontrado,int tiempoRecorrido ) {
		if(flagNodo!=null) {
			if(!flagNodo.equals(fin) && flagNodo.equals(intermedio)) {
				encontrado=true;
			}
			camino.insertar(flagNodo.getElem(), camino.longitud()+1);
			if(flagNodo.equals(fin) && encontrado) {//Si llegue al final y encontre el intermedio
				if((int)masCorto.recuperar(1)>tiempoRecorrido || (int)masCorto.recuperar(1)==0 ) {
					masCorto=camino.clone();//Reemplazo el recorrido mas corto
					masCorto.insertar(tiempoRecorrido, 1);//Guardo el tiempo,Se desplazan los otros uno a la derecha
				}
			}else {
				NodoAdy ady=flagNodo.getPrimerAdy();
				while(ady!=null ) {
					if(camino.localizar(ady.getVertice().getElem())<0) {
						if((tiempoRecorrido + ((int)ady.getEtiqueta()))<(int)masCorto.recuperar(1) || (int)masCorto.recuperar(1)==0) {
							masCorto=caminoMasCortoConIntermedioAux(ady.getVertice(),intermedio,fin,camino,masCorto,encontrado,tiempoRecorrido+(int)ady.getEtiqueta());
						}
					}
					ady=ady.getSigAdyacente();
				}
			}
			camino.eliminar(camino.longitud());
		}
		return masCorto;
	}
	
	public String toString() {//Lo que esta entre parentesis, en la cadena retornada, es la etiqueta
		Lista listaAdy=new Lista();
		String cadena=this.toStringAux(this.inicio, listaAdy,"");
		return cadena;
	}

	private String toStringAux(NodoVert flagNodo,Lista listaAdy,String cadena) {
		NodoAdy ady;
		if(flagNodo!=null) {
			cadena+=flagNodo.getElem()+", Nodos adyacentes: ";
			ady=flagNodo.getPrimerAdy();
			while(ady!=null) {//Listo cada adyacente del nodo
				
				listaAdy.insertar(ady.getVertice().getElem()+"("+ady.getEtiqueta()+")", listaAdy.longitud()+1);
				ady=ady.getSigAdyacente();
			}
			cadena+=listaAdy.toString()+"\n";//Muestro la lista en la cadena
			listaAdy.vaciar();//Vacio la lista
			
			cadena=toStringAux(flagNodo.getSigVertice(),listaAdy,cadena);
	
		}
		return cadena;
	}
	
	/*public Lista caminoDePesoMenorA(Object origen,Object destino,int pesoMax){
		Lista caminoMin= new Lista();
		Lista camino= new Lista();
		NodoVert nodoOrigen= ubicarVertice(origen);
		NodoVert nodoDestino= ubicarVertice(destino);
		this.auxCaminoDePesoMenorA(nodoOrigen, nodoDestino, pesoMax, camino, caminoMin,0);
		return caminoMin;
	}
	
	private Lista auxCaminoDePesoMenorA(NodoVert flagNodo,NodoVert destino,int pesoMax,Lista camino,Lista caminoMin,int pesoActual) {
		if(flagNodo!=null && pesoActual<=pesoMax && caminoMin.esVacia()) {
			camino.insertar(flagNodo.getElem(), camino.longitud()+1);
			if(flagNodo.getElem().equals(destino.getElem())) {
				if(pesoActual<pesoMax) {
					caminoMin=camino.clone();
				}
			}else {
				NodoAdy ady=flagNodo.getPrimerAdy();
				while(ady!=null) {
					if(camino.localizar(ady.getVertice().getElem())==-1) {//Si no pase por ese adyacente, accedo a el
						caminoMin=this.auxCaminoDePesoMenorA(ady.getVertice(), destino, pesoMax, camino, caminoMin, pesoActual+(int)ady.getEtiqueta());
					}
					ady=ady.getSigAdyacente();
				}
			}
			camino.eliminar(camino.longitud());//Elimino el ultimo elemento de camino para que no se acumule con la recursion
		}
		return caminoMin;
	}*/
	
	/*public Lista caminoDeLongitudMenorA(Object origen, Object destino, int longMax) {
		NodoVert nodoOrigen= this.ubicarVertice(origen);
		NodoVert nodoDestino= this.ubicarVertice(destino);
		Lista caminoMin= new Lista();
		Lista camino=new Lista();
		if(nodoOrigen!=null && nodoDestino!=null) {
			caminoMin=auxCaminoDeLongMenorA(nodoOrigen,destino,longMax,0,camino,caminoMin);
		}
		return caminoMin;
	}
	
	private Lista auxCaminoDeLongMenorA(NodoVert flagNodo, Object destino, int longMax, int longi, Lista camino, Lista caminoMin) {
		if(flagNodo!=null && longi<=longMax && caminoMin.esVacia()) {
			camino.insertar(flagNodo.getElem(), camino.longitud()+1);
			if(flagNodo.getElem().equals(destino)) {
				caminoMin=camino.clone();
			}else {
				NodoAdy ady= flagNodo.getPrimerAdy();
				while(ady!=null) {
					if(camino.localizar(ady.getVertice().getElem())==-1) {
						caminoMin=auxCaminoDeLongMenorA(ady.getVertice(),destino,longMax,longi+(int)ady.getEtiqueta(),camino,caminoMin);
					}
					ady=ady.getSigAdyacente();
				}
			}
			camino.eliminar(camino.longitud());
		}
		return caminoMin;
	}*/
	
	/*public Lista caminosDePesoEntre(Object origen, Object destino, int pesoMin, int pesoMax) {
		NodoVert nodoOrigen= ubicarVertice(origen);
		NodoVert nodoDest= ubicarVertice(destino);
		Lista camino=new Lista();
		Lista caminoMin= new Lista();
		if(nodoOrigen!=null && nodoDest!=null) {
			caminoMin=auxCaminosDePesoEntre(nodoOrigen,destino,pesoMin,pesoMax,camino,caminoMin,0);
		}
		return caminoMin;
	}
	
	private Lista auxCaminosDePesoEntre(NodoVert flagNodo, Object destino, int pesoMin, int pesoMax, Lista camino, Lista caminoEnt, int peso) {
		if(flagNodo!=null && peso<=pesoMax && caminoEnt.esVacia()) {
			camino.insertar(flagNodo.getElem(), camino.longitud()+1);
			if(flagNodo.getElem().equals(destino) && peso>=pesoMin) {
				caminoEnt=camino.clone();
			}else {
				NodoAdy ady=flagNodo.getPrimerAdy();
				while(ady!=null) {
					if(camino.localizar(ady.getVertice().getElem())==-1) {
						caminoEnt=this.auxCaminosDePesoEntre(ady.getVertice(), destino, pesoMin, pesoMax, camino, caminoEnt, peso+(int)ady.getEtiqueta());
					}
					ady=ady.getSigAdyacente();
				}
			}
			camino.eliminar(camino.longitud());
		}
		return caminoEnt;
	}*/
	
	public Lista caminoConIntermedio(Object origen, Object medio,Object destino) {
		NodoVert nodoOrigen= ubicarVertice(origen);
		NodoVert nodoMedio= ubicarVertice(medio);
		NodoVert nodoDest= ubicarVertice(destino);
		Lista camino=new Lista();
		Lista caminoMin= new Lista();
		caminoMin.insertar(-1, 1);
		if(nodoOrigen!=null && nodoMedio!=null &&nodoDest!=null) {
			caminoMin=auxCaminoConIntermedio(nodoOrigen,medio, destino, camino,caminoMin,false,0);
			caminoMin.eliminar(1);
		}
		return caminoMin;
	}
	
	public Lista auxCaminoConIntermedio(NodoVert flagNodo,Object medio, Object destino, Lista camino, Lista caminoMin, boolean pasoMed,int peso) {
		if(flagNodo!=null && peso<=(int)caminoMin.recuperar(1) || (int) caminoMin.recuperar(1)==-1) {
			camino.insertar(flagNodo.getElem(), camino.longitud()+1);
			if(flagNodo.getElem().equals(destino) && pasoMed) {
				caminoMin=camino.clone();
				caminoMin.insertar(peso, 1);
			}else {
				if(!flagNodo.getElem().equals(destino)) {
					if(flagNodo.getElem().equals(medio)) {
						pasoMed=true;
					}
					NodoAdy ady=flagNodo.getPrimerAdy();
					while(ady!=null) {
						if(camino.localizar(ady.getVertice().getElem())==-1) {
							caminoMin=this.auxCaminoConIntermedio(ady.getVertice(), medio, destino, camino, caminoMin, pasoMed, peso+(int)ady.getEtiqueta());
						}
						ady=ady.getSigAdyacente();
					}
				}
			}
			camino.eliminar(camino.longitud());
		}
		return caminoMin;
	}
}
