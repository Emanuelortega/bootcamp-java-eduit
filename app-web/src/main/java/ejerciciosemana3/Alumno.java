package ejerciciosemana3;

import java.util.Scanner;

public class Alumno

{
	Integer cantAlum;
	Integer Cantexamenes;
	Double [] nota;
	String [] nombres;
	String []apellido;
	
	
	public Alumno() {
		
		cantAlum = 0;
		nombres = new String[cantAlum];
		
	}
	
	
	Scanner teclado = new Scanner(System.in);
	Scanner letras = new Scanner(System.in);
	
	public void CantidadAlumnos() {
		int valor;
			do {
				System.out.println("Digite cant de alumnos o  cero para salir");
				valor = teclado.nextInt();
				if(valor == 0) {
					System.out.println("Saliendo...");
					System.exit(1);
				}
				
			}while(cantAlum < 0);
			
			cantAlum = valor;
	}
	
		
	
	
		void Cargardatos() {
			
		String [] nom = new String[3];
		
			//for(int a = 0; a < cantAlum ; a ++) {
			do {	
				int a = 0;
			System.out.println("digite nombre:");
			
			nom[a] = letras.nextLine();
			
			nombres[a] = nom[a];
			a++;
			
			}while(nombres.length < cantAlum);
		//}
			
			letras.close();
			teclado.close();
	}
	

}
