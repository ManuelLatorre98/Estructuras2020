package test.conjuntistas;

import Conjuntistas.ABB;

public class testABB {
	public static void main(String[] args) {
		ABB arbol=new ABB();
		arbol.insertar('A');
		arbol.insertar('B');
		arbol.insertar('C');
		arbol.insertar('D');
		arbol.insertar('E');
		arbol.insertar('F');
		arbol.insertar('G');
		
		ABB arbol2= new ABB();
		arbol2.insertar('A');
		arbol2.insertar('B');
		arbol2.insertar('C');
		arbol2.insertar('D');
		arbol2.insertar('E');
		arbol2.insertar('Y');
		arbol2.insertar('T');

		System.out.println(arbol.equals(arbol2));
		
	}
}
