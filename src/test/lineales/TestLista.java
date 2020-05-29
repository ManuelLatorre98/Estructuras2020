package test.lineales;
import lineales.dinamicas.*;

public class TestLista {
    public static void main(String[] args) {
        Lista L1= new Lista();
        Lista L2= new Lista();
        Lista lista= new Lista();
        System.out.println(L1.insertar(1, 1));
        System.out.println(L1.insertar(2, 2));
        System.out.println(L1.insertar(3, 3));
        System.out.println(L1.insertar(4, 4));
        System.out.println(L1.insertar(5, 5));
        System.out.println(L1.insertar(6, 6));
        System.out.println(L1.insertar(7, 7));
        System.out.println(L1.insertar(8, 8));

        System.out.println(L1.toString());
        L1.agregarProducto(3);
        System.out.println(L1.toString());
       /* System.out.println(L2.toString());
        
        System.out.println(concatenar(L1,L2).toString());
        lista.insertar('A', 1);
        lista.insertar('B', 2);
        lista.insertar('C', 3);
        lista.insertar('D', 4);
        lista.insertar('E', 5);
        lista.insertar('F', 6);
        lista.insertar('G', 7);
        System.out.println(lista.toString());
        lista.intercalarElem('Z', 3);
        System.out.println(lista.toString());
        
        Cola cola= new Cola();
        cola.poner('A');
        cola.poner('B');
        cola.poner('C');
        cola.poner('D');
        cola.poner('E');
        cola.poner('F');
        cola.poner('G');
        cola.poner('H');
        
        System.out.println(obtenerPatron(cola,3).toString());*/
    }
    public static Lista concatenar(Lista L1, Lista L2) {
    	Lista L3= new Lista();
    	int longi1= L1.longitud();
    	int longi2= L2.longitud();
    	
    	while(longi2>=1) {
    		L3.insertar(L2.recuperar(longi2), 1);
    		longi2--;
    	}
    	
    	while(longi1>=1) {
    		L3.insertar(L1.recuperar(longi1), 1);
    		longi1--;
    	}
    	return L3;
    }
    
    public static Lista obtenerPatron(Cola q, int k) {
    	int cont=0;
    	Lista lista= new Lista();
    	Pila pila= new Pila();
    	Cola cola= new Cola();
    	
    	while(!q.esVacia()) {
    		if(cont!=k) {
    			pila.apilar(q.obtenerFrente());
    			cola.poner(q.obtenerFrente());
    			q.sacar();
    			cont++;
    		}
    		if(cont==k || q.esVacia()) {
    			while(!pila.esVacia()) {
    				lista.insertar(pila.obtenerTope(), lista.longitud()+1);
    				pila.desapilar();
    			}
    			while(!cola.esVacia()) {
    				lista.insertar(cola.obtenerFrente(), lista.longitud()+1);
    				cola.sacar();
    			}
    			if(cont==k) {
    				lista.insertar('#', lista.longitud()+1);
    			}
    			cont=0;
    		}
    	}
    	return lista;
    }
    
    
}
