package TPO;

public class Cliente implements Comparable{
	private TipoYNroDoc documento;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String domicilio;
	private String nroTelefono;
	
	public Cliente(TipoYNroDoc documento,String unNombre, String unApellido, String unaFechaNac, String unDomicilio, String unNroTel) {
		this.nombre=unNombre;
		this.apellido=unApellido;
		this.fechaNacimiento=unaFechaNac;
		this.domicilio=unDomicilio;
		this.nroTelefono=unNroTel;
		this.documento=documento;
		}


	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getNroTelefono() {
		return nroTelefono;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setNroTelefono(String nroTelefono) {
		this.nroTelefono = nroTelefono;
	}
	
	public String getClave() {
		return this.documento.toString();
	}
	
	public String toString() {
		String cadena;
		cadena="C: "+this.documento.toStringConComa()+","+this.nombre+","+this.apellido+","+this.fechaNacimiento+","+this.domicilio+","+this.nroTelefono;
		return cadena;
	}
	@Override
	public int compareTo(Object o) {
		return 0;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
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
		Cliente other = (Cliente) obj;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		return true;
	}
	
}
