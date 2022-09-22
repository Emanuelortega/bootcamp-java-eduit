package clase4;

import java.util.Scanner;

public class CalcIfElseMain
{

	public static void main(String[] args)
	{ 
		//realizar una mini calculadora
		
		int opcion;
		double res;
		double a;
		double b;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("ingrese operacion");
		System.out.println("0=salir, 1=suma, 2=resta, 3=multi, 4=div");
		opcion = teclado.nextInt();
		
		if(opcion == 1) 
		{
			System.out.println("ingrese a");
			a = teclado.nextDouble();
			
			System.out.println("ingrese b");
			b = teclado.nextDouble();
			
			res = a + b;
			
			mostrarResultado(res,"+");
			
		}else if (opcion == 2) 
		{
			System.out.println("ingrese a");
			a = teclado.nextDouble();
			
			System.out.println("ingrese b");
			b = teclado.nextDouble();
			
			res = a - b;
			
			mostrarResultado(res,"-");
			
		}else if (opcion == 3) 
		{
			System.out.println("ingrese a");
			a = teclado.nextDouble();
			
			System.out.println("ingrese b");
			b = teclado.nextDouble();
			
			res = a * b;
			
			mostrarResultado(res,"*");
			
		}else if (opcion == 4) 
		{
			System.out.println("ingrese a");
			a = teclado.nextDouble();
			
			System.out.println("ingrese b");
			b = teclado.nextDouble();
			
			if( b != 0) {
			res = a / b;
			mostrarResultado(res,"/");
			}else {
				System.out.println("no se puede dividir por cero");
			}
			
		}else{
			if(opcion == 0) {
				System.exit(1);
			}
			
		}
		
	teclado.close();	
	System.out.println("salida exitosa");
	
	}

	static void mostrarResultado(double res, String operacion) 
	{
		System.out.println("la operacion" + operacion + "=" + res);
	}
	
}
