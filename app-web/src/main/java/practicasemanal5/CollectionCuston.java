package practicasemanal5;
import java.util.Arrays;

public class CollectionCuston<T>{

	private  T[] general;
	
	public CollectionCuston(T[] general) {
		this.general = general;
	}
	
	public int Size() {
		int tamanio;
		tamanio= general.length;
		return tamanio;
		
	}
		
	public void AddLast(T valor) {
		
		T [] gen = Arrays.copyOf(general, general.length+1);
		
		gen[gen.length-1]=valor;
		general=gen;
		
	}
	
	public void AddFirst(T valor) {
		
		T[] gen=Arrays.copyOf(general,general.length+1);
		
		for(int a=1; a<gen.length;a++) {
			gen[a]=general[a-1];
		}
		gen[0]=valor;
		
		general=gen;
		
	}
	
	public T Remove(T valor) {
		
	//remueve el elemento enviado"valor", se reduce el vector y mantiene el orden 
	//de no encontrarse "valor", se devuelve null; si hay muchos datos se sugiere usar antes el metodo "Contains"
	//para verificar si el "valor" a eliminar existe en la collecion.	
	T dato = null;
	int pos;
		
	for(int a=0; a< general.length;a++ ) { 
			
		if(valor.equals(general[a])) {
			dato=valor;
			pos=a;
			if(pos<general.length-1) {
				for(int b=pos;b<general.length;b++ ) {
					general[b]=general[b+1];
					if(b+1==general.length-1) {
						T[]gen=Arrays.copyOf(general, general.length-1);
						general=gen;
						break;
					}
				}
			}else {
				
				T[] gen2=Arrays.copyOf(general,general.length-1);
				general=gen2;
				
				} 
			}	
		}	
		
		return dato;
		
	}			
				
	public void RemoveAll() {
		
		T[]	gen = Arrays.copyOf(general, 0);
		this.general=gen;
		
	}
	
	
	public boolean Empy() {//Comprueba si la colleccion esta vacia
		
		boolean prueba;
		if(this.general.length>0) {
			prueba=false;
		}else {
			prueba=true;
		}
		return prueba;
	}
	
	public void MostrarColeccion() {
		
		for(T d: general) {
			System.out.println(d);
		}
	}
	
	public boolean Contains(T valor) {
		boolean dato=false;
		
		for(T D: general) {
			if(valor.equals(D)) {
				dato=true;
				break;
			}else {
				dato=false;
			}
		}
		return dato;
	}
	
	
	
}
