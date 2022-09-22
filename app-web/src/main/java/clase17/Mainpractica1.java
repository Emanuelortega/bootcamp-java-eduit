package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Mainpractica1 {

	public static void main(String[] args) {

		// practica collecion

		Collection<String> coleccion = new ArrayList<>();

		coleccion.add("casa");
		coleccion.add("ultimo");
		coleccion.add("casa");
		coleccion.add("perro");
		/*
		 * System.out.println(coleccion.hashCode()); // devuelve int = codigo de la
		 * collecion
		 * 
		 * 
		 * for (String V : coleccion) { System.out.println(V); }
		 * 
		 * Iterator<String> itcoleccion = coleccion.iterator(); List<String> nuevos =
		 * new ArrayList<>(); while(itcoleccion.hasNext()) {
		 * 
		 * String eliminados= itcoleccion.next(); System.out.println("eliminando: "+
		 * eliminados ); nuevos.add(eliminados); itcoleccion.remove();
		 * 
		 * }
		 * 
		 * itcoleccion = nuevos.iterator();
		 * 
		 * while(itcoleccion.hasNext()) {
		 * 
		 * System.out.println(itcoleccion.next());
		 * 
		 * }
		 */
		Collection<String> coleccion1 = new HashSet<>();

		coleccion1.add("primero");
		coleccion1.add("segundo");
		coleccion1.add("tercero");
		coleccion1.add("cuarto");

		// coleccion= new HashSet<>(coleccion);

		Collection<String> coleccion3 = new HashSet<>();

		coleccion3.addAll(coleccion);
		coleccion3.addAll(coleccion1);

		System.out.println(coleccion3);

		List<String> personas = new ArrayList<>();

		personas.add("casa");
		personas.add("agregado");
		
		System.out.println(coleccion3.containsAll(personas));
		

	}

}
