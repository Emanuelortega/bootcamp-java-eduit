package practicavector;

public class Objetovolador {

	String nombre;
	Integer cantruedas;
	Archivo archivo;
	
	public Objetovolador() {
		
		this.nombre = "";
		this.cantruedas =0;
		this.archivo= new Archivo("doc", 3);	
	}
		
		
	public void Cargarpartes() {
		
		Partes[] info= new Partes[1];
		
		info[0]= new Partes("delanteros", 4);
		info[1]= new Partes("trasero", 3);
		
	}
	
	public void cargararchivo() {
		
		Archivo archivo1= new Archivo("java",5);
		Archivo archivo2= new Archivo("excel", 100);
		
		this.archivo = archivo1;
	} 
	
	
	public Archivo devolverarchivo() {
		
		Archivo archivo5 = new Archivo("pruba", 25);
		
		
		
		return archivo5;
	}
	
	
	
	
	/*public Archivo cargararchivo() {
		Archivo dato;
		
		
		
		return dato;
	*/
	
	
}
