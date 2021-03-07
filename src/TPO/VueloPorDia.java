package TPO;

public class VueloPorDia {
	private String fecha;
	private int nroAsientos;
	private int nroAsientosVendidos;
	
	public VueloPorDia(String fecha,int cantAsientos) {
		this.fecha=fecha;
		this.nroAsientos=cantAsientos;
	}
	
	public int nroAsientosDisponibles() {
		return (nroAsientos-nroAsientosVendidos);
	}
	
	public void venderAsiento() {
		this.nroAsientosVendidos++;
	}
	
	public int getNroAsientos() {
		return nroAsientos;
	}

	public int getNroAsientosVendidos() {
		return nroAsientosVendidos;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	
	public void setNroAsientos(int nroAsientos) {
		this.nroAsientos = nroAsientos;
	}

	public void setNroAsientosVendidos(int nroAsientosVendidos) {
		this.nroAsientosVendidos = nroAsientosVendidos;
	}
	
	public void liberarUnAsiento() {
		this.nroAsientosVendidos--;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj || this.fecha.equals(obj))
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VueloPorDia other = (VueloPorDia) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}

	
}
