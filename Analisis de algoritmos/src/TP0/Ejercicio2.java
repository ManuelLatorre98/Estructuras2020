package TP0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2 {
	public static void main(String[] args) {
		try {
			BufferedReader bufferLectura= new BufferedReader(new FileReader ("src/TP0/txtInPunto1.txt"));
			BufferedWriter bufferEscritura= new BufferedWriter(new FileWriter("src/TP0/lineasImpares.txt"));
			String linea;
			int contLinea=1;
			long inicio=System.nanoTime();
			while((linea= bufferLectura.readLine())!=null) {
				if(contLinea%2==0) {
					bufferEscritura.write(linea+"\n");
				}
				contLinea++;
			}
			
			long fin= System.nanoTime();
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
