package test.jerarquicas;

import jerarquicas.ArbolGen;

public class testArbolGen {
	public static void main(String[] args) {
        ArbolGen arbol= new ArbolGen();
       
        arbol.insertar('A', null);
        arbol.insertar('B', 'A');
        arbol.insertar('C', 'A');
        arbol.insertar('D', 'A');
        arbol.insertar('E', 'B');
        arbol.insertar('F', 'B');
        arbol.insertar('G', 'B'); 
        arbol.insertar('H', 'D'); 
        
       
        System.out.println(arbol.toString());  
        ArbolGen clon= arbol.clone();
       
        System.out.println(arbol.ancestros('P'));
    }
}
