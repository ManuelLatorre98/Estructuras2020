package lineales.dinamicas;

public class TestPila {
    public static void main(String[] args) {
    	
        Pila pila= new Pila();
        Pila clon;
        
        //Apila
        System.out.println("Apilo del 1 al 4: ");
        apilar(pila);
        System.out.println(pila.toString());
        
        //Verifica capicua
        System.out.println("\nLa pila es capicua: "+esCapicua(pila));
        
      //Clona una pila en base a otra
        String pilaClon=pila.clone().toString();
        System.out.println("\nClon: "+pilaClon);
        
        pila.vaciar();
        //Desapila
        System.out.println("\nDesapilar: "+desApilar(pila));
        System.out.println(pila.toString());        
        
        
        System.out.println("/nCon2: "+ pilaClon);
        

        //Obtiene el elemento que esta en el tope
        System.out.println("\nTope: "+obtenerTope(pila));
        
        //Verifica si la pila es vacia
        System.out.println("\nEs vacia?: "+esVacia(pila));
        
        //Vacia la pila
        pila.vaciar();
        System.out.println("\nSe vacio correctamente: "+esVacia(pila));
        System.out.println("\nTope: "+obtenerTope(pila));
        

        //Verifica si la pila es vacia
        System.out.println("\nEs vacia?: "+esVacia(pila));
        
        
       
    }
    public static void apilar(Pila pila) {
    	System.out.println(pila.apilar("N"));
        System.out.println(pila.apilar("E"));
        System.out.println(pila.apilar("U"));
        System.out.println(pila.apilar("Q"));
        System.out.println(pila.apilar("U"));
        System.out.println(pila.apilar("E"));
        System.out.println(pila.apilar("N"));
        
    }
    public static boolean desApilar(Pila pila){
        return pila.desapilar();
    }
    public static Pila clonar(Pila pila) {
        return  pila.clone();
        
    }
    public static Object obtenerTope(Pila pila){
        return pila.obtenerTope();
    }
    public static boolean esVacia(Pila pila) {
        return pila.esVacia();
    }
    public static void vaciar(Pila pila) {
        pila.vaciar();
    }
    
    public static boolean esCapicua(Pila pila) {
    	boolean capicua=true;
    	Pila clon= pila.clone();
    	Pila inver= new Pila();
    	
    	while (!clon.esVacia()) {
    		inver.apilar(clon.obtenerTope());
    		clon.desapilar();
		}
    	clon= pila.clone(); //Fuera de repetitiva, no me incrementa orden de tiempo de ejecucion
    	
    	while(capicua && !clon.esVacia() && !inver.esVacia()) {
    		if(!clon.obtenerTope().equals(inver.obtenerTope())) {
    			capicua=false;
    		}else {
    			clon.desapilar();
    			inver.desapilar();
    		}
    	}
    	if((!clon.esVacia() || !inver.esVacia()) && capicua) {
    		capicua=false;
    	}

    	return capicua;
    }

}