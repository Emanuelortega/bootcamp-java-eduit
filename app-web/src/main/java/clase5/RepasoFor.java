package clase5;

public class RepasoFor 
{

	public static void main(String[] args) 
	{
		//ciclo for
		//mostrar los primeros 10 numeros naturales 
		//sin mostrar los pares
		
		int cantidad = 10;
		
		for(int i=0 ; i < cantidad ; i++) {
			if(i % 2 != 0) {
				System.out.println(i);
			}
		}

	}

}
