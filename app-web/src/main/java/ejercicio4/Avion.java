package ejercicio4;

public class Avion extends Objetovolador implements Aterrizar
{
	
	private int CantAsientos;

	public Avion(String nombre,int asientos) {
		super(nombre);// nace primero el padre
		
		this.CantAsientos=asientos;
		
	}

	
	public int getCantAsientos() {
		return CantAsientos;
	}
	
	public void setCantAsientos(int cantAsientos) {
		CantAsientos = cantAsientos;
	}

	
	
	@Override
	public void aterrizando() {
		System.out.println(this.nombre + " aterrizando...");
	}


	@Override
	public void Detalles() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Cantidad de asientos: "+ this.CantAsientos);

	}
	
	
	
	
	
	
	
	
}
