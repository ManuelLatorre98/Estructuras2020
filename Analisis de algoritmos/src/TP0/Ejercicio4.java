package TP0;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ejercicio4 {
	public static void main(String[] args) {
		try {
			BufferedWriter bufferEscritura= new BufferedWriter(new FileWriter("src/TP0/cadenasRandom"));
			long inicio=System.nanoTime();
			Random generador = new Random();
			int tipo;
			String cadena="";
			
			/*for (int i = 0; i < 100; i++) {
				cadena+=(char)(generador.nextInt(123 - 97) + 97)+" ";
			}
			System.out.println(cadena);*/
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					tipo=generador.nextInt(3);
					if(tipo==0) {//genero cadena de numeros
						cadena+=(char)(generador.nextInt(58 - 48) + 48);
					}else {
						if(tipo==1) {
							cadena+=(char)(generador.nextInt(91 - 65) + 65);
						}else {
							cadena+=(char)(generador.nextInt(123 - 97) + 97);
						}
					}
				}
				bufferEscritura.write(cadena+"\n");
				cadena="";
			}
			System.out.println(cadena);
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
