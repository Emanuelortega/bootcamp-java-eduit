package ar.com.educacionit.services.files;

import java.io.File;
import java.io.IOException;

public class FirstFileMain2 {

	public static void main(String[] args) throws IOException {

		// crear un objeto de la clase File
		String fileName = "placa_bienvenidos.txt";
		File archivo = new File("c:/desarrollo/educationit/clase37");

		if (archivo.exists()) {
			File placa = buscarFile(archivo, fileName);
			if (placa != null) {
				System.out.println("Se ha encontado el archivo: " + fileName + "en la carpeta :" + placa.getPath());
			} else {
				System.out.println("No se ha encontado el archivo: " + fileName);
			}
		}

		/*
		 * buscar el archivo:placa_bienvenidos.pngdentro del directorio: c:/desarrollo y
		 * sus subcarpetas.
		 * 
		 * si no se encuentra mostrar que carpeta lo contiene, de lo contrario informar
		 * que no existe
		 * 
		 */

	}

	//tener en cuenta que si el primer File es una carpeta vacia, termina el programa(corregir)
	public static File buscarFile(File file, String fileName) {
		// caso base?
		if (file.isDirectory() /*&& file.list().length == 0*/) {
			System.out.println("carpeta: " + file.getName());
			File aux = null;
			File[] filesInFile = file.listFiles();

			for (int i = 0; i < filesInFile.length && aux == null; i++) {
				File aFile = filesInFile[i];
				aux = buscarFile(aFile, fileName);
			}
			return aux;
		} else {
			File aux = null;
			System.out.println("archivo: " + file.getName());
			if (file.getName().equalsIgnoreCase(fileName)) {
				aux = file;
			}
			return aux;
		}
	}

}
