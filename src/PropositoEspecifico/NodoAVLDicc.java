package PropositoEspecifico;

import Conjuntistas.NodoAVL;

public class NodoAVLDicc {
	private Comparable clave;
	private Comparable dato;
	private int altura=-1;
	private NodoAVLDicc hijoIzq;
	private NodoAVLDicc hijoDer;
	
	public NodoAVLDicc(Comparable unaClave, Comparable unDato) {
		this.clave=unaClave;
		this.dato=unDato;
		this.hijoIzq=null;
		this.hijoDer=null;
		this.altura=0;
	}
	
	public NodoAVLDicc(Comparable unaClave, Comparable unDato, NodoAVLDicc unHijoIzq, NodoAVLDicc unHijoDer) {
		this.clave=unaClave;
		this.dato=unDato;
		this.hijoIzq=unHijoIzq;
		this.hijoDer=unHijoDer;
		this.auxRecalcularAltura();
	}
	
	public Comparable getClave() {
		return this.clave;
	}
	
	public Comparable getDato() {
		return this.dato;
	}
	
	public NodoAVLDicc getHijoIzq() {
		return this.hijoIzq;
	}
	
	public NodoAVLDicc getHijoDer() {
		return this.hijoDer;
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	public void setClave(Comparable unaClave) {
		this.clave=unaClave;
	}
	
	public void setDato(Comparable unDato) {
		this.dato=unDato;
	}
	
	public void setHijoIzq(NodoAVLDicc unHijoIzq) {
		this.hijoIzq=unHijoIzq;
	}
	
	public void setHijoDer(NodoAVLDicc unHijoDer) {
		this.hijoDer=unHijoDer;
	}
	public void setAltura(int unaAltura) {
		this.altura=unaAltura;
	}
	public void recalcularAltura() {
		this.auxRecalcularAltura();
	}
	
	private void auxRecalcularAltura() {
			int altI=-1;
			int altD=-1;
			if(this.getHijoIzq()!=null) {
				altI=this.getHijoIzq().getAltura();
			}
			if(this.getHijoDer()!=null) {
				altD=this.getHijoDer().getAltura();
			}
			if(altI>altD) {
				this.altura=altI+1;
			}else {
				this.altura=altD+1;
			}
	}
	
	
	
	
}
