package ejercicioidiomas;

public class Persona {
	
	private String nombre;
	private IIdioma idiomaNativo;
	private IIdioma [] MasIdiomas;
	
	
	public Persona(String nombre, IIdioma idiomaNativo) {
		this.nombre = nombre;
		this.idiomaNativo = idiomaNativo;
	}
	
	
	public void AprenderIdioma(IIdioma nuevoidioma) {
		
		
		
	}
	
	
	public void decir (String algo) {
		if(algo != null) {
		idiomaNativo.decir(algo);
		}
		
	}
	
	public void decir (String algo, IIdioma idioma ) {
		
		
	}
	

}
