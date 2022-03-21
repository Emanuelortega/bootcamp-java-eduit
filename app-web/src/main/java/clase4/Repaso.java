package clase4;

public class Repaso
{

	public static void main(String[] args) 
	{
		//invoco a la funcion
		
		float resultado = funcionXMas2(2);
		//guardo el dato de la funcion en "resultado"
		
	}

	static float funcionXMas2(float x) 
	{
		float y = x + 2;
		//retornar el valor
		return y;
	}
	
	static float dividir(float a, float b) 

	{
		float res;
		if( b != 0) 
		{
			res = a / b;
			
		}else {
			System.out.println("no se puede dividir por cero");
			res = -1;	
		} 
		
		return res;
		
	} 
	
	static void mostrarparidad(float numero) 
	{
		boolean espar = (numero % 2 == 0) ? true : false;
		System.out.println(espar ? "es par" : "impar");
	}	

	
	
}
