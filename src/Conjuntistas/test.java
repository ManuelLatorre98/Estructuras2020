package Conjuntistas;

import jerarquicas.ArbolBin;
import jerarquicas.NodoArbol;

public class test {
	public static void main(String[] args) {
		 ABB arbol=new ABB();
	     arbol.insertar(45);
	     arbol.insertar(34);
	     arbol.insertar(65);	
	     arbol.insertar(13);
	     arbol.insertar(55);
	     arbol.insertar(73);
	     arbol.insertar(96);
	     
	     System.out.println(arbol.toString());
	     System.out.println(arbol.maximoElem( ));
	     System.out.println(arbol.toString());
	   
	}
}
