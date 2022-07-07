package ar.com.educacionit.web.enums;

public class XLSXAction implements IFormato {

	@Override
	public void doAction() {
		System.out.println("convirtiendo a " + getClass().getCanonicalName());
	}

}
