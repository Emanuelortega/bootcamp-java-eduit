package practica;

import java.util.Scanner;

public class CreoObjeto
{

	public static void main(String[] args) 
	{
		Scanner numero = new Scanner(System.in);
		Scanner letras = new Scanner(System.in);
		
		int cantalumnos;
		do {
			System.out.println("Digite la cantidad de alumnos para empezar o  cero para salir");
			cantalumnos = numero.nextInt();
			if(cantalumnos == 0) {
				System.out.println("Saliendo...");
				System.exit(1);
			}
			
		}while(cantalumnos < 0);
		
		Alumno Alumnos[]= new Alumno[cantalumnos];
		
		
		for(int d=0 ; d<cantalumnos; d++) {
			Alumnos[d]= new Alumno();
			Alumnos[d].CargarNombre(letras,d);
			Alumnos[d].CargarApellido(letras,d);
			Alumnos[d].CargarCantNotas(numero,d);			
			Alumnos[d].CargarNotas(numero);
			System.out.println("--------------");
			Alumnos[d].BuscarNotaBaja();
			Alumnos[d].BuscarNotaAlta();
			Alumnos[d].BuscarPromedio();
			
		}
		
		
		for(int d=0 ; d<cantalumnos; d++) {
			
			Alumnos[d].MostrarDatos();
			System.out.println("--------------");
		}
		
		double Sumatotal=0;
		double Sumacantidad=0;
		
		for(int a=0; a< cantalumnos; a++) {
		Sumatotal=Sumatotal+Alumnos[a].Sumarnotas();
		Sumacantidad=Sumacantidad + Alumnos[a].SumarCantidadNotas();
		}
		System.out.println("Promedio General de la Clase: "+(Sumatotal/Sumacantidad));
		
		
		numero.close();
		letras.close();

		
		
	}

}
