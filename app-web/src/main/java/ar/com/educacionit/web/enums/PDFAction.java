package ar.com.educacionit.web.enums;

public class PDFAction implements IFormato {

	@Override
	public void doAction() {
		System.out.println("convirtiendo a " + getClass().getCanonicalName());
	}

}
