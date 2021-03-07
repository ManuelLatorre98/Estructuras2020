package PropositoEspecifico;

public class testDiccionario {
	public static void main(String[] args) {
		Diccionario dicc= new Diccionario();
		/*dicc.insertar(5, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(3, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(7, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(2, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(4, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(6, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(9, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(8, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(10, "e4");
	
	
		System.out.println(dicc.toString());
		dicc.eliminar(6);//Produce rotacion simple izq caso 1
		System.out.println("BORRADO: "+ dicc.toString());
		dicc.eliminar(10);//Rotacion simple izq- der
		System.out.println("BORRADO2: "+dicc.toString());*/
		

		dicc.insertar(5, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(4, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(8, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(6, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(10, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(3, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(7, "Fran");
		System.out.println(dicc.toString());
		
		dicc.eliminar(3);//Produce doble Der-Izq caso 1
		System.out.println("BORRADO: "+ dicc.toString());
		
		/*dicc.insertar(7, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(4, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(10, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(3, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(6, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(11, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(5, "Fran");
		System.out.println(dicc.toString());
		
		dicc.eliminar(11);//Produce doble Izq-Der caso 1
		System.out.println("BORRADO: "+ dicc.toString());*/
		
		
		
		/*dicc.insertar(5, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(3, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(7, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(2, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(6, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(9, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(10, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		
		System.out.println(dicc.toString());
		dicc.eliminar(3);//Produce rotacion simple izq caso 2
		System.out.println("BORRADO: "+ dicc.toString());*/
		
		/*dicc.insertar(9, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(7, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(10, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(6, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(8, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(11, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(5, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		
		System.out.println(dicc.toString());
		dicc.eliminar(10);//Produce rotacion simple Der caso 2
		System.out.println("BORRADO: "+ dicc.toString());*/
		
		
		
		/*dicc.insertar(5, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(3, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(8, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(2, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(6, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(11, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(7, "Fran");
		System.out.println(dicc.toString());
		
		
		dicc.eliminar(3);//Produce doble Der-Izq caso 2
		System.out.println("BORRADO: "+ dicc.toString());*/
		
		/*dicc.insertar(10, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(7, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(11, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(6, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(9, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(12, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(8, "Fran");
		System.out.println(dicc.toString());
		
		dicc.eliminar(11);//Produce doble Izq-Der caso 2
		System.out.println("BORRADO: "+ dicc.toString());*/
		
		/*dicc.insertar(20, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(18, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(22, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(19, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(21, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(23, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(24, "Fran");
		System.out.println(dicc.toString());
		dicc.eliminar(20);//Produce simp izq caso 3
		System.out.println("BORRADO: "+ dicc.toString());*/
		
		/*dicc.insertar(20, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(18, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(22, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(17, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(19, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(21, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(16, "Fran");
		System.out.println(dicc.toString());
		
		dicc.eliminar(20);//Produce simp der caso 3
		System.out.println("BORRADO: "+ dicc.toString());*/
		
		/*dicc.insertar(5, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(3, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(8, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(4, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(6, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(11, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(7, "Fran");
		System.out.println(dicc.toString());
		
		dicc.eliminar(5);//Produce doble der izq caso 3
		System.out.println("BORRADO: "+ dicc.toString());*/
		
		
		/*dicc.insertar(56, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(34, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(78, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(23, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(35, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(63, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(89, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(71, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(29, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		
		dicc.eliminar(56);//Produce doble izq der caso 3
		System.out.println("BORRADO: "+ dicc.toString());*/
		
		/*dicc.insertar(56, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(34, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(78, "Fran");
		System.out.println(dicc.toString());
		dicc.insertar(23, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(35, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(63, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(89, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(22, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(29, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(36, "e4");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(62, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(71, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(90, "Sele");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		dicc.insertar(21, "Fran");
		System.out.println(dicc.toString()+"\n------------------------------\n");
		
		
		dicc.eliminar(34);//Produce doble izq der caso 3
		System.out.println("BORRADO: "+ dicc.toString());*/
		
	}
}
