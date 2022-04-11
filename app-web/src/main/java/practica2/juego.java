package practica2;

public interface juego {
	
	public void regalo();
	
	default void perder() {
		
		System.out.println("no ganaste nada");
	}
	
	
	

}
