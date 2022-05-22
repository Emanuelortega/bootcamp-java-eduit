package ejercicioInterfaces;

public class ServicioDefault implements Iservicio {

	@Override
	public Dato consultar() {
		return new Dato(null,null);
	}

}
