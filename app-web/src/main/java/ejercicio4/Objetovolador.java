package ejercicio4;

public abstract class Objetovolador {
	
	
	protected String nombre;
	


	public Objetovolador(String nombre) {
		
		this.nombre = nombre;
	}

	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public abstract void Detalles();
	

}

