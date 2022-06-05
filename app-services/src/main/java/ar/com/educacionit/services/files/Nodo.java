package ar.com.educacionit.services.files;

public class Nodo {

	private String letra;
	private Nodo izq;
	private Nodo der;
	
	
	public Nodo(String letra, Nodo izq, Nodo der) {
		this.letra = letra;
		this.izq = izq;
		this.der = der;
	}


	public String getLetra() {
		return letra;
	}


	public void setLetra(String letra) {
		this.letra = letra;
	}


	public Nodo getIzq() {
		return izq;
	}


	public void setIzq(Nodo izq) {
		this.izq = izq;
	}


	public Nodo getDer() {
		return der;
	}


	public void setDer(Nodo der) {
		this.der = der;
	}


	@Override
	public String toString() {
		return "Nodo [letra=" + letra + ", izq=" + izq + ", der=" + der + "]";
	}
	
	
	
	
	
	
	
}
