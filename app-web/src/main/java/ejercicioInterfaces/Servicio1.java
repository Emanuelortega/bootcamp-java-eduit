package ejercicioInterfaces;

public class Servicio1 implements Iservicio {

	@Override
	public Dato consultar() {
		
		String nom= "matias";
		Integer edd = 25;
		
		Dato data = new Dato(nom,edd);
		return data;
	}

}
