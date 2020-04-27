package jerarquicas;

public class NodoGen {
	private Object elem;
	private NodoGen hijoIzq;
	private NodoGen hermanoDer;
	
	public NodoGen(Object elemento, NodoGen hei, NodoGen hd ) {
		this.elem=elemento;
		this.hijoIzq=hei;
		this.hermanoDer=hd;
	}
	
	public Object getElem() {
		return this.elem;
	}
	
	public NodoGen getHermanoDer() {
		return this.hermanoDer;
	}
	
	public NodoGen getHijoIzq() {
		return this.hijoIzq;
	}
	
	public void setElem(Object elemen) {
		this.elem=elemen;
	}
	
	public void setHijoIzq(NodoGen nodo) {
		this.hijoIzq=nodo;
	}
	
	public void setHermanoDer(NodoGen nodo) {
		this.hermanoDer=nodo;
	}
}
