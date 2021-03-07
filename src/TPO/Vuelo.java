package TPO;

import lineales.dinamicas.Lista;

public class Vuelo implements Comparable {
	private String clave;
	private Aeropuerto origen;
	private Aeropuerto destino;
	private String horaSalida;
	private String horaLlegada;
	private Lista listaVuelos;
	
	public Vuelo(String unaClave,Aeropuerto unOrigen, Aeropuerto unDestino, String unaHoraSalida, String unaHoraLlegada,String fecha,int nroAsi) {
		this.clave=unaClave;
		this.origen=unOrigen;
		this.destino=unDestino;
		this.horaSalida=unaHoraSalida;
		this.horaLlegada=unaHoraLlegada;
		this.listaVuelos=new Lista();
		this.listaVuelos.insertar(new VueloPorDia(fecha,nroAsi), listaVuelos.longitud()+1);
	}
	
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getClave() {
		return clave;
	}

	public Aeropuerto getOrigen() {
		return origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public Lista getListaVuelos() {
		return this.listaVuelos;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	public String toString() {
		String cadena="";
		VueloPorDia vueloDia;
		for (int i = 1; i < this.listaVuelos.longitud()+1; i++) {
			vueloDia=((VueloPorDia)this.listaVuelos.recuperar(i));
			cadena="V: "+this.clave+","+this.origen.getNombreAeronautico()+","+this.destino.getNombreAeronautico()+","+this.horaSalida+","+this.horaLlegada+","+vueloDia.getFecha()+","+vueloDia.getNroAsientos();
		}
		return cadena;
	}
}
