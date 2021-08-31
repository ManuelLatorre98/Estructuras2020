package TPO1;

public class Imagen {//Objetos imagenes que seran procesados
	private String nombre;
	private int tamañoMb;
	
	public Imagen(String nombre, int tamañoMb) {
		this.nombre=nombre;
		this.tamañoMb=tamañoMb;
	}
	
	public void setName(String nombre) {
		this.nombre=nombre;
	}
	
	public void setTamañoMb(int tamañoMb) {
		this.tamañoMb=tamañoMb;
	}
	
	public String getName() {
		return this.nombre;
	}
	
	public double getTamañoMb() {
		return this.tamañoMb;
	}
	
}
