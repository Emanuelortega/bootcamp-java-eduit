package ar.com.educacionit.services.parse;

import ar.com.educacionit.services.exceptions.ParseException;

public interface IParser<T> {

	
	public T parse() throws ParseException;
}
