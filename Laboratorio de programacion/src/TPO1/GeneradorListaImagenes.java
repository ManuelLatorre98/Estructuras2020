package TPO1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class GeneradorListaImagenes {//Genera listas de imagenes que seran procesadas (divididas en subtareas con forkjoin)
	public List <Imagen> generar(int cant){
		Random generadorTam=new Random();
		List<Imagen> listaImagenes= new ArrayList<Imagen>();
		
		for (int i = 0; i < cant; i++) {
			Imagen imagen= new Imagen(("Imagen"+i),generadorTam.nextInt(50));
			listaImagenes.add(imagen);
		}
		
		return listaImagenes;
	}
}
