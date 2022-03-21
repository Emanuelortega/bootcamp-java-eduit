package clase3;

import java.util.Scanner;

public class WhileConIfMain 
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
		
		while (numero != 0) 
		{
			if (cont < 6) 
			{
				//verdadero
				cont++;//f6
				//ciclo infinito
				System.out.println("ingrese dato");
				//vuelvo a leer el valor
				numero = teclado.nextInt();
				
			}else {
				//falso
				break; //permite salir de un ciclo
				
					}
			
		}
		
		System.out.println("fin");
		

	}

}
