package practica2;

public class play extends consola implements juego {

	String lectura;
	
	
	public play(String nombre, Integer año, String empresa, String lectura) {
		super(nombre, año, empresa);
		this.lectura=lectura;
	}



	@Override
	public void datos() {
		System.out.println("datos de play");
		System.out.println(nombre);
		System.out.println(anio);
		System.out.println(empresa);
		System.out.println(lectura);
		
	}



	@Override
	public void regalo() {
		System.out.println(" ganaste 100pe");		
	}
	
	
}
