package practica2;

public class Sega extends consola{

	Integer joys;
	public Sega(String nombre, Integer a�o, String empresa, Integer joys) {
		super(nombre, a�o, empresa);
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
