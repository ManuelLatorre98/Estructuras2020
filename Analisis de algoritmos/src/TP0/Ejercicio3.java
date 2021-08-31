package TP0;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ejercicio3 {
	public static void main(String[] args) {
		try {
			BufferedWriter bufferEscritura= new BufferedWriter(new FileWriter("src/TP0/realesRandom"));
			long inicio=System.nanoTime();
			Random generadorNum = new Random();
			double max=101;
			double min=-100;
			
			for (int i = 0; i < 100; i++) {
				bufferEscritura.write(((generadorNum.nextDouble()*(max-min)+min) +", "));
			}
			long fin= System.nanoTime();
			System.out.println("EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
			bufferEscritura.close();
		}
		catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos escribir no existe.");
        }
		catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
	}
	
	
}
