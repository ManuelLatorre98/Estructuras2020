package TPO;
public class Pasaje {
	private Vuelo vuelo;
	private String fecha;
	private int nroAsiento;
	private String estado;	
	public Pasaje(Vuelo vuelo, String fecha, int nroAsiento, String estado) {
		this.vuelo = vuelo;
		this.fecha = fecha;
		this.nroAsiento = nroAsiento;
		this.estado = estado;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public String getFecha() {
		return fecha;
	}

	public int getNroAsiento() {
		return nroAsiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setNroAsiento(int nroAsiento) {
		this.nroAsiento = nroAsiento;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String toString() {
		String cadena;
		cadena="P: "+this.vuelo.getClave()+","+this.fecha+","+this.nroAsiento+","+this.estado;
		return cadena;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((vuelo == null) ? 0 : vuelo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasaje other = (Pasaje) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (vuelo == null) {
			if (other.vuelo != null)
				return false;
		} else if (!vuelo.equals(other.vuelo))
			return false;
		return true;
	}
	
}
