package TPO;
import java.util.HashMap;
import Grafos.GrafoEtiq;
import PropositoEspecifico.Diccionario;
import lineales.dinamicas.Lista;
public class SistemaViajes {
	private EntradaSalida entradaSalida= new EntradaSalida();
	private Diccionario vuelos=new Diccionario();
	private GrafoEtiq aeropuertos= new GrafoEtiq();
	private Diccionario clientes= new Diccionario();
	private HashMap clientePasajes= new HashMap();
	public SistemaViajes() {
	}
	
	public void cargaDatosAutomatica() {
		EntradaSalida entradaSalida= new EntradaSalida();
		entradaSalida.cargaAutomatica(vuelos, aeropuertos, clientes, clientePasajes,this);
	}
	
	public void menu() {
		boolean fin=false;
		int opcion;
		Lista listaDatos=new Lista();
		while(!fin) {
		listaDatos.vaciar();//Vacio la lista cada vez que voy a ingresar una nueva opcion para evitar problemas
		opcion=entradaSalida.opciones();
		switch (opcion) {
		case 1: {
			this.opAltaAero(listaDatos);
			break;
		}
		case 2: {
			this.opAltaCliente(listaDatos);
			break;
		}
		case 3: {
			this.opAltaVuelo(listaDatos);
			break;
		}
		case 4: {
			this.opAltaPasaje(listaDatos);
			break;
		}
		case 5: {
			this.opNuevaFechaVuelo(listaDatos);
			break;
		}
		case 6:{
			this.opModifTelefAero(listaDatos);
			break;
		}
		case 7:{
			this.opModifDomCliente(listaDatos);
			break;
		}
		case 8:{
			this.opModifTelCliente(listaDatos);
			break;
		}
		case 9:{
			this.opModifHoraSalidaVuelo(listaDatos);
			break;
		}
		case 10:{
			this.opModifHoraLlegadaVuelo(listaDatos);
			break;
		}
		case 11:{
			this.opModificarEstadoPasaje(listaDatos);
			break;
		}
		case 12:{
			this.opBajaAero(listaDatos);
			break;
		}
		case 13:{
			this.opBajaCliente(listaDatos);
			break;
		}
		case 14:{
			this.opBajaVuelo(listaDatos);
			break;
		}
		case 15:{
			this.opBajaPasaje(listaDatos);
			break;
		}
		case 16:{
			this.opObtenerContactoYPasajesCliente(listaDatos);
			break;
		}
		case 17:{
			this.opObtenerCiudadesVisitadas(listaDatos);
			break;
		}
		case 18:{
			this.opObtenerDatosVuelo(listaDatos);
			break;
		}
		case 19:{
			this.opObtenerCodigosVuelosRango(listaDatos);
			break;
		}
		case 20:{
			this.opCaminoEnNVuelos(listaDatos);
			break;
		}
		case 21:{
			this.opCaminoMenorTiempo(listaDatos);
			break;
		}
		case 22:{
			this.opCaminoMenorAeropuertos(listaDatos);
			break;
		}
		case 23:{
			this.opCaminoConAeroIntermedio(listaDatos);
			break;
		}
		case 24:{
			this.opListaClientesFieles(listaDatos);
			break;
		}
		case 25:{
			this.opMostrarSistema(listaDatos);
			break;
		}
		case 26:{//Cierre del sistema
			fin=this.opSalirDelPrograma(listaDatos);
			break;   
		}
		default:
		}
		}
	}
	
	//MODULARIZACION DEL SWITCH
	public void opAltaAero(Lista listaDatos) {
		this.entradaSalida.cargaNombreAeroInexistente(aeropuertos, listaDatos, 1,"a dar de alta");
		if(!listaDatos.esVacia()) {//Si no se cancelo ingreso el resto de datos
			this.entradaSalida.cargaCiudad(listaDatos, 2,"del aeropuerto");
		}
		if(!listaDatos.esVacia()) {//Si no se cancelo ingreso el resto de datos
			this.entradaSalida.cargaTelefono(listaDatos, 3, "del aeropuerto");
		}
		if(!listaDatos.esVacia()) {//Si no esta vacia, es decir no se cancelo la operacion
			this.altaAeropuerto((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2), (String)listaDatos.recuperar(3));
		}
		if(listaDatos.esVacia()) {//Si esta vacia es que se cancelo la operacion
			this.entradaSalida.escribirConsolaError("Operacion de carga de aeropuerto cancelada");
		}
	}
	
	private void opBajaAero(Lista listaDatos) {
		this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 1, "a dar de baja");
		if(!listaDatos.esVacia()) {
			this.bajaAeropuerto((String)listaDatos.recuperar(1));
		}
		if(listaDatos.esVacia()) {//Si esta vacia es que se cancelo la operacion
			this.entradaSalida.escribirConsolaError("Operacion de baja de aeropuerto cancelada");
		}
	}
	
	private void opModifTelefAero(Lista listaDatos) {
		this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 1, "a modificar el telefono");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaTelefono(listaDatos, 2, "nuevo");
		}
		if(!listaDatos.esVacia()) {
			this.modificarTelefAero((String)listaDatos.recuperar(1),(String) listaDatos.recuperar(2));
		}
		if(listaDatos.esVacia()) {//Si esta vacia es que se cancelo la operacion
			this.entradaSalida.escribirConsolaError("Operacion de modificacion de telefono cancelada");
		}
	}
	
	private void opAltaCliente(Lista listaDatos) {
		this.entradaSalida.cargaDocumentoInexistente(listaDatos, clientes, 1, 2, "a cargar");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaNombreYApellido(listaDatos, clientes, 3, 4, "a cargar");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaFecha(listaDatos, 5, "de nacimiento del cliente");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaDomicilio(listaDatos, clientes, 6, "del cliente");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaTelefono(listaDatos, 7, "del cliente");
		}
		
		if(!listaDatos.esVacia()) {
			this.altaCliente((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2), (String)listaDatos.recuperar(3), (String)listaDatos.recuperar(4), (String)listaDatos.recuperar(5), (String)listaDatos.recuperar(6), (String)listaDatos.recuperar(7));
		}
		
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion de alta de cliente cancelada");
		}
	}
	
	private void opBajaCliente(Lista listaDatos) {
		this.entradaSalida.cargaDocumentoExistente(listaDatos, clientes, 1, 2, "a dar de baja");
		if(!listaDatos.esVacia()) {
			this.bajaCliente((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2));
		}else {
			this.entradaSalida.escribirConsolaError("Operacion de baja de cliente cancelada");
		}
		
	}
	
	private void opModifDomCliente(Lista listaDatos) {
		this.entradaSalida.cargaDocumentoExistente(listaDatos, clientes, 1, 2, "a modificar el domicilio");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaDomicilio(listaDatos, clientes, 3, "nuevo");
		}
		if(!listaDatos.esVacia()) {
			this.modificarDomicilioCliente((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2), (String)listaDatos.recuperar(3));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion de modificacion de domicilio de cliente cancelada");
		}
	}
	
	private void opModifTelCliente(Lista listaDatos) {
		this.entradaSalida.cargaDocumentoExistente(listaDatos, clientes, 1, 2, "a modificar el telefono");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaDomicilio(listaDatos, clientes, 3, "nuevo");
		}
		if(!listaDatos.esVacia()) {
			this.modificarTelefonoCliente((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2), (String)listaDatos.recuperar(3));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion de modificacion de telefono de cliente cancelada");
		}
		
	}
	
	private void opAltaVuelo(Lista listaDatos) {
		this.entradaSalida.cargaNombreVueloInexistente(vuelos, listaDatos, 1, "a cargar");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 2, "de origen");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 3, "de destino");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaHora(listaDatos, 4, "de salida");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaHora(listaDatos, 5, "de llegada");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaFecha(listaDatos, 6, "del vuelo");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaAsientos(listaDatos, 7, "");
		}
		if(!listaDatos.esVacia()) {
			this.altaVuelo((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2), (String)listaDatos.recuperar(3), (String)listaDatos.recuperar(4), (String)listaDatos.recuperar(5), (String)listaDatos.recuperar(6),(String)listaDatos.recuperar(7));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion de alta de vuelo cancelada");
		}
	}
	
	private void opNuevaFechaVuelo(Lista listaDatos) {
		this.entradaSalida.cargaNombreVueloExistente(vuelos, listaDatos, 1, "al que se le quiere agregar una fecha");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaFecha(listaDatos, 2, "del vuelo");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaAsientos(listaDatos, 3, "");
		}
		if(!listaDatos.esVacia()) {
			this.agregarFechaDeVuelo((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2), (String)listaDatos.recuperar(3));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion de nueva fecha para un vuelo cancelada");
		}
	}
	
	private void opBajaVuelo(Lista listaDatos) {
		this.entradaSalida.cargaNombreVueloExistente(vuelos, listaDatos, 1, "a dar de baja");
		if(!listaDatos.esVacia()) {
			this.bajaVuelo((String)listaDatos.recuperar(1));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion de baja de un vuelo cancelada");
		}
		
	}
	
	private void opModifHoraSalidaVuelo(Lista listaDatos) {
		this.entradaSalida.cargaNombreVueloExistente(vuelos, listaDatos, 1, "a modificar hora de salida");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaHora(listaDatos, 2, "de salida nueva");
		}

		if(!listaDatos.esVacia()) {
			this.modificarHoraSalidaVuelo((String)listaDatos.recuperar(1),(String)listaDatos.recuperar(2));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion de modificacion de hora de salida de vuelo cancelada");
		}
	}
	
	private void opModifHoraLlegadaVuelo(Lista listaDatos) {
		this.entradaSalida.cargaNombreVueloExistente(vuelos, listaDatos, 1, "a modificar hora de llegada");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaHora(listaDatos, 2, "de llegada nueva");
		}
		if(!listaDatos.esVacia()) {
			this.modificarHoraLlegadaVuelo((String)listaDatos.recuperar(1),(String)listaDatos.recuperar(2));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion de modificacion de hora de llegada de vuelo cancelada");
		}
	}
	
	private void opAltaPasaje(Lista listaDatos) {
		this.entradaSalida.cargaDocumentoExistente(listaDatos, clientes, 1, 2, "propietario del pasaje");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaCyan("Lista de vuelos con asientos disponibles: "+this.listarVuelosPendientes().toString());
			this.entradaSalida.cargaNombreVueloExistente(vuelos, listaDatos, 3, "del pasaje");
			
		}
		if(!listaDatos.esVacia()) {
			Vuelo vuelo=(Vuelo)vuelos.obtenerDato((String)listaDatos.recuperar(3));//obtengo el vuelo para ver su lista de fechas
			this.entradaSalida.escribirConsolaCyan("Posibles fechas para el vuelo: "+this.traducirListaFechasVuelo(vuelo));
			this.entradaSalida.cargaFecha(listaDatos, 4, "del pasaje");
		}
		if(!listaDatos.esVacia()) {
			this.altaPasaje((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2), (String)listaDatos.recuperar(3), (String)listaDatos.recuperar(4));
		}
		
		
	}
	
	private void opBajaPasaje(Lista listaDatos) {
		this.entradaSalida.cargaDocumentoExistente(listaDatos, clientes, 1, 2, "dueño del pasaje");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaCyan("Lista de pasajes del cliente |P:Vuelo,Fecha,NroAsiento,Estado|: "+this.getListaPasajesCliente((String)listaDatos.recuperar(1),(String)listaDatos.recuperar(2)).toString());
			this.entradaSalida.cargaNombreVueloExistente(vuelos, listaDatos, 3, "del pasaje");
		}
		if(!listaDatos.esVacia()) {
			Vuelo vuelo=(Vuelo)vuelos.obtenerDato((String)listaDatos.recuperar(3));//obtengo el vuelo para ver su lista de fechas
			this.entradaSalida.escribirConsolaCyan("Posibles fechas para el vuelo: "+this.traducirListaFechasVuelo(vuelo));
			this.entradaSalida.cargaFecha(listaDatos, 4, "del vuelo del pasaje a dar de baja");
		}
		if(!listaDatos.esVacia()) {
			this.bajaPasaje((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2), (String)listaDatos.recuperar(3),(String)listaDatos.recuperar(4));
		}
		
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion de baja de pasaje cancelada");
		}
		
	}
	
	private void opModificarEstadoPasaje(Lista listaDatos) {
		this.entradaSalida.cargaDocumentoExistente(listaDatos, clientes, 1, 2, "dueño del pasaje");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaCyan("Lista de pasajes del cliente |P:Vuelo,Fecha,NroAsiento,Estado|: "+this.getListaPasajesCliente((String)listaDatos.recuperar(1),(String)listaDatos.recuperar(2)).toString());
			this.entradaSalida.cargaNombreVueloExistente(vuelos, listaDatos, 3, "del pasaje");
		}
		
		if(!listaDatos.esVacia()) {
			Vuelo vuelo=(Vuelo)vuelos.obtenerDato((String)listaDatos.recuperar(3));//obtengo el vuelo para ver su lista de fechas
			this.entradaSalida.escribirConsolaCyan("Posibles fechas para el vuelo: "+this.traducirListaFechasVuelo(vuelo));
			this.entradaSalida.cargaFecha(listaDatos, 4, "del pasaje");
		}
		
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaEstadoPasaje(listaDatos,5, vuelos, clientes);
		}
		
		if(!listaDatos.esVacia()) {
			this.modificarEstadoPasaje((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2),  (String)listaDatos.recuperar(3), (String)listaDatos.recuperar(4), (String)listaDatos.recuperar(5));
		}
		
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion de modificacion de estado de pasaje cancelada");
		}
		
	}
	
	private void opObtenerContactoYPasajesCliente(Lista listaDatos) {
		this.entradaSalida.cargaDocumentoExistente(listaDatos, clientes, 1, 2, "del que quiere obtener los datos");
		if(!listaDatos.esVacia()) {
			this.contactoCliente((String)listaDatos.recuperar(1),(String)listaDatos.recuperar(2));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion obtener contacto cliente cancelada");
		}
		
	}
	
	private void opObtenerCiudadesVisitadas(Lista listaDatos) {
		this.entradaSalida.cargaDocumentoExistente(listaDatos, clientes, 1, 2, "del que quiere saber que ciudades visito");
		if(!listaDatos.esVacia()) {
			this.obtenerCiudadesVisitadasCliente((String)listaDatos.recuperar(1),(String)listaDatos.recuperar(2));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion obtener ciudades visitadas cancelada");
		}
	}
	
	private void opObtenerDatosVuelo(Lista listaDatos) {
		this.entradaSalida.cargaNombreVueloExistente(vuelos, listaDatos, 1, "del cual quiere averiguar todos sus datos");
		if(!listaDatos.esVacia()) {
			Vuelo vuelo=(Vuelo)vuelos.obtenerDato((String)listaDatos.recuperar(1));//obtengo el vuelo para ver su lista de fechas
			this.entradaSalida.escribirConsolaCyan("Posibles fechas para el vuelo: "+this.traducirListaFechasVuelo(vuelo));
			this.entradaSalida.cargaFecha(listaDatos, 2, "del vuelo del cual quiere averiguar todos sus datos");
		}
		if(!listaDatos.esVacia()) {
			this.obtenerDatosVuelo((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion obtener datos vuelo cancelada");
		}
	}
	
	private void opObtenerCodigosVuelosRango(Lista listaDatos) {
		this.entradaSalida.cargaNombreVueloExistente(vuelos, listaDatos, 1, "para primer valor del rango");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaNombreVueloExistente(vuelos, listaDatos, 2, "para segundo valor del rango");
		}
		if(!listaDatos.esVacia()) {
			this.obtenerCodigosVuelosRango((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion obtener codigos vuelos en un rango cancelada");
		}
	}
	
	private void opCaminoEnNVuelos(Lista listaDatos) {
		this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 1, "de origen");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 2, "de destino");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaVuelosMax(listaDatos, 3);
		}
		if(!listaDatos.esVacia()) {
			this.caminoEnNVuelos((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2),(int)listaDatos.recuperar(3));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion obtener camino en N vuelos cancelada");
		}
	}
	
	private void opCaminoMenorTiempo(Lista listaDatos) {
		this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 1, "de origen");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 2, "de destino");
		}
		if(!listaDatos.esVacia()) {
			this.caminoMenorTiempo((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion obtener camino menor tiempo cancelada");
		}
		
	}
	
	private void opCaminoMenorAeropuertos(Lista listaDatos) {
		this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 1, "de origen");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 2, "de destino");
		}
		if(!listaDatos.esVacia()) {
			this.caminoMenosAeropuertos((String)listaDatos.recuperar(1), (String)listaDatos.recuperar(2));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion obtener camino pasando por menos aeropuertos cancelada");
		}
	}
	
	private void opCaminoConAeroIntermedio(Lista listaDatos) {
		this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 1, "de origen");
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 2, "intermedio");
		}
		if(!listaDatos.esVacia()) {
			this.entradaSalida.cargaNombreAeroExistente(aeropuertos, listaDatos, 3, "de destino");
		}
		if(!listaDatos.esVacia()) {
			this.caminoMasCortoConIntermedio((String)listaDatos.recuperar(1),(String)listaDatos.recuperar(2),(String)listaDatos.recuperar(3));
		}
		if(listaDatos.esVacia()) {
			this.entradaSalida.escribirConsolaError("Operacion obtener camino mas corto pasando por un aeropuerto intermedio cancelada");
		}
	}
	
	private void opListaClientesFieles(Lista listaDatos) {
		this.mostrarListaClientesFieles();
	}
	
	private void opMostrarSistema(Lista listaDatos) {
		this.mostrarSistema();
	}
	
	private boolean opSalirDelPrograma(Lista listaDatos) {
		boolean fin;
		this.mostrarSistema();//Imprimo el estado del sistema y cierro
		String cadena=("------------------------------------------FIN EJECUCION------------------------------------------");
		this.entradaSalida.escribirConsolaCyan(cadena);
		this.entradaSalida.escribirLog(cadena);
		fin=true;
		return fin;
	}
	public void altaAeropuerto(String nombreAeronautico, String ciudad,String nroTelefono) {
		String cadenaLog="Se cargo un aeropuerto al grafo de aeropuertos, Nombre aeronautico: "+nombreAeronautico+", Ciudad: "+ciudad+", nro Telefono: "+nroTelefono+"\n";
		String cadenaConsola="El aeropuerto con nombre aeronautico: "+nombreAeronautico+", Ciudad: "+ciudad+", nro Telefono: "+nroTelefono+" se cargo con exito.";
			Aeropuerto aeropuerto= new Aeropuerto(nombreAeronautico,ciudad,nroTelefono);//Creo un nuevo aeropuerto
			aeropuertos.insertarVertice(aeropuerto);
			entradaSalida.escribirLog(cadenaLog);
			this.entradaSalida.escribirConsolaVerde(cadenaConsola);
	}
	
	public void altaVuelo(String clave, String origenStr, String destinoStr, String horaSalida, String horaEntrada, String fecha,String nroAsientos) {
		int posAero;
		Aeropuerto origen=null;
		Aeropuerto destino=null;
		Vuelo nuevoVuelo;
		int tiempoEstimado;
		String cadenaConsola;
		String cadenaLog;
		Aeropuerto auxOrigen= new Aeropuerto(origenStr);//Creo una instancia de aeropuerto con el nombre para buscarlo
		Aeropuerto auxDestino= new Aeropuerto(destinoStr);
		Lista listaAeropuertos=aeropuertos.listarEnProfundidad();//Listo los aeropuertos para buscarlos
		posAero=listaAeropuertos.localizar(auxOrigen);
		origen=(Aeropuerto)listaAeropuertos.recuperar(posAero);
		posAero=listaAeropuertos.localizar(auxDestino);
		destino=(Aeropuerto)listaAeropuertos.recuperar(posAero);
		nuevoVuelo=new Vuelo(clave,origen,destino,horaSalida,horaEntrada,fecha,Integer.parseInt(nroAsientos));
		vuelos.insertar(clave, nuevoVuelo);
		cadenaLog="Se cargo un nuevo vuelo con clave: "+clave+", Fecha:"+fecha+", Origen: "+origen.getNombreAeronautico()+", Destino: "+destino.getNombreAeronautico()+", Hora de salida: "+horaSalida+", hora de entrada: "+horaEntrada+ ", Nro de asientos: "+nroAsientos+"\n";
		cadenaConsola="Se cargo un nuevo vuelo con clave: "+clave+", Fecha: "+fecha+", Origen: "+origen.getNombreAeronautico()+", Destino: "+destino.getNombreAeronautico()+", Hora de salida: "+horaSalida+", hora de entrada: "+horaEntrada+ ", Nro de asientos: "+nroAsientos+" con exito";
		this.entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaConsola);
		if(!aeropuertos.existeArco(origen, destino)) {//Verifico si ya existia un arco entre origen y destino si no lo agrego
			tiempoEstimado=this.calcularTiempo(horaSalida, horaEntrada);
			aeropuertos.insertarArco(origen, destino,tiempoEstimado);//Tiempo estimado en minutos
			entradaSalida.escribirLog("Se inserto un arco al grafo de aeropuertos, Origen: "+origen.getNombreAeronautico()+", Destino: "+destino.getNombreAeronautico()+", Duracion: "+tiempoEstimado+"\n");
		}
	}
	
	private void agregarFechaDeVuelo(String clave,String fecha,String nroAsientos) {
		VueloPorDia nuevoVueloDia;
		String cadenaConsola;
		String cadenaLog;
		Vuelo vuelo;
		Lista listaVueloPorDia;
		vuelo=(Vuelo)vuelos.obtenerDato(clave);
		listaVueloPorDia=vuelo.getListaVuelos();
		nuevoVueloDia=new VueloPorDia(fecha, (Integer.parseInt(nroAsientos)));//Creo un nuevo vuelo para esa fecha, considero que un mismo vuelo puede hacer muchos viajes una misma fecha
		listaVueloPorDia.insertar(nuevoVueloDia, listaVueloPorDia.longitud()+1);//Lo inserto en la lista de vuelos para ese vuelo
	    cadenaLog="Se cargo una nueva fecha para el vuelo con clave: "+clave+", Fecha:"+fecha+", Origen: "+vuelo.getOrigen().getNombreAeronautico()+", Destino: "+vuelo.getDestino().getNombreAeronautico()+", Hora de salida: "+vuelo.getHoraSalida()+", hora de entrada: "+vuelo.getHoraLlegada()+ ", Nro de asientos: "+nroAsientos+"\n";
		cadenaConsola="Se cargo una nueva fecha para el vuelo con clave: "+clave+", Fecha: "+fecha+", Origen: "+vuelo.getOrigen().getNombreAeronautico()+", Destino: "+vuelo.getDestino().getNombreAeronautico()+", Hora de salida: "+vuelo.getHoraSalida()+", hora de entrada: "+vuelo.getHoraLlegada()+ ", Nro de asientos: "+nroAsientos+" con exito";
		this.entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaConsola);
	}
	
	public void altaCliente(String tipoDoc, String nroDoc, String nombre, String apellido, String fechaNacimiento, String domicilio, String nroTelefono) {
		TipoYNroDoc documento= new TipoYNroDoc(tipoDoc,nroDoc);//Obtengo el documento
		Cliente cliente=new Cliente(documento,nombre,apellido,fechaNacimiento,domicilio,nroTelefono);//Creo un cliente
		String cadenaLog;
		String cadenaCons;
		clientes.insertar(documento, cliente);
		clientePasajes.put(cliente, new Lista());//Agrego el cliente al HashMap con una nueva lista para sus pasajes, El cliente es la clave del dato lista
		cadenaLog="Se cargo un cliente, Documento: "+documento.toString()+", Nombre: "+nombre+", Apellido: "+apellido+", Fecha de nacimiento: "+fechaNacimiento+", Domicilio: "+domicilio+", Nro telefono: "+nroTelefono+"\n";
		cadenaCons="Se cargo el cliente con documento: "+documento.toString()+", Nombre: "+nombre+", Apellido: "+apellido+", Fecha de nacimiento: "+fechaNacimiento+", Domicilio: "+domicilio+", Nro telefono: "+nroTelefono+" con exito";
		entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaCons);
		
	}
	
	public void altaPasaje(String tipoDoc,String nroDoc,String idVuelo,String fecha) {
		Pasaje pasaje;
		Vuelo vuelo;
		Cliente cliente;
		TipoYNroDoc documento;
		Lista pasajesCliente;
		String cadenaLog;
		String cadenaCons;
		VueloPorDia vueloDia;
		int posVueloDia;
		vuelo=(Vuelo)vuelos.obtenerDato(idVuelo);//Obtengo el vuelo para consultar sobre los asientos
		posVueloDia=vuelo.getListaVuelos().localizar(fecha);
		if(posVueloDia!=-1) {
			vueloDia=((VueloPorDia)vuelo.getListaVuelos().recuperar(posVueloDia));
			if(vueloDia.getNroAsientosVendidos()<vueloDia.getNroAsientos()) {
				documento=new TipoYNroDoc(tipoDoc,nroDoc);
				cliente=(Cliente)clientes.obtenerDato(documento);//Obtengo al cliente con el documento	
				pasaje=new Pasaje(vuelo,fecha,(vueloDia.getNroAsientosVendidos()+1),"Pendiente");//Creo pasaje
				pasajesCliente=(Lista)clientePasajes.get(cliente);//Obtengo la lista de pasajes del cliente
				pasajesCliente.insertar(pasaje, pasajesCliente.longitud()+1);//Inserto un nuevo pasaje en la lista de pasajes del cliente
				clientePasajes.put(cliente, pasajesCliente);//Re-Inserto la lista de pasajes actualizada al hashmap
				vueloDia.venderAsiento();//Inidico que hay un asiento mas vendido
				cadenaLog="Se cargo un pasaje, Cliente: "+cliente.getNombre()+" "+cliente.getApellido()+ " Vuelo: "+vuelo.getClave()+", Fecha: "+fecha+", Nro asiento: "+vueloDia.getNroAsientosVendidos()+" Estado: Pendiente\n";
				cadenaCons="Se cargo un pasaje del cliente: "+cliente.getNombre()+" "+cliente.getApellido()+ " Vuelo: "+vuelo.getClave()+", Fecha: "+fecha+", Nro asiento: "+vueloDia.getNroAsientosVendidos()+" Estado: Pendiente con exito";
				entradaSalida.escribirLog(cadenaLog);
				this.entradaSalida.escribirConsolaVerde(cadenaCons);
			}else {
				this.entradaSalida.escribirLog("ERROR DE CARGA DE PASAJE PARA EL VUELO "+vuelo.getClave()+": Todos los asientos ya estan vendidos");
				entradaSalida.escribirConsolaError("El vuelo "+vuelo.getClave() +" ya tiene todos los asientos vendidos");
			}
		}else {
			this.entradaSalida.escribirLog("ERROR DE CARGA DE PASAJE PARA EL VUELO "+vuelo.getClave()+": No existe el vuelo para la fecha "+fecha);
			entradaSalida.escribirConsolaError("No existe vuelo "+vuelo.getClave() +" para la fecha: "+fecha);
		}
	}

	private int calcularTiempo(String horaSalida, String horaEntrada) {
		int horaInicio=Integer.parseInt(horaSalida.substring(0, horaSalida.indexOf(":")));
		int minInicio=Integer.parseInt(horaSalida.substring(horaSalida.indexOf(":")+1, 5));
		int horaFin=Integer.parseInt(horaEntrada.substring(0, horaSalida.indexOf(":")));;
		int minFin=Integer.parseInt(horaEntrada.substring(horaSalida.indexOf(":")+1, 5));;
		int salida= (horaFin*60+minFin)-(horaInicio*60+minInicio);
		if(horaSalida.compareTo(horaEntrada)>1) {
			salida+=24*60;
		}
		salida=Math.abs(salida);
		return salida;
	}
	
	
	private void bajaAeropuerto(String nombreAero) {
		Lista listaAero= aeropuertos.listarEnProfundidad();//Listo todos los aeropuertos para buscar el que corresponda
		String cadenaLog;
		String cadenaCons;
		Aeropuerto aeropuerto=new Aeropuerto(nombreAero);
		int posAero= listaAero.localizar(aeropuerto);
		Aeropuerto aeroAct=(Aeropuerto)listaAero.recuperar(posAero);
		this.elimVuelosAero(aeroAct);//Elimino los vuelos que van hacia el aeropuerto a eliminar
		aeropuertos.eliminarVertice(aeroAct);//Elimino el aeropuerto del grafo de aeropuertos
		cadenaLog="Se dio de baja el aeropuerto "+nombreAero+" con exito\n";
		cadenaCons="Se dio de baja el aeropuerto "+nombreAero+" con exito";
		entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaCons);
	}
	
	private void elimVuelosAero(Aeropuerto aeropuerto) {
		Lista listaVuelos= vuelos.listarDatos();
		int i=1;
		Vuelo vuelo;
		while(i<=listaVuelos.longitud()) {
			vuelo=(Vuelo)listaVuelos.recuperar(i);
			if(vuelo.getDestino().equals(aeropuerto)) {
				this.bajaVuelo(vuelo.getClave());//Baja vuelo funciona con el string no con la instancia, desde baja vuelo se eliminan los pasajes
			}
			i++;
		}
	}
	
	private void modificarTelefAero(String nombreAero,String nuevoNroTelefono) {
		Lista listaAero=aeropuertos.listarEnProfundidad();
		Aeropuerto aero= new Aeropuerto(nombreAero);
		int posAero=listaAero.localizar(aero);
		aero=(Aeropuerto)listaAero.recuperar(posAero);
		String nroViejo=aero.getNroTelefono();
		String cadenaLog="Se modifico el numero de telefono del aeropuerto "+aero.getNombreAeronautico()+" de: "+nroViejo+" a: "+nuevoNroTelefono+"\n";
		String cadenaCons="Se modifico el numero de telefono del aeropuerto "+aero.getNombreAeronautico()+" de: "+nroViejo+" a: "+nuevoNroTelefono+" con exito";
		aero.setNroTelefono(nuevoNroTelefono);
		entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaCons);
	}

	private void bajaPasaje(String tipoDoc,String nroDoc,String idVuelo,String fecha) {
		boolean exito=false;
		Cliente cliente=(Cliente) clientes.obtenerDato(new TipoYNroDoc(tipoDoc,nroDoc));
		Lista listaPasajes= (Lista)clientePasajes.get(cliente);
		Pasaje pasaje;
		Vuelo vuelo;
		int posPasaje;
		String cadenaLog;
		String cadenaCons;
		VueloPorDia vueloDia;
		int posVueloDia;
		vuelo=(Vuelo)vuelos.obtenerDato(idVuelo);
		posVueloDia=vuelo.getListaVuelos().localizar(fecha);
		if(posVueloDia!=-1) {//Si hay vuelo para esa fecha
			vueloDia=((VueloPorDia)vuelo.getListaVuelos().recuperar(posVueloDia));
			posPasaje=listaPasajes.localizar(new Pasaje(vuelo,fecha,(vueloDia.getNroAsientosVendidos()+1),"Pendiente"));
			if(posPasaje>0) {
				vueloDia.liberarUnAsiento();//Libero un asiento del vuelo
				pasaje=((Pasaje)listaPasajes.recuperar(posPasaje));
				pasaje.setEstado("Cancelado");//Seteo el pasaje a cancelado
				cadenaLog="Se dio de baja un pasaje del cliente: "+cliente.getClave()+", vuelo: "+pasaje.getVuelo().getClave()+", Fecha: "+fecha+", Origen: "+pasaje.getVuelo().getOrigen().getNombreAeronautico()+", Destino: "+pasaje.getVuelo().getDestino().getNombreAeronautico()+"\n";
				cadenaCons="Se dio de baja un pasaje del cliente: "+cliente.getClave()+", vuelo: "+pasaje.getVuelo().getClave()+", Fecha: "+fecha+", Origen: "+pasaje.getVuelo().getOrigen().getNombreAeronautico()+", Destino: "+pasaje.getVuelo().getDestino().getNombreAeronautico()+" con exito";
				entradaSalida.escribirLog(cadenaLog);
				this.entradaSalida.escribirConsolaVerde(cadenaCons);
				exito=true;
			}
		}
		if(!exito) {
			this.entradaSalida.escribirLog("ERROR AL DAR DE BAJA UN PASAJE DEL CLIENTE "+cliente.getClave()+": El cliente no tiene ningun pasaje relacionado con el vuelo: "+idVuelo+" para la fecha: "+fecha);
			entradaSalida.escribirConsolaError("El cliente no tiene ningun pasaje relacionado con el vuelo: "+idVuelo+" para la fecha: "+fecha);
		}
	}

	private void modificarEstadoPasaje(String tipoDoc,String nroDoc,String idVuelo, String fecha, String nuevoEstado) {
		boolean exito=false;
		Cliente cliente=(Cliente) clientes.obtenerDato(new TipoYNroDoc(tipoDoc,nroDoc));
		Lista listaPasajes;
		Pasaje pasaje;
		int posPasaje;
		String viejoEstado;
		String cadenaLog;
		String cadenaCons;
		Vuelo vuelo;
		int posVueloDia;
		VueloPorDia vueloDia;
			listaPasajes=(Lista) clientePasajes.get(cliente);
			vuelo=(Vuelo)vuelos.obtenerDato(idVuelo);
			posVueloDia=vuelo.getListaVuelos().localizar(fecha);
			if(posVueloDia!=-1) {//Si hay vuelo para esa fecha
				vueloDia=((VueloPorDia)vuelo.getListaVuelos().recuperar(posVueloDia));
				posPasaje=listaPasajes.localizar(new Pasaje(vuelo,fecha,(vueloDia.getNroAsientosVendidos()+1),"Pendiente"));
				if(posPasaje!=-1) {//Si encontre el pasaje en la lista
					pasaje=(Pasaje)listaPasajes.recuperar(posPasaje);
					viejoEstado=pasaje.getEstado();
					if(nuevoEstado.equals("Cancelado")) {
						this.bajaPasaje(tipoDoc, nroDoc, idVuelo,fecha);
					}else {
						pasaje.setEstado(nuevoEstado);
					}
					exito=true;
					cadenaLog="Se modifico el estado de un pasaje del cliente: "+cliente.getClave()+", vuelo: "+pasaje.getVuelo().getClave()+", Fecha: "+pasaje.getFecha()+", Origen: "+pasaje.getVuelo().getOrigen().getNombreAeronautico()+", Destino: "+pasaje.getVuelo().getDestino().getNombreAeronautico()+", de: "+viejoEstado+", a: "+nuevoEstado+"\n";
					cadenaCons="Se modifico el estado de un pasaje del cliente: "+cliente.getClave()+", vuelo: "+pasaje.getVuelo().getClave()+", Fecha: "+pasaje.getFecha()+", Origen: "+pasaje.getVuelo().getOrigen().getNombreAeronautico()+", Destino: "+pasaje.getVuelo().getDestino().getNombreAeronautico()+", de: "+viejoEstado+", a: "+nuevoEstado+" con exito";
					entradaSalida.escribirLog(cadenaLog);
					this.entradaSalida.escribirConsolaVerde(cadenaCons);
				}
			}
			if(!exito) {
				this.entradaSalida.escribirLog("ERROR AL MODIFICAR ESTADO DE UN PASAJE DEL CLIENTE "+cliente.getClave()+": No existe pasaje con vuelo "+vuelo.getClave()+" para la fecha: "+fecha);
				entradaSalida.escribirConsolaError("No existe pasaje con vuelo "+vuelo.getClave()+" para la fecha: "+fecha);
			}
	}

	private void bajaCliente(String tipoDoc, String nroDoc) {
		TipoYNroDoc documento=new TipoYNroDoc(tipoDoc,nroDoc);
		Cliente cliente=(Cliente)clientes.obtenerDato(documento);
		Lista listaPasajes;
		Pasaje pasaje;
		Vuelo vuelo;
		String cadenaLog;
		String cadenaCons;
		
		listaPasajes=(Lista) clientePasajes.get(cliente);
		for (int i = 1; i < listaPasajes.longitud()+1; i++) {//Para cada pasaje
			pasaje=((Pasaje)listaPasajes.recuperar(i));//Recupero un pasaje de la lista
			if(pasaje.getEstado().equals("Pendiente")) {//Si esta pendiente por volar
				vuelo=pasaje.getVuelo();//Obtengo el vuelo del pasaje
				this.bajaPasaje(tipoDoc, nroDoc, vuelo.getClave(),pasaje.getFecha());//Doy de baja al pasaje
			}
		}
		listaPasajes=(Lista) clientePasajes.get(cliente);
		clientes.eliminar(documento);//Elimino el cliente del diccionario
		cadenaLog="Se dio de baja al cliente: "+cliente.getApellido()+" "+cliente.getNombre()+", "+cliente.getClave()+"\n";
		cadenaCons="Se dio de baja al cliente: "+cliente.getApellido()+" "+cliente.getNombre()+", "+cliente.getClave()+" con exito";
		entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaCons);
	}
	
	private void modificarDomicilioCliente(String tipoDoc, String nroDoc, String nuevoDom) {
		TipoYNroDoc documento=new TipoYNroDoc(tipoDoc,nroDoc);
		Cliente cliente=(Cliente)clientes.obtenerDato(documento);
		String cadenaLog;
		String cadenaCons;
		String viejoDom;
		viejoDom= cliente.getDomicilio();
		cliente.setDomicilio(nuevoDom);
		cadenaLog="Se modifico el domicilio del cliente: "+cliente.getClave()+" de: "+viejoDom+", a: "+nuevoDom+"\n";
		cadenaCons="Se modifico el domicilio del cliente: "+cliente.getClave()+", de: "+viejoDom+", a: "+nuevoDom+" con exito";
		entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaCons);

	}
	
	private void modificarTelefonoCliente(String tipoDoc, String nroDoc, String nuevoNro) {
		TipoYNroDoc documento=new TipoYNroDoc(tipoDoc,nroDoc);
		Cliente cliente=(Cliente)clientes.obtenerDato(documento);
		String viejoNro=cliente.getNroTelefono();
		String cadenaLog;
		String cadenaCons;
		cliente.setDomicilio(nuevoNro);
		cadenaLog="Se modifico el telefono del cliente: "+cliente.getClave()+" de: "+viejoNro+", a: "+nuevoNro+"\n";
		cadenaCons="Se modifico el telefono del cliente: "+cliente.getClave()+", de: "+viejoNro+", a: "+nuevoNro+" con exito";
		entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaCons);
	}
	
	private void bajaVuelo(String idVuelo) {
		Vuelo vuelo=(Vuelo) vuelos.obtenerDato(idVuelo);
		String cadenaLog;
		String cadenaCons;
		this.cancelarPasajes(vuelo);
		vuelos.eliminar(idVuelo);
		cadenaLog="Se elimino el vuelo: "+idVuelo+"\n";
		cadenaCons="Se elimino el vuelo: "+idVuelo+" con exito";
		entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaCons);
	}
	
	public boolean modificarHoraSalidaVuelo(String idVuelo, String nuevaHora) {//Afecta al arco del grafo????
		Vuelo vuelo=(Vuelo) vuelos.obtenerDato(idVuelo);
		boolean exito=false;
		String cadenaLog;
		String cadenaCons;
		String horaVieja;
		Aeropuerto origen=(Aeropuerto)vuelo.getOrigen();
		Aeropuerto destino=(Aeropuerto)vuelo.getDestino();
		int nuevoTiempo;
		horaVieja=vuelo.getHoraSalida();
		vuelo.setHoraSalida(nuevaHora);
		nuevoTiempo=this.calcularTiempo(nuevaHora, vuelo.getHoraLlegada());
		aeropuertos.modificarEtiquetaArco(origen, destino, nuevoTiempo);
		exito=true;
		cadenaLog="Se modifico hora de salida del vuelo: "+vuelo.getClave()+" de: "+horaVieja+"hs a: "+nuevaHora+"hs\n";
		cadenaCons="Se modifico hora de salida del vuelo: "+vuelo.getClave()+" de: "+horaVieja+"hs a: "+nuevaHora+"hs con exito";
		entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaCons);
		return exito;
	}
	
	public boolean modificarHoraLlegadaVuelo(String idVuelo, String nuevaHora) {
		Vuelo vuelo=(Vuelo) vuelos.obtenerDato(idVuelo);
		boolean exito=false;
		String cadenaLog;
		String cadenaCons;
		String horaVieja;
		Aeropuerto origen=(Aeropuerto)vuelo.getOrigen();
		Aeropuerto destino=(Aeropuerto)vuelo.getDestino();
		int nuevoTiempo;
		horaVieja=vuelo.getHoraLlegada();
		vuelo.setHoraLlegada(nuevaHora);
		nuevoTiempo=this.calcularTiempo(vuelo.getHoraSalida(),nuevaHora);
		aeropuertos.modificarEtiquetaArco(origen, destino, nuevoTiempo);
		exito=true;
		cadenaLog="Se modifico hora de llegada del vuelo: "+vuelo.getClave()+" de: "+horaVieja+"hs a: "+nuevaHora+"hs\n";
		cadenaCons="Se modifico hora de llegada del vuelo: "+vuelo.getClave()+" de: "+horaVieja+"hs a: "+nuevaHora+"hs con exito";
		entradaSalida.escribirLog(cadenaLog);
		this.entradaSalida.escribirConsolaVerde(cadenaCons);
		return exito;
	}
	private void cancelarPasajes(Vuelo vuelo) {//Para no repetir metodo hago que reciba al aeropuerto o al vuelo, y que el otro sea null
		Lista listaClientes=clientes.listarDatos();
		Lista listaPasajes=null;
		Pasaje pasaje=null;
		for (int i = 1; i < listaClientes.longitud()+1; i++) {//Para cada cliente voy a buscar su lista de pasajes
			listaPasajes=(Lista) clientePasajes.get(listaClientes.recuperar(i));//Obtengo la lista de pasajes de un cliente
			for (int j = 1; j < listaPasajes.longitud()+1; j++) {//Para cada pasaje de la lista del cliente
				pasaje=((Pasaje)listaPasajes.recuperar(j));//Obtengo un pasaje de la lista
				this.cancelarPasajesVuelo(vuelo,pasaje,listaClientes,i);//No uso baja pasaje para aprovechar la busqueda de aca, si lo usase tendria que enviar los datos string y repetiria la busqueda
																		//Ademas de que daria error si el pasaje no coincidiese con el cliente
			}
		}
	}
	
	private void cancelarPasajesVuelo(Vuelo vuelo,Pasaje pasaje,Lista listaClientes,int posLista) {
		Cliente cliente;
		String cadenaLog;
		String cadenaCons;
		if(pasaje.getVuelo().equals(vuelo) ){
			if(pasaje.getEstado().equals("Pendiente")) {//Solo modificara los pasajes pendientes
				pasaje.setEstado("Cancelado");
			}
			cliente=((Cliente)listaClientes.recuperar(posLista));
			cadenaLog="Se cancelo el pasaje del vuelo: "+pasaje.getVuelo().getClave()+" con origen: "+pasaje.getVuelo().getOrigen().getNombreAeronautico()+" y destino: "+pasaje.getVuelo().getDestino().getNombreAeronautico()+". Del cliente: "+cliente.getNombre()+" "+cliente.getApellido()+" "+cliente.getClave()+" [CAUSA: ELIMINACION DE AEROPUERTO DE ORIGEN O DESTINO]\n";
			cadenaCons="Se cancelo el pasaje del vuelo: "+pasaje.getVuelo().getClave()+" con origen: "+pasaje.getVuelo().getOrigen().getNombreAeronautico()+" y destino: "+pasaje.getVuelo().getDestino().getNombreAeronautico()+". Del cliente: "+cliente.getNombre()+" "+cliente.getApellido()+" "+cliente.getClave()+" con exito";
			entradaSalida.escribirLog(cadenaLog);
			this.entradaSalida.escribirConsolaVerde(cadenaCons);
		}
	}

	private void contactoCliente(String tipoDoc,String nroDoc) {
		Cliente cliente= (Cliente)clientes.obtenerDato(new TipoYNroDoc(tipoDoc,nroDoc));
		String datosCliente="Contacto de "+cliente.getNombre()+" "+cliente.getApellido()+" "+cliente.getClave()+":\nTelefono: "+cliente.getNroTelefono();
		Lista listaPasajes= this.getListaPasajesCliente(tipoDoc,nroDoc);
		Lista listaPasajesTraduc=this.traducirListaPasajesPendientes(listaPasajes);
		String stringLista="Lista de pasajes del cliente: "+listaPasajesTraduc.toString()+"\n";
		String cadena=datosCliente+"\n"+stringLista;
		
		this.entradaSalida.escribirLog(cadena);
		this.entradaSalida.escribirConsolaVerde(cadena);
	}
	
	private Lista getListaPasajesCliente(String tipoDoc, String nroDoc) {
		Cliente cliente= (Cliente)clientes.obtenerDato(new TipoYNroDoc(tipoDoc,nroDoc));
		return (Lista)clientePasajes.get(cliente);
	}
	
	private Lista traducirListaPasajesPendientes(Lista listaPasajes) {
		Lista listaTraduc=new Lista();
		String infoPasaje;
		Pasaje pasaje;
		int contLista=1;
		for (int i = 1; i < listaPasajes.longitud()+1; i++) {
			pasaje=((Pasaje)listaPasajes.recuperar(i));
			if(pasaje.getEstado().equals("Pendiente")) {
				infoPasaje="Pasaje con vuelo: "+pasaje.getVuelo().getClave()+", en fecha: "+pasaje.getFecha();
				listaTraduc.insertar(infoPasaje, contLista);
				contLista++;
			}
		}
		return listaTraduc;
	}	
	
	private Lista traducirListaFechasVuelo(Vuelo vuelo) {
		Lista listaVuelos=vuelo.getListaVuelos();
		VueloPorDia vueloDia;
		String infoVuelo;
		Lista listaTraduc=new Lista();
		for (int i = 1; i < listaVuelos.longitud()+1; i++) {
			vueloDia=(VueloPorDia)listaVuelos.recuperar(i);
			infoVuelo="Vuelo "+vuelo.getClave()+" Fecha: "+vueloDia.getFecha();
			listaTraduc.insertar(infoVuelo, i);
		}
		return listaTraduc;
	}
	
	private void obtenerCiudadesVisitadasCliente(String tipoDoc,String nroDoc) {
		Cliente cliente= (Cliente)clientes.obtenerDato(new TipoYNroDoc(tipoDoc,nroDoc));
		Lista listaPasajes= (Lista)clientePasajes.get(cliente);
		Lista listaVisitas=new Lista();
		String cadena;
		Pasaje pasaje;
		String ciudad;
		int posCiudad;
		int contListaVisitas=1;
		for (int i = 1; i < listaPasajes.longitud()+1; i++) {
			pasaje=((Pasaje)listaPasajes.recuperar(i));
			if(pasaje.getEstado().equals("Volado")) {
				ciudad=pasaje.getVuelo().getDestino().getCiudad();
				posCiudad=listaVisitas.localizar(ciudad);
				if(posCiudad==-1) {//Para que no aparezcan ciudades repetidas
					listaVisitas.insertar(ciudad, contListaVisitas);
					contListaVisitas++;
				}
			}
		}
		cadena="Lista de ciudades visitadas por el cliente, "+cliente.getNombre()+" "+cliente.getApellido()+", "+cliente.getClave()+": "+listaVisitas.toString();
		this.entradaSalida.escribirLog(cadena);
		this.entradaSalida.escribirConsolaVerde(cadena);
	}
	
	private void obtenerDatosVuelo(String nombreVuelo, String fecha) {
		Vuelo vuelo=(Vuelo)vuelos.obtenerDato(nombreVuelo);
		Lista listaVuelosDia=vuelo.getListaVuelos();
		int posVueloDia=listaVuelosDia.localizar(fecha);
		String datosVuelo;
		if(posVueloDia!=-1) {
			VueloPorDia vueloDia=(VueloPorDia)listaVuelosDia.recuperar(posVueloDia);
			datosVuelo="Datos del vuelo "+vuelo.getClave()+": Origen: "+vuelo.getOrigen().getNombreAeronautico()+", Destino: "+vuelo.getDestino().getNombreAeronautico()+", Hora de salida: "+vuelo.getHoraSalida()+", Hora de llegada: "+vuelo.getHoraLlegada()+", Fecha: "+fecha+", Numero de asientos en venta: "+vueloDia.getNroAsientos()+", Numero de asientos disponibles: "+vueloDia.nroAsientosDisponibles();
			this.entradaSalida.escribirLog(datosVuelo);
			this.entradaSalida.escribirConsolaVerde(datosVuelo);
		}else {
			this.entradaSalida.escribirLog("ERROR AL INTENTAR OBTENER LOS DATOS DEL VUELO "+vuelo.getClave()+" PARA LA FECHA "+fecha+": No existe vuelo para dicha fecha");
			entradaSalida.escribirConsolaError("No existe vuelo "+vuelo.getClave()+" para la fecha: "+fecha);
		}
	}
	
	private void obtenerCodigosVuelosRango(String nombreVuelo1, String nombreVuelo2) {
		Lista listaVuelos=vuelos.listarDatos();
		Vuelo vuelo;
		Lista listaCodigosVuelo= new Lista();
		String cadena="";
		if(nombreVuelo1.compareTo(nombreVuelo2)<=0) {
			for (int i = 1; i < listaVuelos.longitud()+1; i++) {
				vuelo=(Vuelo)listaVuelos.recuperar(i);
				if(vuelo.getClave().compareTo(nombreVuelo1)>=0 && vuelo.getClave().compareTo(nombreVuelo2)<=0) {
					listaCodigosVuelo.insertar(vuelo.getClave(), listaCodigosVuelo.longitud()+1);
				}
			}
			cadena="Codigos de vuelo en rango ["+nombreVuelo1+","+nombreVuelo2+"]: "+listaCodigosVuelo.toString();
		}else {
			if(nombreVuelo1.compareTo(nombreVuelo2)>0) {//Para que no importe el orden de ingreso de codigos
				for (int i = 1; i < listaVuelos.longitud()+1; i++) {
					vuelo=(Vuelo)listaVuelos.recuperar(i);
					if(vuelo.getClave().compareTo(nombreVuelo2)>=0 && vuelo.getClave().compareTo(nombreVuelo1)<=0) {
						listaCodigosVuelo.insertar(vuelo.getClave(), listaCodigosVuelo.longitud()+1);
					}
				}
				cadena="Codigos de vuelo en rango ["+nombreVuelo2+","+nombreVuelo1+"]: "+listaCodigosVuelo.toString();
			}
		}
		this.entradaSalida.escribirLog(cadena);
		this.entradaSalida.escribirConsolaVerde(cadena);
	}
	
	
	private void mostrarListaClientesFieles() {
		String cadena; 
		Lista listaSalida=this.listarClientesFieles();
		cadena=this.traducirListaClientesNroPasajes(listaSalida).toString();//Como cargaba clientes para mostrarlo de manera correcta tengo recorrer la lista para imprimir sus claves y cantidad de pasajes
	    this.entradaSalida.escribirLog(cadena);
	    this.entradaSalida.escribirConsolaVerde(cadena);
	}
	private Lista listarClientesFieles() {
		Lista listaClientes = clientes.listarDatos();
		Lista listaPasajes;
		Lista listaSalida=new Lista();
        Cliente cliente;
	    for (int i = 1; i < listaClientes.longitud()+1; i++) {
			cliente=(Cliente)listaClientes.recuperar(i);
			listaPasajes=(Lista)clientePasajes.get(cliente);//Obtengo la lista de pasajes
			if(listaSalida.esVacia()) {
				listaSalida.insertar(cliente, 1);
			}else {
				this.insertarEnOrden(listaSalida, listaPasajes, cliente);//Se carga el cliente en la lista
			}
		}
        return listaSalida;
	}

	private void insertarEnOrden(Lista listaSalida, Lista listaPasajes, Cliente cliente) {
		boolean insertado=false;
		Lista listaPasajesEnSalida;
		int posLista=1;
		while(!insertado && posLista<=listaSalida.longitud()) {
			listaPasajesEnSalida=(Lista)clientePasajes.get(((Cliente)listaSalida.recuperar(posLista)));//obtengo la lista de pasajes del cliente en la lista de salida
			if(listaPasajes.longitud()>=listaPasajesEnSalida.longitud()) {
				listaSalida.insertar(cliente, posLista);//Si es mayor o igual ocupara su lugar y lo desplazara a la derecha
				insertado=true;
			}else {//Si es menor me muevo a la derecha y verifico con el siguiente
				posLista++;
			}
		}
		if(posLista>listaSalida.longitud()) {//Si ya recorri toda la lista lo inserto al final porque seria el menor de todos
			listaSalida.insertar(cliente, listaSalida.longitud()+1);
		}
	}
	
	private Lista traducirListaClientesNroPasajes(Lista listaSalida) {
		Lista listaTraduc=new Lista();
		Lista listaPasajes;
		String infoCliente;
		Cliente cliente;
		for (int i = 1; i < listaSalida.longitud()+1; i++) {
			cliente=((Cliente)listaSalida.recuperar(i));
			listaPasajes=(Lista)clientePasajes.get(cliente);
			infoCliente="Cliente: "+cliente.getNombre()+" "+cliente.getApellido()+" "+cliente.getClave()+" nro de pasajes: "+listaPasajes.longitud();
			listaTraduc.insertar(infoCliente, i);
		}
		return listaTraduc;
	}
	
	public void mostrarSistema() {
		String cadena;
		/*Lista listaAeropuertos= aeropuertos.listarEnProfundidad();
		Lista listaVuelos=vuelos.listarDatos();
		Lista listaClientes=clientes.listarDatos();
		cadena="DATOS AEROPUERTOS: A: Nombre aeronautico,Ciudad,Numero de telefono:";
		this.entradaSalida.escribirConsolaCyan(cadena);
		this.mostrarAeropuertos(listaAeropuertos);
		
		cadena="DATOS VUELOS: V: Nombre del vuelo,Origen,Destino,Hora salida,Hora llegada,Fecha,Cantidad de asientos total:";
		this.entradaSalida.escribirConsolaCyan(cadena);
		this.mostrarVuelos(listaVuelos);
		
		cadena="DATOS CLIENTES: C: Tipo documento,nroDocumento,Nombre,Apellido,Fecha de nacimiento,Direccion,Numero de telefono:";
		this.entradaSalida.escribirConsolaCyan(cadena);
		this.mostrarClientes(listaClientes);
		
		cadena="DATOS PASAJES: P: Nombre del vuelo,Fecha,Numero de asiento del cliente,Estado,Documento del dueño del pasaje";
		this.entradaSalida.escribirConsolaCyan(cadena);
		this.mostrarPasajes(listaClientes);
		
		cadena="Lista clientes fieles: "+this.listarClientesFieles().toString();
		*/
		cadena="ESTRUCTURA GRAFO AEROPUERTOS";
		this.entradaSalida.escribirConsolaCyan(cadena);
		this.entradaSalida.escribirConsolaVerde(aeropuertos.toString()+"\n");
		
		cadena="ESTRUCTURA DICCIONARIO VUELOS";
		this.entradaSalida.escribirConsolaCyan(cadena);
		this.entradaSalida.escribirConsolaVerde(vuelos.toString()+"\n");
		
		cadena="ESTRUCTURA DICCIONARIO CLIENTES";
		this.entradaSalida.escribirConsolaCyan(cadena);
		this.entradaSalida.escribirConsolaVerde(clientes.toString()+"\n");
		
		
		this.entradaSalida.escribirLog("Se mostro estructuras del sistema al cliente");
	}
	
	/*private void mostrarAeropuertos(Lista listaAeropuertos) {
		String cadena;
		Aeropuerto aeropuerto;
		for (int i = 1; i < listaAeropuertos.longitud()+1; i++) {
			aeropuerto=((Aeropuerto)listaAeropuertos.recuperar(i));
			cadena=aeropuerto.toString()+"\n";
			this.entradaSalida.escribirLog(cadena);
			this.entradaSalida.escribirConsolaVerde(cadena);
			cadena="\n";
		}
	}
	
	private void mostrarVuelos(Lista listaVuelos){
		String cadena;
		Vuelo vuelo;
		for (int i = 1; i < listaVuelos.longitud()+1; i++) {
			vuelo=(Vuelo)listaVuelos.recuperar(i);
			cadena=vuelo.toString()+"\n";
			this.entradaSalida.escribirLog(cadena);
			this.entradaSalida.escribirConsolaVerde(cadena);
			cadena="";
		}
	}
	
	private void mostrarClientes(Lista listaClientes) {
		String cadena;
		Cliente cliente;
		for (int i = 1; i < listaClientes.longitud()+1; i++) {
			cliente=(Cliente)listaClientes.recuperar(i);
			cadena=cliente.toString()+"\n";
			this.entradaSalida.escribirLog(cadena);
			this.entradaSalida.escribirConsolaVerde(cadena);
			cadena="";
		}
	}
	
	private void mostrarPasajes(Lista listaClientes) {
		Lista listaPasajes;
		Cliente cliente;
		Pasaje pasaje;
		String cadena;
		for (int i = 1; i < listaClientes.longitud()+1; i++) {
			cliente=(Cliente)listaClientes.recuperar(i);
			listaPasajes=(Lista)clientePasajes.get(cliente);
			for (int j = 1; j < listaPasajes.longitud()+1; j++) {
				pasaje=(Pasaje)listaPasajes.recuperar(j);
				cadena=pasaje.toString()+","+cliente.getClave()+"\n";
				this.entradaSalida.escribirLog(cadena);
				this.entradaSalida.escribirConsolaVerde(cadena);
				cadena="";
			}
		}
	}*/
	
	private void caminoEnNVuelos(String nombreAeroOrigen, String nombreAeroDest, int nroMax) {
		Lista listaAeropuertos=aeropuertos.listarEnProfundidad();
		Aeropuerto aeroOrigen=new Aeropuerto(nombreAeroOrigen);
		Aeropuerto aeroDestino= new Aeropuerto(nombreAeroDest);
		int posOrigen=listaAeropuertos.localizar(aeroOrigen);
		int posDestino=listaAeropuertos.localizar(aeroDestino);
		Aeropuerto origen=(Aeropuerto)listaAeropuertos.recuperar(posOrigen);
		Aeropuerto destino=(Aeropuerto)listaAeropuertos.recuperar(posDestino);
		Lista camino=aeropuertos.caminoEnNVuelos(origen, destino,nroMax);
		String cadena;
		if(!camino.esVacia() && camino.longitud()-1<=nroMax) {
			cadena="Es posible llegar del aeropuerto "+nombreAeroOrigen+" al aeropuerto "+nombreAeroDest+" en "+nroMax+" vuelos o menos, ruta de viaje: "+camino.toString();
		}else {
			cadena="No es posible llegar del aeropuerto "+nombreAeroOrigen+" al aeropuerto "+nombreAeroDest+" en "+nroMax+" vuelos o menos";
		
		}
		this.entradaSalida.escribirLog(cadena);
		this.entradaSalida.escribirConsolaVerde(cadena);
	}
	
	private void caminoMenorTiempo(String nombreAeroOrigen,String nombreAeroDest) {
		Lista listaAeropuertos=aeropuertos.listarEnProfundidad();
		Aeropuerto aeroOrigen=new Aeropuerto(nombreAeroOrigen);
		Aeropuerto aeroDestino= new Aeropuerto(nombreAeroDest);
		int posOrigen=listaAeropuertos.localizar(aeroOrigen);
		int posDestino=listaAeropuertos.localizar(aeroDestino);
		Aeropuerto origen=(Aeropuerto)listaAeropuertos.recuperar(posOrigen);
		Aeropuerto destino=(Aeropuerto)listaAeropuertos.recuperar(posDestino);
		Object[] arrayDatos=aeropuertos.caminoMenorTiempo(origen, destino);
		int tiempoCamino=(int)arrayDatos[0];
		Lista camino=(Lista)arrayDatos[1];
		String cadena;
		if(camino.longitud()>1) {//Si no hay recorrido camino= |0|
			cadena="Es posible llegar del aeropuerto "+nombreAeroOrigen+" al aeropuerto "+nombreAeroDest+" en un tiempo minimo de "+tiempoCamino+" minutos";
			camino.eliminar(1);//Elimino la posicion (El tiempo) para que no aparezca en la ruta de viaje
			cadena+=", ruta de viaje: "+camino.toString();
		}else {
			cadena="No es posible llegar del aeropuerto "+nombreAeroOrigen+" al aeropuerto "+nombreAeroDest;
		}
		this.entradaSalida.escribirLog(cadena);
		this.entradaSalida.escribirConsolaVerde(cadena);
	}
	
	private void caminoMenosAeropuertos(String nombreAeroOrigen, String nombreAeroDest) {
		Lista listaAeropuertos=aeropuertos.listarEnProfundidad();
		Aeropuerto aeroOrigen=new Aeropuerto(nombreAeroOrigen);
		Aeropuerto aeroDestino= new Aeropuerto(nombreAeroDest);
		int posOrigen=listaAeropuertos.localizar(aeroOrigen);
		int posDestino=listaAeropuertos.localizar(aeroDestino);
		Aeropuerto origen=(Aeropuerto)listaAeropuertos.recuperar(posOrigen);
		Aeropuerto destino=(Aeropuerto)listaAeropuertos.recuperar(posDestino);
		Lista camino=aeropuertos.caminoMenorLong(origen, destino);
		String cadena;
		if(!camino.esVacia()) {
			cadena="Es posible llegar del aeropuerto "+nombreAeroOrigen+" al aeropuerto "+nombreAeroDest+", ruta de viaje: "+camino.toString();
		}else {
			cadena="No es posible llegar del aeropuerto "+nombreAeroOrigen+" al aeropuerto "+nombreAeroDest;
		
		}
		this.entradaSalida.escribirLog(cadena);
		this.entradaSalida.escribirConsolaVerde(cadena);
	}
	
	private void caminoMasCortoConIntermedio(String nombreAeroOrigen,String nombreAeroMedio,String nombreAeroDest) {
		Lista listaAeropuertos=aeropuertos.listarEnProfundidad();
		Aeropuerto aeroOrigen=new Aeropuerto(nombreAeroOrigen);
		Aeropuerto aeroMedio=new Aeropuerto(nombreAeroMedio);
		Aeropuerto aeroDestino= new Aeropuerto(nombreAeroDest);
		int posOrigen=listaAeropuertos.localizar(aeroOrigen);
		int posMedio=listaAeropuertos.localizar(aeroMedio);
		int posDestino=listaAeropuertos.localizar(aeroDestino);

		Aeropuerto origen=(Aeropuerto)listaAeropuertos.recuperar(posOrigen);
		Aeropuerto intermedio=(Aeropuerto)listaAeropuertos.recuperar(posMedio);
		Aeropuerto destino=(Aeropuerto)listaAeropuertos.recuperar(posDestino);
		Object[] arrayDatos=aeropuertos.caminoMasCortoConIntermedio(origen, destino, intermedio);
		int tiempoCamino=(int)arrayDatos[0];
		Lista camino=(Lista)arrayDatos[1];
		String cadena;
		if(camino.longitud()>1) {//Si no hay recorrido camino= |0|
			cadena="Es posible llegar del aeropuerto "+nombreAeroOrigen+" al aeropuerto "+nombreAeroDest+" pasando por el aeropuerto "+nombreAeroMedio+" en un tiempo minimo de "+tiempoCamino+" minutos";
			camino.eliminar(1);//Elimino la posicion (El tiempo) para que no aparezca en la ruta de viaje
			cadena+=", ruta de viaje: "+camino.toString();
		}else {
			cadena="No es posible llegar del aeropuerto "+nombreAeroOrigen+" al aeropuerto "+nombreAeroDest+" pasando por el aeropuerto "+nombreAeroMedio;
		}
		this.entradaSalida.escribirLog(cadena);
		this.entradaSalida.escribirConsolaVerde(cadena);
	}
	
	private Lista listarVuelosPendientes() {
		Lista listaVuelos=vuelos.listarDatos();
		Lista listaVuelosConAsientos=new Lista();
		for (int i = 1; i < listaVuelos.longitud()+1; i++) {
			this.listarVuelosDisponibles(((Vuelo)listaVuelos.recuperar(i)), listaVuelosConAsientos);
		}
		return listaVuelosConAsientos;
	}
	
	private void listarVuelosDisponibles(Vuelo vuelo, Lista lista) {
		Lista listaVuelos=vuelo.getListaVuelos();
		VueloPorDia vueloDia;
		String infoVuelo;
		int posLista=1;
		for (int i = 1; i < listaVuelos.longitud()+1; i++) {
			vueloDia=(VueloPorDia)listaVuelos.recuperar(i);
			if(vueloDia.nroAsientosDisponibles()>0) {//Si hay asientos disponibles lo listo al vuelo
				infoVuelo="Vuelo "+vuelo.getClave();
				lista.insertar(infoVuelo, posLista);
				posLista++;
			}
		}
	}
}
