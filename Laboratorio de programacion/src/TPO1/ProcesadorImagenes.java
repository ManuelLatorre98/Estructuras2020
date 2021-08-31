package TPO1;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ProcesadorImagenes extends RecursiveAction{
	private List<Imagen>imagenes;
	private int primera;
	private int ultima;
	
	public ProcesadorImagenes(List<Imagen>imagenes, int primera, int ultima) {
		this.imagenes=imagenes;
		this.primera=primera;
		this.ultima=ultima;
	}
	
	@Override
	protected void compute() {
		if(this.calcularTamLista()<300) {//Si la lista de imagenes a procesar tiene un peso menor a 300mb
			this.procesar();
		}else {
			int medio=(ultima+primera)/2;
			System.out.println("LA LISTA ES MUY PESADA ("+this.calcularTamLista()+") LA DIVIDO EN 2. imagenes Listas de imagenes pendientes por procesar: "+getQueuedTaskCount()); //Me indica cuantas tareas pendientes hay en la cola
			ProcesadorImagenes p1= new ProcesadorImagenes(imagenes, primera, medio+1);//Agarro la mitad de las imagenes y se la asigno a una nueva tarea
			ProcesadorImagenes p2= new ProcesadorImagenes(imagenes, medio+1, ultima);//Agarro la otra mitad y se la asigno a otra tarea
			ForkJoinTask.invokeAll(p1,p2);
			//invokeAll(p1,p2);//Meto las 2 nuevas tareas en la pool
			
		}
	}
	
	
	private int calcularTamLista() {
		int tamTot=0;
		System.out.println();
		for (int i = primera; i < ultima; i++) {
			tamTot+= this.imagenes.get(i).getTamañoMb();
		}
		
		
		return tamTot;
	}
	
	private void procesar() {
		System.out.println("Procesando lista de imagenes de "+this.calcularTamLista()+"mb"+" cantIMG: "+(ultima-primera));
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {}
		System.out.println("Termino con exito lista de "+this.calcularTamLista()+"mb");
		//Aca irian las tareas propias del procesamiento de imagen
		//Seria la redifinicion del metodo de la clase abstracta
	}
}
