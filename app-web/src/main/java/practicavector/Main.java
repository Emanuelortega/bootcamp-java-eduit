package practicavector;


public class Main {

	public static void main(String[] args) {

		
	
		Objetovolador avion = new Objetovolador();
		
		
		avion.nombre="avion1";
		avion.cantruedas=0;
		
		System.out.println(avion.archivo.canthojas);
		System.out.println(avion.archivo.nombredato);
		
		avion.cargararchivo();
		
		System.out.println(avion.archivo.canthojas);
		System.out.println(avion.archivo.nombredato);
		
		Archivo archivo3 = new Archivo("python", 3);
		
		System.out.println(archivo3.nombredato);
		System.out.println(archivo3.canthojas);
		
		Archivo archivoprueba = avion.devolverarchivo();
		System.out.println(archivoprueba.canthojas);
		System.out.println(archivoprueba.nombredato);
		
		
		
		
		
	}

}
