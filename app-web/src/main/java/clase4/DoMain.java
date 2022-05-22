package clase4;

import java.util.Scanner;

public class DoMain 
{

	public static void main(String[] args) 
	{
		//leer un dato hasta que el usuario ingrese 0
		//la variable debe estar fuera del ciclo
		
		Scanner teclado = new Scanner(System.in);
		int continuar;
		
		do {
		int opcion;
		do {
			mostrarMenu();
			opcion = teclado.nextInt();
			
		}while(opcion < 0 || opcion > 4 );
		System.out.println("desea continuar (1=si, 2=no)");
		continuar = teclado.nextInt();
		
		}while(continuar == 1);
		teclado.close();
		System.out.println("Fin");
		
	}

	private static void mostrarMenu() {
		System.out.println("ingrese opcion (0 para salir 1= suma, 2= resta, 3= multi, 4= div)");
	}

}
