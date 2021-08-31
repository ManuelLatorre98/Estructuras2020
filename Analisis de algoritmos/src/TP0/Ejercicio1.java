package TP0;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class Ejercicio1 {
	public static void main(String[] args) {
		String linea;
		
		try {
			BufferedReader bufferLectura= new BufferedReader(new FileReader ("src/TP0/txtInPunto1.txt"));
			BufferedWriter bufferEscritura= new BufferedWriter(new FileWriter("src/TP0/sinEspacios.txt"));
			long inicio=System.nanoTime();
			
			//PRIMER MANERA, El promedio de tiempo de ejecucion en ns me da un poco mas alto que con la segunda
			while ((linea = bufferLectura.readLine()) != null) {
				bufferEscritura.write(linea.replace(" ", "")+"\n");//Los espacios entre lineas cuentan? borrar \n si es asi
            }//452500ns
			
			//SEGUNDA MANERA, El promedio de ejecucion en ns da un poco menor que en la primera
			/*char caracter;
			while((linea = bufferLectura.readLine()) !=null) {
				for (int i = 0; i < linea.length(); i++) {
					if((caracter=linea.charAt(i))!=' ') {
						bufferEscritura.write(caracter);
					}
					linea.replace("", " ");
				}
				bufferEscritura.write("\n");//Borrar si tambien habia que eliminar los espacios en blanco
			}//242600ns bastante mas eficiente que con replace*/
			
			long fin=System.nanoTime();
			System.out.println("EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
			bufferLectura.close();
			bufferEscritura.close();
			
		}
		catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
		catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
		
		
	}
}
