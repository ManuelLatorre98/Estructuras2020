package TPO;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

import Grafos.GrafoEtiq;
import PropositoEspecifico.Diccionario;
import lineales.dinamicas.Lista;

public class EntradaSalida {
	private Scanner sc= new Scanner(System.in);
	private SistemaViajes sistemaViajes;
	private static final String GREEN = "\033[0;32m";   // GREEN
	public static final String CYAN = "\033[0;36m";    // CYAN
	public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
	public static final String RED = "\033[0;31m";     // RED
	private static final String RESET = "\033[0m";  // Text Reset

	public EntradaSalida() {
		
	}
	public void cargaAutomatica(Diccionario vuelos, GrafoEtiq aeropuertos, Diccionario clientes, HashMap clientePasajes,SistemaViajes elSistemaViajes) {
		this.sistemaViajes=elSistemaViajes;
		String linea="";
		BufferedReader buff=null;
		StringTokenizer st;
		char caracter;
		try {
			buff = new BufferedReader(new FileReader("C:\\Users\\manul\\Desktop\\TPO Estructuras\\DatosSistemaVuelos.txt"));
		} catch (FileNotFoundException e1) {
		}
		this.escribirLog("_______________________________________________________________________________________________________\n");
		this.escribirLog("                                         NUEVA EJECUCION\n");
		this.escribirLog("_______________________________________________________________________________________________________ \n");
		try {
			while(buff.ready()) {//Mientras exista una linea para leer
				caracter=(char)buff.read();//Leo primer caracter de linea
				buff.skip(2);//Me muevo 2 caracteres (el : y el espacio)
				try {
					linea=buff.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				st=new StringTokenizer(linea,",");//Selecciono la linea de la que quiero sacar los datos y el limite de estos
				
				switch(caracter) {//Realizo la operacion de carga de datos correspondiente
				case 'A':
						this.cargaAeropuertosAuto(aeropuertos,st);//Envio el st para que extraiga los datos de a uno
					break;
				case 'V':
						this.cargaVuelosAuto(st);
					break;
				case 'C':
						this.cargaClienteAuto(st);
					break;
				case 'P':
						this.cargaPasajeAuto(st);
					break;
				}
			}
			linea=buff.readLine();//Salto de linea
			if(linea!=null) {//Si existe linea siguiente
			caracter=(char)buff.read();//Leo primer caracter
			}
		} catch (IOException e) {
		}
	}
	private void cargaAeropuertosAuto(GrafoEtiq aeropuertos, StringTokenizer st) {
		String nombreAeronautico=st.nextToken();
		String ciudad=st.nextToken();
		String nroTelefono=st.nextToken();
		this.sistemaViajes.altaAeropuerto(nombreAeronautico, ciudad, nroTelefono);
	}
	
	private void cargaVuelosAuto(StringTokenizer st) {
		String clave= st.nextToken();
		String origenStr= st.nextToken();
		String destinoStr=st.nextToken();
		String horaSalida=st.nextToken();
		String horaEntrada=st.nextToken();
		String fecha=st.nextToken();
		String nroAsientos=st.nextToken();
		this.sistemaViajes.altaVuelo(clave, origenStr, destinoStr, horaSalida, horaEntrada, fecha,nroAsientos);
	}

	private void cargaClienteAuto(StringTokenizer st) {
		String tipoDoc=st.nextToken();
		String nroDoc=st.nextToken();
		String nombre=st.nextToken();
		String apellido=st.nextToken();
		String fechaNacimiento=st.nextToken();
		String domicilio=st.nextToken();
		String nroTelefono=st.nextToken();
		this.sistemaViajes.altaCliente(tipoDoc, nroDoc, nombre, apellido, fechaNacimiento, domicilio, nroTelefono);
		
	}

	private void cargaPasajeAuto(StringTokenizer st) {
		String tipoDoc= st.nextToken();
		String nroDoc= st.nextToken();
		String idVuelo= st.nextToken();
		String fecha= st.nextToken();
		this.sistemaViajes.altaPasaje(tipoDoc,nroDoc, idVuelo, fecha);
	}
	
	public int opciones() {
		int opcion=0;
		boolean exito=false;
		while(!exito) {
		try {
			System.out.println(CYAN+"------------------------------------------EDATViajes------------------------------------------"+RESET);
			System.out.println("Seleccione una de las opciones ingresando el numero correspondiente (Solo el numero sin el punto)");
			System.out.println("1. Agregar un nuevo aeropuerto al sistema");
			System.out.println("2. Agregar un nuevo cliente al sistema");
			System.out.println("3. Agregar un nuevo vuelo al sistema");
			System.out.println("4. Agregar un nuevo pasaje");
			System.out.println("5. Agregar un nueva fecha para vuelo al sistema");
			System.out.println("6. Modificar telefono de un aeropuerto");
			System.out.println("7. Modificar domicilio de un cliente");
			System.out.println("8. Modificar numero de telefono de un cliente");
			System.out.println("9. Modificar hora de salida de un vuelo");
			System.out.println("10. Modificar hora de llegada a destino de un vuelo");
			System.out.println("11. Modificar estado de un pasaje");
			System.out.println("12. Dar de baja un aeropuerto del sistema");
			System.out.println("13. Dar de baja un cliente del sistema");
			System.out.println("14. Dar de baja un vuelo del sistema");
			System.out.println("15. Dar de baja de baja el pasaje de un cliente");
			System.out.println("16. Obtener contacto y pasajes pendientes de un cliente");
			System.out.println("17. Obtener ciudades visitadas");
			System.out.println("18. Obtener todos los datos de un vuelo");
			System.out.println("19. Obtener codigos de vuelo en un rango dado");
			System.out.println("20. Verificar si se puede llegar de un aeropuerto A a un aeropuerto B en n vuelos");
			System.out.println("21. Obtener camino que llegue de un aeropuerto A a un aeropuerto B en el menor tiempo posible");
			System.out.println("22. Obtener camino de un aeropuerto A a un aeropuerto B pasando por la menor cantidad de aeropuertos");
			System.out.println("23. Obtener camino que llegue de un aeropuerto A a un aeropuerto B pasando por un aeropuerto C en el menor tiempo posible");
			System.out.println("24. Generar lista clientes fieles");
			System.out.println("25. Mostrar sistema");
			System.out.println("26. Salir del programa");
			System.out.print(CYAN_UNDERLINED+"Seleccione una opcion:"+RESET+" ");
			opcion=sc.nextInt();
			sc.nextLine();//Limpio buffer
			if(opcion>0 && opcion<27) {//Si se sale del limite repetira con el while
				System.out.println("\n");//2 "Renglones" de separacion
				exito=true;
			}else {
				System.out.println(RED+"Opcion ingresada no valida, ingrese una opcion valida de la lista"+RESET);
			}
		}catch(InputMismatchException ex) {//try-catch por si se ingresa cualquier cosa que no sea un entero
			System.out.println(RED+"Opcion ingresada no valida, ingrese una opcion valida de la lista"+RESET);
			sc.nextLine();//Paso a la siguiente linea para limpiar el buffer
		}
		}
		return opcion;
	}
	

	public void cargaNombreAeroInexistente(GrafoEtiq aeropuertos, Lista listaDatos,int posLista,String infoOp) {
		String nombreAeronautico="";
		Aeropuerto aeropuerto;
		boolean exitoIngreso=false;
		boolean cancelar=false;
		while(!exitoIngreso && !cancelar) {
			System.out.print("Ingrese nombre aeronautico del aeropuerto "+infoOp+" (Maximo 3 caracteres)[Si desea cancelar la carga ingrese la letra C]: ");
			nombreAeronautico=sc.nextLine();
			cancelar=this.verificaCancelar(nombreAeronautico);
			aeropuerto=new Aeropuerto(nombreAeronautico);
			if(!cancelar) {//Si no lo cancelo procedo 
				if(!aeropuertos.existeVertice(aeropuerto) && nombreAeronautico.length()==3) {//Si no existe el aeropuerto no pedira re ingreso
					exitoIngreso=true;
				}else {
					if(aeropuertos.existeVertice(aeropuerto)) {
						System.out.println(RED+"Ya existe un aeropuerto con el nombre aeronautico: "+nombreAeronautico+RESET);
					}else {
						System.out.println(RED+"El nombre aeronautico "+nombreAeronautico+" no es valido, debe consistir de 3 letras"+RESET);
					}
				}
			}
		}
		if(!cancelar) {
			listaDatos.insertar(nombreAeronautico, posLista);
		}else {
			listaDatos.vaciar();
		}
	}
	
	public void cargaCiudad(Lista listaDatos,int posLista, String infoOp) { //Opcion 1
		String ciudad="";
		boolean cancelar=false;
		if(!cancelar) {//Si no se cancelo la carga pido los datos restantes
			System.out.print("Ingrese nombre de la ciudad "+infoOp+"[Si desea cancelar la carga ingrese la letra C]: ");
			ciudad=sc.nextLine();
			cancelar=this.verificaCancelar(ciudad);
		}
		if(!cancelar) {
			listaDatos.insertar(ciudad, posLista);
		}else {
			listaDatos.vaciar();//Si se cancelo la operacion retorno una lista vacia;
		}
	} 
	public void cargaNombreAeroExistente(GrafoEtiq aeropuertos, Lista listaDatos,int posLista,String infoOp) {
		String aeropuerto="";
		Aeropuerto aeropuertoIns;
		boolean exito=false;
		boolean cancelar=false;
		while(!exito && !cancelar) {
			System.out.print("Ingrese nombre aeronautico del aeropuerto "+infoOp+"[Si desea cancelar la carga ingrese la letra C]: ");
			aeropuerto=sc.nextLine();
			cancelar=this.verificaCancelar(aeropuerto);
			if(!cancelar) {
				aeropuertoIns=new Aeropuerto(aeropuerto);//Creo una instancia para ver si existe un aeropuerto igual en el grafo
				if(aeropuertos.existeVertice(aeropuertoIns)) {
					
					exito=true;
				}else {
					System.out.println(RED+"El aeropuerto con el nombre aeronautico "+aeropuerto+" no existe"+RESET);
				}
			}
		}
		if(!cancelar) {
			listaDatos.insertar(aeropuerto, posLista);
		}else {
			listaDatos.vaciar();//Si se cancelo la operacion retorno una lista vacia;
		}
	}
	
	public void cargaTelefono(Lista listaDatos,int posLista,String infoOp) { //Opcion 3
		String telefono="";
		boolean cancelar=false;
		if(!cancelar) {
			System.out.print("Ingrese numero de telefono "+infoOp+" [Si desea cancelar la carga ingrese la letra C]: ");
			telefono=sc.nextLine();
			cancelar=this.verificaCancelar(telefono);
		}
		if(!cancelar) {
			listaDatos.insertar(telefono, posLista);
		}else {
			listaDatos.vaciar();//Si se cancelo la operacion retorno una lista vacia;
		}
	}
	
	public void cargaDocumentoInexistente(Lista listaDatos, Diccionario clientes,int posLista,int posListaSeg,String infoOp) {
		TipoYNroDoc documento=null;
		String tipoDoc="";
		String nroDoc="";
		boolean exitoIngreso=false;
		boolean cancelar=false;
		while(!exitoIngreso && !cancelar) {
			System.out.print("Ingrese tipo de documento del cliente "+infoOp+"[Si desea cancelar la carga ingrese la letra C]: ");
			tipoDoc=sc.nextLine();
			cancelar=this.verificaCancelar(tipoDoc);
			if(!cancelar) {
				System.out.print("Ingrese numero de documento del cliente "+infoOp+"[Si desea cancelar la carga ingrese la letra C]: ");
				nroDoc=sc.nextLine();
				cancelar=this.verificaCancelar(nroDoc);
				if(!cancelar) {
					documento=new TipoYNroDoc(tipoDoc,nroDoc);
					if(!clientes.existeClave(documento)) {
						exitoIngreso=true;//Si no existe el documento del cliente voy a poder ingresar los otros datos
					}else {
						System.out.println(RED+"Ya existe un cliente con documento "+documento.toString()+RESET);
					}
				}
				
			}
		}
		if(!cancelar) {
			listaDatos.insertar(tipoDoc, posLista);
			listaDatos.insertar(nroDoc, posListaSeg);
		}else {
			listaDatos.vaciar();
		}
	}
	
	public void cargaNombreYApellido(Lista listaDatos, Diccionario clientes,int posLista,int posListaSeg,String infoOp) {
		String nombre="";
		String apellido="";
		boolean cancelar=false;
		if(!cancelar) {
			System.out.print("Ingrese nombre del cliente "+infoOp+" [Si desea cancelar la carga ingrese la letra C]: ");
			nombre=sc.nextLine();
			cancelar=this.verificaCancelar(nombre);	
		}
		if(!cancelar) {
			System.out.print("Ingrese apellido del cliente "+infoOp+"[Si desea cancelar la carga ingrese la letra C]: ");
			apellido=sc.nextLine();
			cancelar=this.verificaCancelar(apellido);
		}
		if(!cancelar) {
			listaDatos.insertar(nombre, posLista);
			listaDatos.insertar(apellido, posListaSeg);
		}else {
			listaDatos.vaciar();
		}
	}
	
	public void cargaFecha(Lista listaDatos,int posLista,String infoOp) {
		String fechaNac="";
		boolean cancelar=false;
		boolean exitoFecha=false;
		while(!exitoFecha && !cancelar) {
			System.out.print("Ingrese fecha "+infoOp+" (En formato dd/mm/aaaa, Ejemplo: 15/01/2021)[Si desea cancelar la carga ingrese la letra C]: ");
			fechaNac=sc.nextLine();
			cancelar=this.verificaCancelar(fechaNac);
			if(!cancelar) {
				exitoFecha=verificaFormatoFecha(fechaNac);
			}
		}
		if(!cancelar) {
			listaDatos.insertar(fechaNac, posLista);
		}else {
			listaDatos.vaciar();
		}
	}
	
	private boolean verificaFormatoFecha(String unaFecha) {
		LocalDate fecha;
		boolean verifica=true;
		try {//Lo uso para asegurar de que todas las fechas tengan el mismo formato "dd/MM/yyyy"
			fecha=LocalDate.parse(unaFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));//Podria borrarlo??
		}catch(DateTimeParseException ex) {
			System.out.println(RED+"La fecha ingresada "+unaFecha+" no tiene el formato correcto (dd/MM/aaaa)"+RESET);
			verifica=false;
		}
		return verifica;
	}
	
	public void cargaDomicilio(Lista listaDatos, Diccionario clientes,int posLista,String infoOp) {
		String domicilio="";
		boolean cancelar=false;
		System.out.print("Ingrese domicilio "+infoOp+" [Si desea cancelar la carga ingrese la letra C]: ");
		domicilio=sc.nextLine();
		cancelar=this.verificaCancelar(domicilio);
		if(!cancelar) {
			listaDatos.insertar(domicilio, posLista);
		}else {
			listaDatos.vaciar();
		}
			
	}
	
	public void cargaDocumentoExistente(Lista listaDatos, Diccionario clientes,int posLista,int posListaSeg,String infoOp) {
		String tipoDoc="";
		String nroDoc="";
		TipoYNroDoc documento;
		boolean cancelar=false;
		boolean exito=false;
		while(!exito && !cancelar) {
			System.out.print("Ingrese tipo de documento del cliente "+infoOp+"[Si desea cancelar la carga ingrese la letra C]: ");
			tipoDoc=sc.nextLine();
			cancelar=this.verificaCancelar(tipoDoc);
			if(!cancelar) {
				System.out.print("Ingrese numero de documento del cliente "+infoOp+"[Si desea cancelar la carga ingrese la letra C]: ");
				nroDoc=sc.nextLine();
				cancelar=this.verificaCancelar(nroDoc);
			}
			
			if(!cancelar) {
				documento=new TipoYNroDoc(tipoDoc,nroDoc);
				if(clientes.existeClave(documento)) {
					exito=true;
				}else {
					System.out.println(RED+"No existe cliente con el documento: "+documento.toString()+RESET);
				}
			}
		}
		
		if(!cancelar) {
			listaDatos.insertar(tipoDoc, posLista);
			listaDatos.insertar(nroDoc, posListaSeg);
		}else {
			listaDatos.vaciar();
		}
	}
	
	public void cargaNombreVueloInexistente(Diccionario vuelos,Lista listaDatos,int posLista,String infoOp) {
		String nombreVuelo="";
		boolean exitoIngreso=false;
		boolean cancelar=false;
		while(!exitoIngreso && !cancelar) {
			System.out.print("Ingrese nombre del vuelo "+infoOp +"(6 caracteres) [Si desea cancelar la carga ingrese la letra C]: ");
			nombreVuelo=sc.nextLine();
			cancelar=this.verificaCancelar(nombreVuelo);
			if(!cancelar) {
				if(nombreVuelo.length()==6) {
					if(!vuelos.existeClave(nombreVuelo)) {
						exitoIngreso=!vuelos.existeClave(nombreVuelo);//Si no existe el vuelo hubo exito
					}else {
						System.out.println(RED+"El nombre del nuevo vuelo ya existe"+RESET);//Repite ingreso
					}
				}else {
					System.out.println(RED+"Nombre de vuelo invalido, debe tener 6 caracteres"+RESET);//Repite ingreso
				}
			}
		}
		if(!cancelar) {
			listaDatos.insertar(nombreVuelo, posLista);
		}else {
			listaDatos.vaciar();
		}
	}

	public void cargaHora(Lista listaDatos,int posLista, String infoOp) {
		String hora="";
		boolean cancelar=false;
		boolean exitoIngreso=false;
		while(!cancelar && !exitoIngreso) {//Aseguro que todos los vuelos tengan el mismo formato de hora
			System.out.print("Ingrese hora "+infoOp+"(Formato hh:mm, Ejemplo: 14:00) [Si desea cancelar la carga ingrese la letra C]: ");
			hora=sc.nextLine();
			cancelar=this.verificaCancelar(hora);
			if(!cancelar) {
				if(this.verificarFormatoHora(hora)) {
					exitoIngreso=true;
				}else {
					System.out.println(RED+"Formato de hora invalido, debe cumplir con el formato hh:mm"+RESET);
				}
			}
		}
		if(!cancelar) {
			listaDatos.insertar(hora, posLista);
		}else {
			listaDatos.vaciar();
		}
	}
	
	private boolean verificarFormatoHora(String hora) {
		boolean exito=true;
		SimpleDateFormat df = new SimpleDateFormat("hh:mm");
	       try {
	           df.parse(hora);
	       } catch (ParseException e) {
	    	   exito=false;
	       }
	       
	       if(hora.length()!=5) {
	    	   exito=false;
	       }
	    return exito;
	}
	
	public void cargaAsientos(Lista listaDatos,int posLista, String infoOp) {
		boolean cancelar=false;
		boolean exitoIngreso=false;
		String nroAsi="";
		while(!cancelar && !exitoIngreso) {
			System.out.print("Ingrese numero de asientos disponibles para el vuelo[Si desea cancelar la carga ingrese la letra C]: ");
			nroAsi=sc.nextLine();
			cancelar=this.verificaCancelar(nroAsi);
			if(!cancelar) {
				try {
					Integer.parseInt(nroAsi);
					if(nroAsi.length()>0) {
						exitoIngreso=true;
					}
				}catch(NumberFormatException e) {
					System.out.println(RED+"Numero de asientos invalido, no se aceptan ni letras ni simbolos"+RESET);
				}
			}
		}
		if(!cancelar) {
			listaDatos.insertar(nroAsi, posLista);
		}else {
			listaDatos.vaciar();
		}
	}
	
	public void cargaNombreVueloExistente(Diccionario vuelos,Lista listaDatos,int posLista,String infoOp) {
		String nombreVuelo="";
		boolean encontrado=false;
		boolean cancelar=false;
		while(!cancelar && !encontrado) {
			System.out.print("Ingrese el nombre del vuelo "+infoOp +"[Si desea cancelar la carga ingrese la letra C]: ");
			nombreVuelo=sc.nextLine();
			cancelar=this.verificaCancelar(nombreVuelo);
			if(!cancelar) {
				if(vuelos.existeClave(nombreVuelo)) {
					encontrado=true;
				}else {
					System.out.println(RED+"El nombre de vuelo ingresado no corresponde a ningun vuelo en el sistema"+RESET);
				}
			}else {
				System.out.println(RED+"Operacion de baja de vuelo cancelada"+RESET);
			}
		}
		if(!cancelar) {
			listaDatos.insertar(nombreVuelo, posLista);
		}else {
			listaDatos.vaciar();
		}
	}
	
	public void cargaEstadoPasaje(Lista listaDatos,int posLista,Diccionario vuelos,Diccionario clientes) {
		String nuevoEstado="";
		boolean cancelar=false;
		boolean exitoIngreso=false;
		while(!cancelar && !exitoIngreso) {
			if(!cancelar) {
				System.out.print("Ingrese nuevo estado del pasaje (Pendiente, Cancelado ó Volado)[Si desea cancelar la carga ingrese la letra C]: ");
				nuevoEstado=sc.nextLine();
				cancelar=this.verificaCancelar(nuevoEstado);	
				if(nuevoEstado.equals("Pendiente")||nuevoEstado.equals("Cancelado")|| nuevoEstado.equals("Volado")) {
					exitoIngreso=true;
				}else {
					System.out.println(RED+"Estado invalido debe ingresar una de las tres opciones indicadas"+RESET);
				}
			}
		}
		if(!cancelar) {
			listaDatos.insertar(nuevoEstado, posLista);
		}else {
			listaDatos.vaciar();
		}
	}
	
	public void cargaVuelosMax(Lista listaDatos, int posLista) {
		String nroMax="";
		boolean cancelar=false;
		boolean exitoIngreso=false;
		while(!cancelar && !exitoIngreso) {
			System.out.print("Ingrese numero maximo de vuelos [Si desea cancelar la carga ingrese la letra C]:");
			nroMax=sc.nextLine();
			cancelar=this.verificaCancelar(nroMax);
			if(!cancelar && Integer.parseInt(nroMax)>0) {
				exitoIngreso=true;
			}else {
				System.out.println(RED+"El numero de vuelos maximos a realizar debe ser mayor a 0"+RESET);
			}
		}
		if(!cancelar) {
			listaDatos.insertar(Integer.parseInt(nroMax),posLista);
		}else {
			listaDatos.vaciar();
		}
	}
	
	private boolean verificaCancelar(String cadenaIng) {
		boolean cancelar=false;
		if(cadenaIng.equals("C")||cadenaIng.equals("c")) {//Veo si quiere cancelar
			cancelar=true;
		}
		return cancelar;
	}
	public void escribirLog(String cadenaLog) {//Aprovecho para escribir por consola los mensajes de exito de las operaciones
		LocalDateTime myDateObj = LocalDateTime.now();//Seteo formato de hora a mostrar
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    ZoneId zona = ZoneId.systemDefault();
	    
		File log=new File("C:\\Users\\manul\\Desktop\\TPO Estructuras\\LOG.txt");//Accedo al archivo que quiero leer
		try {
			FileWriter fw= new FileWriter(log.getAbsoluteFile(),true);
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write(formattedDate+"["+zona+"]: "+cadenaLog);//Escribo en el archivo la cadena recibida
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void escribirConsolaError(String cadenaConsola) {
		System.out.println(RED+cadenaConsola+RESET);
	}
	public void escribirConsola(String cadenaConsola) {
		System.out.println(cadenaConsola);
	}
	public void escribirConsolaVerde(String cadenaConsola) {
		System.out.println(GREEN+cadenaConsola+RESET);
	}
	public void escribirConsolaCyan(String cadenaConsola) {
		System.out.println(CYAN+cadenaConsola+RESET);
	}
}
