package lineales.estaticas;

public class Pila {
	private int tamaño=10;
	private Object []array;
	private int tope;
	
	public Pila() {
		this.array=new Object[this.tamaño];
		this.tope=-1;
	}
	
	public boolean apilar(Object elem) {
		boolean apilo=false;
		if(this.tope< (this.tamaño-1)) {
			array[this.tope+1]=elem;
			this.tope++;
			apilo=true;
		}
		//Si el array esta lleno no puede apilar y retorna false
		
		return apilo;
	}
	
	public boolean desapilar() {
		boolean desapilo=false;
		if(tope>-1) {
			this.array[this.tope]=null;
			this.tope--;
			desapilo=true;
		}
		//Si el el tope esta en -1 significa que no hay elementos en el array y retorna false
		return desapilo;
	}
	
	public Object obtenerTope() {
		Object elemTope;
		if(this.tope<0) {
			elemTope=null;
		}else {
			elemTope=this.array[this.tope];
		}
		return elemTope;
	}
	
	public boolean esVacia() {
		return this.tope==-1;
	}
	
	public void vaciar() {
		while(this.tope>-1){
			this.array[this.tope]=null;
			this.tope--;
		}
	}
	
	public Pila clone() {
		Pila clon= new Pila(); //Tope en -1 por constructor
		clon.array= array.clone();
		clon.tope= this.tope;
		return clon;
	}
	
	public String toString() {
		String cadena= "[";
		for (int i = 0; i < this.tope+1; i++) {
			cadena+=this.array[i]+", ";
		}
		cadena+=" <--- TOPE";
		return cadena;
	}
	
	
	
}

