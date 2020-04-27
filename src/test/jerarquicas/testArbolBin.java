package test.jerarquicas;
import jerarquicas.*;
import lineales.dinamicas.Lista;
public class testArbolBin {
	public static void main(String[] args) {
		 ArbolBin arbol=new ArbolBin();
	     arbol.insertar(1, null, 'R');
	     arbol.insertar(2, 1, 'I');
	     arbol.insertar(3, 1, 'D');	
	     arbol.insertar(4, 2, 'I');
	     arbol.insertar(5, 2, 'D');
	 
	    
	     System.out.println(arbol.toString());
	     NodoArbol nodo=arbol.obtenerNodo(20);
	     System.out.println(arbol.altura());
	}
}