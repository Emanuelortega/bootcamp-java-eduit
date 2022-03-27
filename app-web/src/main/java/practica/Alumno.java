package practica;

import java.util.Scanner;

public class Alumno
{

	String nombre;
	String apellido;
	Integer cantnotas;
	Double [] notas;
	Double Notbaja;
	Double Notalta;
	Double promedio;
	


public Alumno() {
	
	 nombre="";
	 apellido="";
	 cantnotas=0;
	 notas=new Double[0];
	 Notalta=0d;
	 Notbaja=0d;
	 promedio=0d;
	
	}

void CargarNombre(Scanner letras,int d) {
	System.out.println("Digite nombre del alumno "+ (d+1) +":" );
	nombre=letras.nextLine();
	
}

void CargarApellido(Scanner letras, int d) {
	
	System.out.println("Digite apellido del alumno "+ (d+1) +":" );
	apellido=letras.nextLine();
}

void CargarCantNotas(Scanner numero, int d) {
	
	System.out.println("Digite numero de examenes del alumno "+ (d+1) +":" );
	cantnotas=numero.nextInt();
}


void CargarNotas(Scanner teclado){
	
	if(cantnotas==0) {
		notas=new Double[1];
		notas[0]=0d;
	}else {
	
	notas=new Double[cantnotas];
	
	for(int a =0; a<cantnotas;a++) {
		
	do{
		System.out.println("Ingrese nota "+(a+1) + ":");
		notas[a]=teclado.nextDouble();
		if(notas[a]>10) {
			System.out.println("Su nota no puede ser mayor a 10");
		}
	}while(notas[a]>10);
		}
	
	}
	
}


void BuscarNotaBaja () {
	
	Notbaja=notas[0];
	for(int i = 1;i < notas.length;i++) {
		if(notas[i] < this.Notbaja) {
			this.Notbaja = notas[i];
		}
		
	} 
}

void BuscarNotaAlta () {
	
	Notalta=notas[0];
	for(int i = 1;i < notas.length;i++) {
		if(notas[i] > this.Notalta) {
			this.Notalta = notas[i];
		}
		
	} 
}

void BuscarPromedio() {
	
	double total=notas[0];
	for(int a =1; a<notas.length; a++) {
		total=total+notas[a];
	}
	promedio=total/notas.length;
	
	
}

void MostrarDatos() {
	
	System.out.println(nombre+" "+apellido);
	System.out.println("Nota mas alta: " + Notalta);
	System.out.println("Nota mas baja: " + Notbaja);
	if(promedio >= 7) {
		
		System.out.println("Promociona. Promedio: "+ promedio);
	}else {
		
		System.out.println("Recursa la materia. Promedio: "+ promedio);
	}


}
	
double  Sumarnotas() {
	
	double total=notas[0];
	for(int a =1; a<notas.length; a++) {
		total=total+notas[a];
	}
	
	return total;
	
}

double SumarCantidadNotas() {
	
	return cantnotas;
	
}


	
	
}
