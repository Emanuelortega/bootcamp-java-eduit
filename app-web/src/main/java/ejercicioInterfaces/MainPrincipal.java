package ejercicioInterfaces;

public class MainPrincipal {

	public static void main(String[] args) {

		
		String flag = "1";
		
		Iservicio servis = InstanciarServicio.instanciar(flag);
		
		Dato dta=servis.consultar();
		
		dta.detalles();
		
	}

}
