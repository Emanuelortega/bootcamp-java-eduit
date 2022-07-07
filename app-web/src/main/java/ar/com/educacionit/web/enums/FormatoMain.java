package ar.com.educacionit.web.enums;

public class FormatoMain {

	public static void main(String[] args) {

		String formato = "pdf";
		
		FormatoEnum _enum = FormatoEnum.getByValue(formato);
		
		IFormato action = ActionBuilder.getAction(_enum);
		
		action.doAction();
		
	}

}
//1:10