package test.conjuntistas;

import Conjuntistas.ABB;

public class testABB {
	public static void main(String[] args) {
		ABB arbol=new ABB();
		arbol.insertar(8);
		arbol.insertar(3);
		arbol.insertar(10);
		arbol.insertar(1);
		arbol.insertar(6);
		arbol.insertar(4);
		arbol.insertar(7);
		arbol.insertar(10);
		arbol.insertar(14);
		arbol.insertar(13);
		arbol.insertar(5);
		
		System.out.println(arbol.toString());
		System.out.println(arbol.listarInorden().toString());
		
		
		
	}
}
