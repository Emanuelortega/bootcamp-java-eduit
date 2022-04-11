package ejercicioInterfaces;

public class Dato {
	
	String nombre;
	Integer edad;
	
	
	public Dato(String nombre, Integer edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
	public void detalles() {
		
		System.out.println("nombre: "+ nombre);
		System.out.println("edad: "+ edad);
	}


	
	
	
	
	
	
}
