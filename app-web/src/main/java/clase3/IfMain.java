package clase3;

public class IfMain
{

	public static void main(String[] args) 
	{
		int edad = 17;
		
		// Y &&
		
		//operador relacional
		// < > <= >= !=
		
		if (edad >=18) 
		{
			if(edad >= 20 && edad <= 30)
			{
				System.out.println("es mayor y esta entre los 20 y 30 años");
				
			} else 
				{System.out.println(" es mayor pero no esta entre los 20 y 30 años");
				}
			
		} else 
				{
				System.out.println("es menor de edad");	
				}
		
	}

}
