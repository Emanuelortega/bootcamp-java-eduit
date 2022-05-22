package practica2;

public class Family extends consola implements juego {
	
	Integer cables;

	public Family(String nombre, Integer año, String empresa, Integer cables) {
		super(nombre, año, empresa);
		this.cables = cables;
	}
	
	

	@Override
	public void datos() {
		
		System.out.println("datos de family");
		System.out.println(nombre);
		System.out.println(anio);
		System.out.println(empresa);
		System.out.println(cables);
	}



	@Override
	public void regalo() {
		System.out.println("ganaste un juego");
	}

}
