package clase4;

import java.util.Scanner;

public class SwithcMain
{

	public static void main(String[] args)
	{ 
		//realizar una mini calculadora
		
		int opcion;
		double res;
		double a;
		double b;
		int continuar;
		
		Scanner teclado = new Scanner(System.in);
		do {
			//alt+shit+m
	
		opcion = validaropciones(1,4,teclado,"ingrese operacion: \n 1=suma, 2=resta, 3=multi, 4=div");
			
		a = leerdata("ingrese a", teclado);
		b = leerdata("ingrese b", teclado);
		
		switch(opcion) 
		{
		case 1:
			res = a + b;
			mostrarResultado(res,"+");
			break;
			
		case 2:
			res = a - b;
			mostrarResultado(res,"-");
			break;	
			
		case 3:
			res = a * b;
			mostrarResultado(res,"*");
			break;
		case 4:
			if( b != 0) {
			res = a / b;
			mostrarResultado(res,"/");
			}else {
				System.out.println("no se puede dividir por cero");
			}
			break;
			default:
				System.out.println("opcion invalida");
				break;
				
		}
		//pregunto si quiere continuar
		
		continuar = validaropciones(0, 1, teclado, "continuar (1 =si, 0= no)");
		
		//sale con un cero o un 1
	}while(continuar == 1);
		
	teclado.close();	
	System.out.println("salida exitosa");
	
	}

	static int validaropciones(int i, int j, Scanner teclado, String msj) {
		int opcion;
		do {
			mostrarMenu(msj);
			opcion = teclado.nextInt();
			}while(opcion < i || opcion > j);
		return opcion;
	}

	static double leerdata(String msj, Scanner teclado)
	{
		System.out.println(msj);
		return teclado.nextDouble();
	}

	static void mostrarMenu(String msj) {
		System.out.println(msj);
	}

	static void mostrarResultado(double res, String operacion) 
	{
		System.out.println("la operacion" + operacion + "=" + res);
	}
	
}
