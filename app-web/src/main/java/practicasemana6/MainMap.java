package practicasemana6;

import java.util.Scanner;

import clase10.Libro;
import clase7.Articulo;

public class MainMap {

	/**
	 * El usuario ingresa una opcion 1- alta 2- baja 3- modificar 4- default
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Scanner numeros = new Scanner(System.in);

		Integer opc = 1;// alta= crear un articulo

		IAccion accion = AccionMap.getAccion(opc);// AltaAccion|BajaAccion|AccionDefault
		Articulo articulo2 = ConstruirArt.ContruirArticulo(teclado, numeros);
		

		try {
			InMemoryDB.listAll();   //Excepcion por que no se encuentran valores en la collecion
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			accion.exec(articulo2); //alta del articulo, se agrega a la coleccion
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			InMemoryDB.listAll();
		} catch (CollectionEmpy e) { // se muestra el valor agregado
			e.printStackTrace();
		}
		
		Articulo articulo3 = ConstruirArt.ContruirArticulo(teclado, numeros);
		IAccion accion2= AccionMap.getAccion(1);  
		/*	
			1- si se desea dar alta un articulo con un id ya existente en la coleccion, se lanza ExceptionIdExistente
			2- si se desea dar baja, debe existir ese id, de lo contrario se lanza ArticuloInexistente
			3- Si desea modificarlo, debe existir ese id en la coleccion, de lo contrario se lanza ExceptionIdInexistente
			(en los casos que se quiera mandar un articulo null se lanza Excepction).
			* al usar InMemoryDB.listAll() si la coleccion no tiene valores que mostrar,lanza CollectionEmpy
			* al usar InMemoryDB.getById() si el id no existe en la colleccion lanza ArticuloNull (Devuelve null)
			
		*/
		try {
			accion2.exec(articulo3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			InMemoryDB.listAll();
		} catch (CollectionEmpy e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("continuamos");
		
		
		teclado.close();
		numeros.close();
	}

}
