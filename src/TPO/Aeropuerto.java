package TPO;

public class Aeropuerto {
	private String nombreAeronautico;
	private String ciudad;
	private String nroTelefono;
	
	public Aeropuerto(String unNombre) {
		this.nombreAeronautico=unNombre;
	}
	
	public Aeropuerto(String unNombre, String unaCiudad, String unNroTel) {
		this.nombreAeronautico=unNombre;
		this.ciudad=unaCiudad;
		this.nroTelefono= unNroTel;
	}

	public String getNombreAeronautico() {
		return nombreAeronautico;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getNroTelefono() {
		return nroTelefono;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setNroTelefono(String nroTelefono) {
		this.nroTelefono = nroTelefono;
	}
	
	public String toString() {
		return "A: "+this.getNombreAeronautico()+","+this.getCiudad()+","+this.getNroTelefono();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeropuerto other = (Aeropuerto) obj;
		if (nombreAeronautico == null) {
			if (other.nombreAeronautico != null)
				return false;
		} else if (!nombreAeronautico.equals(other.nombreAeronautico))
			return false;
		return true;
	}
	
	
	
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj || this.nombreAeronautico.equals(obj))//Si el objeto es el mismo, o si los nombres aeronauticos (claves) coinciden
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeropuerto other = (Aeropuerto) obj;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (nombreAeronautico == null) {
			if (other.nombreAeronautico != null)
				return false;
		} else if (!nombreAeronautico.equals(other.nombreAeronautico))
			return false;
		if (nroTelefono == null) {
			if (other.nroTelefono != null)
				return false;
		} else if (!nroTelefono.equals(other.nroTelefono))
			return false;
		return true;
	}*/
	
	
	
}
