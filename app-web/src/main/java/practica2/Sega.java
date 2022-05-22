package practica2;

public class Sega extends consola{

	Integer joys;
	public Sega(String nombre, Integer año, String empresa, Integer joys) {
		super(nombre, año, empresa);
		this.joys = joys;
	}
	
	
	

	@Override
	public void datos() {
		
		System.out.println("datos de sega");
		System.out.println(nombre);
		System.out.println(anio);
		System.out.println(empresa);
		System.out.println(joys);
		
		
	}



}
