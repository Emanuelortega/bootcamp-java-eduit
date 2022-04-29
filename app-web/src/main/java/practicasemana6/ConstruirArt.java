package practicasemana6;

import java.util.Scanner;

import clase10.Libro;
import clase7.Articulo;

public class ConstruirArt {
	
	//tambien se podria agregar validaciones y excepciones en este metodo en caso de ingrasar 
	//datos invalidos.
	//a modo de prueba de las demas Excepciones, lo dejo tal cual.
	
	public static Articulo ContruirArticulo(Scanner teclado, Scanner numeros) {
		
		Articulo art = new Libro();
		
		System.out.println("Ingrese titulo ");
		art.setNombre(teclado.next());
		
		System.out.println("Ingrese id ");
		art.setId(numeros.nextLong());
		
		//downcating
		System.out.println("Ingrese isbn");
		((Libro)art).setIsbn(teclado.next());
		
		System.out.println("Ingrese Autor");
		art.setAutor(teclado.next());
		
		System.out.println("Ingrese precio");
		art.setPrecio(numeros.nextDouble());
		
		System.out.println("Ingrese Url imagen");
		art.setUrlImagen(teclado.next());
		
		return art;
	}
	
	
	
	
	
	
}
