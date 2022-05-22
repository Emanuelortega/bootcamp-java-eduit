package practica.semanal.semana2;

import java.util.Scanner;

public class ValidacionFechaaArreglo
{
	public static void main(String[] args) 
	{
		Scanner fecha = new Scanner(System.in);
		int dd;
		int mm;
		int yyyy;
		int[] meses = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		//Valido año
		
		yyyy = ValidacionAnio(fecha);
		
		//determino si el año es biciesto:
		
		DeterminarBiciesto(yyyy, meses);
		
		//Valido mes
		
		mm = ValidacionMes(fecha);

		
		
		// Valido el dia

		dd = ValidacionDia(fecha, mm ,meses);
		
		//Muestro los datos cargados
		
		MostrarDatos(yyyy, mm, dd);
		
		fecha.close();
		
	}
	

	static int ValidacionAnio(Scanner fecha ) {
		int anio;
		do {
			System.out.println("Digite el año: ");
			anio = fecha.nextInt();
			
			if(anio < 1900 || anio > 2099) {
				System.out.println("Dato incorrecto. Su rango es de: 1900-2099");
			}
			}while(anio < 1900 || anio > 2099); 
		
		return anio;
	}
		
		
	
	static int ValidacionMes(Scanner fecha) {
			int mes;
		do {
			System.out.println("Digite el mes: ");
			mes = fecha.nextInt();
			
			if(mes < 1 || mes > 12) {
				System.out.println("Dato incorrecto. Su rango es de: 1 - 12" );
			}
			}while(mes < 1 || mes > 12);  
		
		return mes;
	}	
	
	
	static void DeterminarBiciesto(int yyyy, int[] meses ) {
		
		if(((yyyy % 4 == 0) && (yyyy % 100 !=0)) || (yyyy % 400 == 0)) {
			meses[1] = 29;
			}
	}
	
	
	static int ValidacionDia(Scanner fecha, int mm, int[] meses) {
		int dia;
		do {
			System.out.println("Digite el dia: ");
			dia = fecha.nextInt();
			
			if(dia < 1 || dia > meses[mm-1]) {
				System.out.println("Dato incorrecto. Su rango es de: 1 - " + meses[mm-1]);
			}
			}while(dia < 1 || dia > meses[mm-1]);
		
		return dia;
	}
	
	
	static void MostrarDatos(int yyyy, int mm , int dd) {
		
		System.out.println("Datos cargados exitosamente");
		System.out.println("Dia = " + dd);
		System.out.println("Mes = " + mm);
		System.out.println("Año = " + yyyy);
	}
	
	
}
