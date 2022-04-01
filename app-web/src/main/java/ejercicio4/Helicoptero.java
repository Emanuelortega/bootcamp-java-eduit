package ejercicio4;

public class Helicoptero extends Objetovolador implements Aterrizar{

	private String marca;
	
	
	public Helicoptero(String nombre,String marca) {
		super(nombre);
		this.marca= marca;
		
	}


	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	
public void Detalles(){
		
		System.out.println("Nombre: "+ this.nombre);
		System.out.println("Marca: "+ this.marca );
		
	}	

	@Override
	public void aterrizando() {
		System.out.println(this.nombre + " aterrizando...");		
	}

}
