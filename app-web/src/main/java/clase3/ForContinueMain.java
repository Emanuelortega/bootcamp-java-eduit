package clase3;

import java.util.Scanner;

public class ForContinueMain
{

	public static void main(String[] args) 
	{
		int sumapares = 0;
		int sumaimpares = 0;
		int cantidaddelectura = 4;
		int numero;

		Scanner teclado = new Scanner(System.in);
		
		//ciclo for
		for(int i=0; i < cantidaddelectura; i++) {
			//leer dato del teclado
			System.out.println("ingrese valor");
			numero = teclado.nextInt();
			
			if(numero==0) {
				continue;
			} //alt + flecha arriba o abajo para mover lineas de codigo seleccionadas
			
			
			//pregunto si es par
			if(numero % 2 ==0) { //alt+shift para verificar el valor de verdad
				sumapares += numero;
			}else {
				//no es par
				sumaimpares += numero;
			}
		}
		teclado.close();
		//saber si pares >impares || pares < impares || pares == impares
		
		if(sumapares<sumaimpares) {
			System.out.println("Hay mas impares...");
		}
		
		if(sumapares>sumaimpares) {
			System.out.println("Hay mas pares...");
		}
		
		if(sumapares==sumaimpares) {
			System.out.println("Hay igual cantidad de pares que de impares");
		}
		
		System.out.println("suma pares = " + sumapares);
		System.out.println("suma impares = " + sumaimpares);
		
	}

}
