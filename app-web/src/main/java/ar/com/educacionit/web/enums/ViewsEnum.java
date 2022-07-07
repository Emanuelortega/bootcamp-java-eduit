package ar.com.educacionit.web.enums;

public enum ViewsEnum {

	//Nombres //valores posibles
	LISTADO("list"),//0
	LOGIN("login"),//1
	ALTA("alta"),//2
	REGISTRO_OK("/registroOk.jsp"), //ctrl +shif+ y > min
	REGISTRO_FAIL("/registroFail.jsp"),// ctrl +shif+ x > mayus
	;
	//ERROR_DEFAULT("error.jsp")
	
	
	private String value;
	
	//constructor
	private ViewsEnum(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
