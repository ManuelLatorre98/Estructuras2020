package Grafos;

public class NodoVert {
	private Object elem;
	private NodoVert sigVertice;
	private NodoAdy primerAdy;
	
	public NodoVert(Object elemento, NodoVert sigVert) {
		this.elem=elemento;
		this.sigVertice=sigVert;
	}
	
	public Object getElem() {
		return this.elem;
	}
	
	public NodoVert getSigVertice() {
		return this.sigVertice;
	}
	
	public NodoAdy getPrimerAdy() {
		return this.primerAdy;
	}
	
	public void setElem(Object elemento) {
		this.elem=elemento;
	}
	
	public void setSigVert(NodoVert verticeSig) {
		this.sigVertice=verticeSig;
	}
	
	public void setPrimerAdy(NodoAdy verticeAdy) {
		this.primerAdy=verticeAdy;
	}
}
