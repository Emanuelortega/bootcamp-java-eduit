package practica2;

public class Main {

	public static void main(String[] args) {

		consola playstation = new play("play",1980,"playstation","cd");
		consola sega3 = new Sega("sega",1985,"genesis",2);
		consola famy = new Family("family",1990,"station",10);
		
		
		
		playstation.datos();
		sega3.datos();
		famy.datos();
		
		
	
			
			((juego) famy).regalo();
			((juego) sega3).regalo();
			((juego) playstation).regalo();
		
		
	}

}
