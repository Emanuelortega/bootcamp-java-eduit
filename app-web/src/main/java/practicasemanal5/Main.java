package practicasemanal5;

public class Main {

	public static void main(String[] args) {

		String[] cadena = new String[0];
		Integer[] enteros = new Integer[0];
		Float[] flotante = new Float[0];
		Character[] caracter = new Character[0];
		/*
		 * Se puede crear los vectores del tipo necesario e instanciarlo con tamaño [0]
		 * Solo cree estos 4 a modo de prueba.
		 */

		CollectionCuston<String> coleccion = new CollectionCuston<>(cadena);//
		/*
		 * "cadena" seria el vector del tipo establecido en: CollectionCuston<"String">;
		 * Cambiar el vector al tipo necesario. Agregue el metodo :Contains(indica si el
		 * valor ingresado existe en la coleccion) y el medoto MostrarColeccion(muestra
		 * los datos de la collecion).
		 */

		
		
		coleccion.AddFirst("dato");
		coleccion.AddFirst("pelota");
		coleccion.AddLast("perro");
		coleccion.AddFirst("primero");

		coleccion.AddLast("pelota");

		coleccion.AddFirst("devuelta");

		
		coleccion.Remove("pelota");
		coleccion.Remove("pelota");
		System.out.println(coleccion.Remove("pelota"));
		coleccion.MostrarColeccion();
		
		
		
		
		/*
		 * System.out.println(coleccion.Empy());
		 * System.out.println(coleccion.Contains("pelota"));
		 * 
		 * coleccion.RemoveAll(); System.out.println(coleccion.Empy());
		 * coleccion.MostrarColeccion();
		 */

	}
}
