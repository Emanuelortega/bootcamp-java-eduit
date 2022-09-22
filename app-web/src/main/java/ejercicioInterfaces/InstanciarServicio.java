package ejercicioInterfaces;

public class InstanciarServicio {

	
	public final static  Iservicio instanciar(String fl) {
		
		
		Iservicio servicio;
		
		switch (fl) {
		case "1":
			servicio = new Servicio1();
			break;

		case "2":
			servicio = new Servicio2();
			break;
			
		default:
			servicio = new ServicioDefault();
			break;
		}
		
		
		
		
		return servicio;
	} 
	
	
	
	
	
}
