package jerarquicas;

public class test {
	public static void main(String[] args) {
		/*ArbolBin arbolbin= new ArbolBin();
		arbolbin.insertar(1, null, ' ');
		arbolbin.insertar(2, 1, 'I');
		arbolbin.insertar(3, 1, 'D');
		arbolbin.insertar(17, 2, 'I');
		arbolbin.insertar(19, 2, 'D');
		arbolbin.insertar(36, 3, 'I');
		arbolbin.insertar(7, 3, 'D');
		arbolbin.insertar(25, 17, 'I');
		arbolbin.insertar(100, 17, 'D');
		System.out.println(arbolbin.toString());
		System.out.println("PREORDEN: "+arbolbin.listarPreorden().toString());
		System.out.println("INORDEN: "+arbolbin.listarInorden().toString());
		System.out.println("POSORDEN: "+arbolbin.listarPosorden().toString());
		System.out.println("PORNIVELES: "+arbolbin.listarNiveles().toString());*/
		
		ArbolGen arbol=new ArbolGen();
		arbol.insertar(1, null);
		arbol.insertar(2, 1);
		arbol.insertar(3, 1);
		arbol.insertar(4, 1);
		arbol.insertar(5, 2);
		arbol.insertar(7, 3);
		arbol.insertar(8, 7);
		/*arbol.insertar(9, 3);
		arbol.insertar(10, 9);
		/*arbol.insertar(11, 4);
		arbol.insertar(12, 11);
		arbol.insertar(13, 12);*/
		System.out.println(arbol.toString());
		System.out.println(arbol.listaQueJustificaLaAltura());
	}
}
