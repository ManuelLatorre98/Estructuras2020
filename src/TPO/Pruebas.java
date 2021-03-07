package TPO;

import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import Grafos.GrafoEtiq;
import PropositoEspecifico.Diccionario;
import lineales.dinamicas.Lista;

public class Pruebas {
	public static void main(String[] args) throws FileNotFoundException {
		/*LocalDate fechaNacimiento;
		LocalDate fechaNacimiento2;
		fechaNacimiento=LocalDate.parse("15/01/19", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		
		DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM/yyyy");//convierto la fecha en cadena de texto para MOSTRARLA
		System.out.println(fechaNacimiento.format(formatoFecha));
		
		Lista lista=new Lista();
		EntradaSalida entradaSalida=new EntradaSalida();
		entradaSalida.lectura(lista);
		System.out.println(lista.toString());
		String linea="";
		BufferedReader buff;
		buff = new BufferedReader(new FileReader("C:\\Users\\manul\\Desktop\\TPO Estructuras\\DatosSistemaVuelos.txt"));
		try {
			char caracter=(char)buff.read();
			buff.skip(2);//Me muevo 2 caracteres (el : y el espacio)
			metodo(buff);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void metodo(BufferedReader buff) {
		String linea="";
		try {
			linea=buff.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringTokenizer st= new StringTokenizer(linea, " ,");
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
	}
		Aeropuerto aeropuerto= new Aeropuerto("NQN","Nequen","123");
		Aeropuerto aeropuerto2= new Aeropuerto("MDQ","MarDel","1234");
		GrafoEtiq mapa=new GrafoEtiq();
		mapa.insertarVertice(aeropuerto);
		mapa.insertarVertice(aeropuerto2);
		mapa.insertarArco(aeropuerto, aeropuerto2);
		System.out.println(mapa.existeArco(aeropuerto2, aeropuerto));
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    ZoneId zona = ZoneId.systemDefault();
		File log=new File("C:\\Users\\manul\\Desktop\\TPO Estructuras\\LOG.txt");
		try {
			FileWriter fw= new FileWriter(log.getAbsoluteFile(),true);
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write(formattedDate+"["+zona+"]: Hola buenas tardes\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		SistemaViajes sist= new SistemaViajes();
		sist.cargaDatosAutomatica();
		sist.menu();
		}
	
	
	
}
