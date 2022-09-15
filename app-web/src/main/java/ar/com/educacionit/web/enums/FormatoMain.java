package ar.com.educacionit.web.enums;

public class FormatoMain {

	public static void main(String[] args) {

		String formato = "pdf";
		
		FormatoEnum _enum = FormatoEnum.getByValue(formato);
		
		IExportable action = ActionBuilder.getAction(_enum);
		
		action.exportar(null);
		
	}

}
//1:10