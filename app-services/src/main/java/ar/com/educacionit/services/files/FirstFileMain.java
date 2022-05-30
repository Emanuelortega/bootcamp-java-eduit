package ar.com.educacionit.services.files;

import java.io.File;
import java.io.IOException;

public class FirstFileMain {

	public static void main(String[] args) throws IOException {

		//crear un objeto de la clase File
		
		File archivo = new File("c:/desarrollo/text.txt");
		boolean exist = archivo.exists();
		
		System.out.println(exist);
		
		if(!exist) {
			
			archivo.createNewFile();
			
		}
		
		exist = archivo.exists();
		System.out.println(exist);
		
		
	}

}
