package test.jerarquicas;
import jerarquicas.*;
import lineales.dinamicas.Lista;
public class testArbolBin {
	public static void main(String[] args) {
		 ArbolBin arbol=new ArbolBin();
	     arbol.insertar('A', null, 'R');
	     arbol.insertar('B', 'A', 'I');
	     arbol.insertar('C', 'A', 'D');
	     arbol.insertar('D', 'B', 'I');
	     arbol.insertar('E', 'C', 'I');
	     arbol.insertar('F', 'C', 'D');
	     arbol.insertar('G', 'E', 'I');
	     arbol.insertar('H', 'E', 'D');
	     System.out.println(arbol.toString());
	     System.out.println(arbol.obtenerAncestros('F'));
	}
}