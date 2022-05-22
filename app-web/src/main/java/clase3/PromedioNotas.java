package clase3;

import java.util.Scanner;

public class PromedioNotas 

{
	public static void main(String[] args) 
	{
		/**
		 * Calcular el promedio de notas de un alumno.
		 * Se debe ingresar las tres notas del año.
		 * Si el promedio es igual o o mayor (>=) 7 informar por consola que está aprobado.
		 * Si el promedio es menor a 7 informar por consola que no está aprobado.
		 */

		//necesito 3 variables de que tipo?
		//3 float, uno para cada nota y 1 float para el promedio
		
		float primernota;
		float segundanota;
		float tercernota;
		
		//leer notas del teclado
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("ingrese la primer nota");
		primernota = teclado.nextFloat();
		
		System.out.println("ingrese la segunda nota");
		segundanota = teclado.nextFloat();
		
		System.out.println("ingrese la tercer nota");
		tercernota = teclado.nextFloat();
		
		//aca puedo cerrar el teclado
		//cierro conexion con el teclado
		teclado.close();
		
		//calculo el promedio de notas
		float promedio = (primernota + segundanota + tercernota) / 3;	
		
		if (promedio >= 7) {
			System.out.println("uds esta aprobado: " + promedio);
		}else {
			System.out.println("uds esta desaprobado: " + promedio);
		}
		
	}


}
