package ejercicio4;

public class Superman extends Objetovolador 

{
	private int Cantcapas;

	public Superman(String nombre, int cantidad) {
		super(nombre);
		this.Cantcapas= cantidad;
	}

	public int getCantcapas() {
		return Cantcapas;
	}

	public void setCantcapas(int cantcapas) {
		Cantcapas = cantcapas;
	}

	@Override
	public void Detalles() {
System.out.println("Nombre: "+ this.nombre);	
System.out.println("Cantidad de capas: "+ this.Cantcapas);	
	}

	
	
}
