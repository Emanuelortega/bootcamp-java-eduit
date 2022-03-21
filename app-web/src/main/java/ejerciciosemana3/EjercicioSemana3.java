package ejerciciosemana3;

import java.util.Scanner;

public class EjercicioSemana3 
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		Scanner nomb = new Scanner(System.in);
		int cantAlum;
		double [] nota;
		
		
		cantAlum = CantidadAlumnos(teclado);
		
		String [] nombres = new String[cantAlum];
		String []apellido = new String [cantAlum];
		//int [] //
		
		
	/*	do {
			int a;
			System.out.println("digite nombre:");
			nombres[a] = nomb.nextLine();
			
			apellido[a] = nomb.nextLine();
			
			do {
			NumExamen[a] = teclado.nextInt();	
	
			}while(NumExamen[a] < 0 );
			
			a++;
			
			
	 	}while(cantAlum< a);
			
			
			
		}
		
		
		teclado.close();
		nomb.close();
		
		*/

	}

	
	
	
	/////////////////////
	static int CantidadAlumnos( Scanner teclado) {
		int cantidad;
		do {
			System.out.println("Digite cant de alumnos o  cero para salir");
			cantidad = teclado.nextInt();
			if(cantidad == 0) {
				System.out.println("Saliendo...");
				System.exit(1);
			}
			
		}while(cantidad < 0);
		return cantidad;
	} 
	
	
	
	
	
	
	
	
	
}
