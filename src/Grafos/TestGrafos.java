package Grafos;

public class TestGrafos {
	public static void main(String[] args) {
		GrafoEtiq grafo= new GrafoEtiq();
		for (int i = 0; i < 7; i++) {
			grafo.insertarVertice(i);
			
		}//FALTA TEST ELIMINAR ARCOS
		System.out.println(grafo.listarEnProfundidad().toString());
		System.out.println(grafo.insertarArco(0, 1));
		System.out.println(grafo.insertarArco(1, 2));
		System.out.println(grafo.insertarArco(2, 3));
		System.out.println(grafo.insertarArco(2, 6));
		System.out.println(grafo.insertarArco(3, 4));
		System.out.println(grafo.insertarArco(4, 5));
		System.out.println(grafo.insertarArco(6, 5));
		//System.out.println("EXISTE CAMINO: "+grafo.existeCamino(0, 5));
		//System.out.println("EXISTE ARCO: "+grafo.existeArco(4, 5));
		System.out.println("VACIO"+grafo.vacio());
		for (int i = 0; i < 10; i++) {
			System.out.println(grafo.eliminarVertice(i));
			System.out.println(grafo.listarEnProfundidad().toString());
			
			//System.out.println("Existe "+i+"? "+grafo.existeVertice(i));
		}
		
		
		
	}
}
