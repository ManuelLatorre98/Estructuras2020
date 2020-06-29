package test.lineales;
import lineales.dinamicas.*;
public class TestCola {
    public static void main(String[] args) {
 
        Cola cola= new Cola();
        Cola clon;
        
        //Apila
        System.out.println("Poner: "+poner(cola));
        System.out.println(cola.toString());
        System.out.println(colaToLista(cola,2).toString());
       /* System.out.println(generarOtraCola(cola).toString());
        
        //Saca
        System.out.println("\nSacar: "+sacar(cola));
        System.out.println(cola.toString());
        
        //Clona una pila en base a otra
       
        System.out.println("\nClon: "+cola.clone().toString());
        
        
        //Obtiene el elemento que esta en el tope
        System.out.println("\nFrente: "+obtenerFrente(cola));
        
        //Verifica si la pila es vacia
        System.out.println("\nEs vacia?: "+esVacia(cola));
        
        //Vacia la pila
        cola.vaciar();
        System.out.println("\nSe vacio correctamente: "+esVacia(cola));
        System.out.println("\nFrente: "+obtenerFrente(cola));*/

        
       
       
    }
    public static boolean poner(Cola cola) {
        cola.poner('A');
        cola.poner('B');
        cola.poner('C');
        cola.poner('D');
        cola.poner('E');
        cola.poner('F');
        cola.poner('G');
        cola.poner('H');
        cola.poner('I');
        cola.poner('J');
        cola.poner('K');
        
        return true;//Como lo utilizo para probar y se que apila 
    }
    public static boolean sacar(Cola cola){
        return cola.sacar();
    }
    public static Cola clonar(Cola cola) {
        return  cola.clone();
        
    }
    public static Object obtenerFrente(Cola cola){
        return cola.obtenerFrente();
    }
    public static boolean esVacia(Cola cola) {
        return cola.esVacia();
    }
    public static void vaciar(Cola cola) {
        cola.vaciar();
    }
    
    public static Cola generarOtraCola(Cola c1) {
    	Cola c2= new Cola();
    	Pila pila= new Pila();
    	
    	while(!c1.esVacia()) {
    		if(!c1.obtenerFrente().equals('$')) {
    			pila.apilar(c1.obtenerFrente());
    		}else {
    			while(!pila.esVacia()) {
    				c2.poner(pila.obtenerTope());
    				pila.desapilar();
    			}
    		}
    		c2.poner(c1.obtenerFrente());
    		c1.sacar();
    	}
    	while(!pila.esVacia()) {
    		c2.poner(pila.obtenerTope());
    		pila.desapilar();
    	}
    	return c2;
    }
    
    public static boolean verificarBalanceo(Cola q) {
    	boolean balanceado=true;
    	Pila pila=new Pila();
    	Cola cola= new Cola();
    	while(!q.esVacia()) {
    		if(((char)q.obtenerFrente()=='{') || ((char)q.obtenerFrente()=='[') || ((char)q.obtenerFrente()=='(')) {
    			pila.apilar(q.obtenerFrente());
    		}else {
    			if(((char)q.obtenerFrente()=='}') || ((char)q.obtenerFrente()==']') || ((char)q.obtenerFrente()==')')) {
    				cola.poner(q.obtenerFrente());
    			}
    		}
    		q.sacar();
    	}
    	
    	while(!cola.esVacia() && !pila.esVacia() && balanceado) {
    		char tope=(char)pila.obtenerTope();
    		char frente=(char)cola.obtenerFrente();
    		if((tope=='(' && frente!=')') || (tope=='[' && frente!=']') || (tope=='{' && frente!='}')) {
    			balanceado=false;
    		}else {
    			pila.desapilar();
    			cola.sacar();
    		}
    	}
    	if((!cola.esVacia()||!pila.esVacia()) && balanceado) {
    		balanceado=false;
    	}
    	return balanceado;
    }
    
    public static Lista colaToLista(Cola cola, int t) {
    	Cola colaClon= cola.clone();
    	Cola colaAux1= new Cola();
    	Cola colaAux2= new Cola();
    	Pila pila= new Pila();
    	Lista lista= new Lista();
    	int cont=0;
    	int contLista=1;
    	while(!colaClon.esVacia()) {
    		while(cont<t && !colaClon.esVacia()) {
    			colaAux1.poner(colaClon.obtenerFrente());
    			colaAux2.poner(colaClon.obtenerFrente());
    			pila.apilar(colaClon.obtenerFrente());
    			colaClon.sacar();
    			cont++;
    		}
    		cont=0;
    		while(!colaAux1.esVacia() || !colaAux2.esVacia() || !pila.esVacia()) {
    			if(!colaAux1.esVacia()) {
    			lista.insertar(colaAux1.obtenerFrente(), contLista);
    			colaAux1.sacar();
    			contLista++;
    			}else {
    				if(!colaAux2.esVacia()) {
    					lista.insertar(colaAux2.obtenerFrente(), contLista);
    					colaAux2.sacar();
    					contLista++;
    				}else {
    					if(!pila.esVacia()) {
    						lista.insertar(pila.obtenerTope(), contLista);
    						pila.desapilar();
    						contLista++;
    					}
    				}
    			}
    		}
    		if(!colaClon.esVacia()) {
    		lista.insertar('#', contLista);
    		contLista++;
    		lista.insertar('#', contLista);
    		contLista++;
    		}
    	}
    	return lista;
    }
}















