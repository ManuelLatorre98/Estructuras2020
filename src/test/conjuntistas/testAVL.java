package test.conjuntistas;
import Conjuntistas.NodoAVL;

public class testAVL {
	public static void main(String[] args) {
		NodoAVL nodo1= new NodoAVL(1, null, null);
		NodoAVL nodo2= new NodoAVL(2, null, null);
		NodoAVL nodo3= new NodoAVL(3, nodo2, null);
		NodoAVL nodo= new NodoAVL(4, nodo1, nodo3);
		System.out.println(nodo.getIzquierdo().getIzquierdo().getAltura());
		
	}
}
