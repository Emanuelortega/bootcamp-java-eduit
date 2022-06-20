package ar.com.educacionit.service.parser;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import ar.com.educacionit.services.exceptions.ParseException;
import ar.com.educacionit.services.parse.CSVFileParser;
import ar.com.educacionit.services.parse.Producto;
import ar.com.educacionit.services.parse.XLSXFileParser;

public class CSVFileParserTestCase {

	@Test
	public void when_nullfilename_then_throw_exception() {
		assertThrows(IllegalArgumentException.class,() ->{
			new CSVFileParser(null);
		});
	}
	
	@Test
	public void when_blankfilename_then_throw_exception() {
		assertThrows(IllegalArgumentException.class,() ->{
			new CSVFileParser("");
		});
	}
	
	@Test
	public void when_file_doesnot_exists_then() {
		assertThrows(ParseException.class,()->{
			new CSVFileParser("c:/bla/bla").parse();
		});
	}
	
	@Test
	public void when_create_doesexist() {
		assertNotNull(new CSVFileParser("c:/bla/bla"));
	}
	
	@Test
	public void when_fileexists_then_verify_size() throws ParseException {
		CSVFileParser parser = new CSVFileParser("C:\\desarrollo\\educationit\\clase39\\archivo.xlsx");
		Collection<Producto> list = parser.parse();
		assertEquals(2,list.size());
	}
	
	@Test
	public void when_xlsx_fileexists_then_verify_size() throws ParseException {
		XLSXFileParser parser = new XLSXFileParser("C:\\desarrollo\\educationit\\clase39");
		Collection<Producto> list = parser.parse();
		assertEquals(2,list.size());
	}
}
