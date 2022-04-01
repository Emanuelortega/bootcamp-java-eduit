package ejercicio4;

public class Ovni extends Objetovolador {
	private int Cantdedos;

	public Ovni(String nombre,int cantidad) {
		super(nombre);
		this.Cantdedos=cantidad;
	}

	@Override
	public void Detalles() {
		System.out.println("Nombre: "+ this.nombre);
		System.out.println("Cantidad de dedos: "+ this.Cantdedos);
	}

	
	
	
	
	
	
	
}
