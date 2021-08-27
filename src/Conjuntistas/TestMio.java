package Conjuntistas;

public class TestMio {
	public static void main(String[] args) {
		ABB heap=new ABB();
		heap.insertar(45);
		heap.insertar(34);
		heap.insertar(65);
		heap.insertar(13);
		heap.insertar(55);
		heap.insertar(73);
		heap.insertar(96);
		System.out.println(heap.toString());
		System.out.println("PREORDEN: "+heap.listarPreorden());
		System.out.println("INORDEN: "+heap.listarInorden());
		System.out.println("PORNIVELES: "+heap.listarNiveles());
		System.out.println("POSORDEN: "+heap.listarPosorden());
	}
}
