package Grafos;

import lineales.dinamicas.Lista;

public class TestGrafos {
	public static void main(String[] args) {
		GrafoEtiq grafo= new GrafoEtiq();
		Lista lista= new Lista();
		if(lista.esVacia() || lista.recuperar(1).equals(1)) {
			System.out.println("EEEEEEEEEEEEEEEEEO");
		}
		for (int i = 1; i < 7; i++) {
			grafo.insertarVertice(i);
			
		}//FALTA TEST ELIMINAR ARCOS
		System.out.println(grafo.listarEnProfundidad().toString());
		grafo.insertarArco(1, 2, 1);
		grafo.insertarArco(2, 1, 2);
		grafo.insertarArco(2, 3, 3);
		grafo.insertarArco(3, 2, 4);
		grafo.insertarArco(3, 4, 5);
		grafo.insertarArco(4, 3, 6);
		grafo.insertarArco(4, 5, 7);
		grafo.insertarArco(5, 4, 8);
		grafo.insertarArco(5, 1, 9);
		grafo.insertarArco(1, 5, 10);
		grafo.insertarArco(4, 6, 11);
		grafo.insertarArco(6, 4, 12);
		
		System.out.println("Camino Peso y long Max: "+grafo.primerCaminoMenorPesoYLong(1, 5,2, 2));
		
		
		
	}
}
