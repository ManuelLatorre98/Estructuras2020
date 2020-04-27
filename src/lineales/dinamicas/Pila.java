package lineales.dinamicas;

public class Pila {
	private Nodo tope;

	public Pila() {
		this.tope = null;
	}

	public boolean apilar(Object elem) {
		Nodo nodo = new Nodo(elem, this.tope);
		this.tope = nodo;
		return true;
	}

	public boolean desapilar() {
		boolean desapilo = false;
		if (this.tope != null) {
			this.tope = this.tope.getEnlace();
			desapilo = true;
		}
		return desapilo;
	}

	public Object obtenerTope() {
		Object elemTope;
		if (this.tope == null) {
			elemTope = null;
		} else {
			elemTope = this.tope.getElem();
		}

		return elemTope;
	}

	public boolean esVacia() {
		return this.tope == null;
	}

	public void vaciar() {
		this.tope = null;
	}

	public Pila clone() {
		Nodo flagEnlace; // Sigue a mi pila original a partir del primer enlace (segundo elemento de la pila original)
		Pila clon = new Pila();
		Nodo flagClon; // Sigue a la pila clon

		if (this.tope != null) {
			Nodo nodoClon = new Nodo(this.tope.getElem(), null);
			flagEnlace=this.tope.getEnlace();
			clon.tope = nodoClon;
			flagClon = clon.tope;
			while (flagEnlace != null) {
				flagClon.setEnlace(new Nodo(flagEnlace.getElem(),null)); //aux siempre esta apuntando al enlace en la otra pila
				flagClon=flagClon.getEnlace();
				flagEnlace=flagEnlace.getEnlace();
			}
		}
		return clon;
	}

	public String toString () {
		String cadena="";
		if(this.tope==null) {
			cadena+="Pila vacia";
		}else {
			cadena=auxToString(this.tope)+" <---TOPE";
		}
		return cadena;
	}
	
	private String auxToString(Nodo flagNodo) { //Uso este metodo auxiliar ya que en el test hace llamado a toString() sin parametros
		String cadena="";
		if(flagNodo==null) {
			cadena+="[";
		}else {
				cadena= auxToString(flagNodo.getEnlace());
				if(flagNodo!=null && !cadena.equals("[")) { //Para que no salga una coma al final
					cadena+=", ";
				}
				cadena+=flagNodo.getElem();
				
		}
		return cadena;
	}

}
