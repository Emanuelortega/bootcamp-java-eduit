package practica2;

public abstract class consola {

	protected String nombre;
	protected Integer anio;
	protected String empresa;
	
	public consola(String nombre, Integer anio, String empresa) {
		super();
		this.nombre = nombre;
		this.anio = anio;
		this.empresa = empresa;
	}


	public abstract void datos();
	
	
	
}
