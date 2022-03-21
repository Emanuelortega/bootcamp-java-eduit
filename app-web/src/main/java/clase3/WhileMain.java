package clase3;

import java.util.Scanner;

public class WhileMain 
{

	public static void main(String[] args)
	{
		int cont = 0; // f6 para pasar a otra linea
		int numero; // la jvm no para en las
		// definiciones de variables
		
		
		//decir a java que voy a leer desde el teclado
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("ingrese dato");
		
		numero = teclado.nextInt(); //lee desde teclado
		
		while (numero != 0 && cont < 6) {
			cont++;//f6
			//ciclo infinito
			System.out.println("ingrese dato");
			//vuelvo a leer el valor
			numero = teclado.nextInt();
		}
		
		System.out.println("fin");

		teclado.close();
	}
}
