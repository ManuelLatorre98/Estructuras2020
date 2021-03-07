package Grafos;

public class NodoAdy {
	private NodoVert vertice;
	private NodoAdy sigAdyacente;
	private int etiqueta;
	
	public NodoAdy(NodoVert unVertice, NodoAdy unSigAdy) {//Constructor sin etiqueta
		this.vertice=unVertice;
		this.sigAdyacente=unSigAdy;
	}
	
	public NodoAdy(NodoVert unVertice, NodoAdy unSigAdy, int unaEtiqueta) {//Constructor con etiqueta BORRAR
		this.vertice=unVertice;
		this.sigAdyacente=unSigAdy;
		this.etiqueta=unaEtiqueta;
	}
	
	public NodoVert getVertice() {
		return this.vertice;
	}
	
	public NodoAdy getSigAdyacente() {
		return this.sigAdyacente;
	}
	
	public int getEtiqueta() {
		return this.etiqueta;
	}

	
	public void setVertice(NodoVert nuevoVert) {
		this.vertice=nuevoVert;
	}
	
	public void setSigAdyacente(NodoAdy nuevoAdy) {
		this.sigAdyacente=nuevoAdy;
	}
	
	public void setEtiqueta(int nuevaEtiq) {
		this.etiqueta=nuevaEtiq;
	}
}
