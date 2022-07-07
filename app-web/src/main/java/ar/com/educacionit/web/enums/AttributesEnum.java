package ar.com.educacionit.web.enums;

public enum AttributesEnum {

	ARTICULOS("articulos")
	;
	
	private String key;
	
	private AttributesEnum(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return this.key;
	}
}
