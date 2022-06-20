package ar.com.educacionit.services.parse;

import java.io.File;

import ar.com.educacionit.services.exceptions.ParseException;

public abstract class BaseFile {

	protected String filePath;
	//path
	public BaseFile(String filePath) {
		if(filePath == null || "".equals(filePath)) {
			//lanzo una RuntimeException
			throw new IllegalArgumentException("Debe indicar el path del archivo");
		}
		this.filePath = filePath;
	}
	
	protected File getFile() throws ParseException {
		File file = new File(this.getFilePath());
		if(!file.exists()) {
			throw new ParseException("No existe el archivo : " + file.getAbsolutePath());
		}
		return file;
	}
	
	private String getFilePath() {
		//aca puedo agregar logica sobre el path
			return filePath;
		}
	
}
