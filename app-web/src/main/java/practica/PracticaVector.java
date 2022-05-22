package practica;

import java.util.Scanner;

public class PracticaVector
{

	public static void main(String[] args) 
	{

		int valor;
		Scanner teclado = new Scanner(System.in);
		Scanner palabra = new Scanner(System.in);
		System.out.println("digite cantidad");
		
		valor = teclado.nextInt();	
		
		String [] nombres = new String[valor];
		
		for(int i = 0; i < valor; i++) {
			
			System.out.println("digite nombre");
			
			nombres[i] = palabra.nextLine();
		
		}
		palabra.close();
		teclado.close();
		
	}

}
