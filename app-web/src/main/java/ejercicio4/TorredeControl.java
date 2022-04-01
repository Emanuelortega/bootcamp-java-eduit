package ejercicio4;

public class TorredeControl  {

	public static void main(String[] args) {

		
		Objetovolador[] volador= new Objetovolador[4];
		
		volador[0]= new Avion("Avion", 20); 
		volador[1]= new Helicoptero("Helicoptero","AA"); 
		volador[2]= new Superman ("Superman", 1); 
		volador[3]= new Ovni("Ovni", 2); 
		
		
		System.out.println("Detalle de los objetos volando: ");
	for(int a =0 ; a<volador.length; a++)
		volador[a].Detalles();
	
	
	
	System.out.println("Objetos que cumplen con la interfaz de aterrizaje:");
	for(Objetovolador obj : volador) {
		
		if(obj instanceof Aterrizar) {
		
			Aterrizar aterrizaje = (Aterrizar)obj;
			aterrizaje.aterrizando();
		
		}
		
	}
		
		
	}

}
