package TP0;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

public class Ejercicio5 {
	public static void main(String[] args) {
		try {
			BufferedWriter bufferEscritura= new BufferedWriter(new FileWriter("src/TP0/numRandomSinRep"));
			long inicio=System.nanoTime();
			Random generador = new Random();
			int max=1001;
			int min=1;
			int contNum=0;
			int num;
			Hashtable hash= new Hashtable();
			
			while(contNum<1000) {
				num=(generador.nextInt(max - min) + min);
				if(hash.get(num)==null) {
					bufferEscritura.write(num +", ");
					hash.put(num, num);
					contNum++;
				}
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
