package ar.com.educacionit.web.enums;

public class CSVAction implements IFormato {

	@Override
	public void doAction() {
		System.out.println("convirtiendo a " + getClass().getCanonicalName());
	}

}
