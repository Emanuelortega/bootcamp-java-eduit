package ar.com.educacionit.services.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import ar.com.educacionit.services.exceptions.ParseException;

public class CSVFileParser extends BaseFile implements IParser<Collection<ArticuloDTO>> {

	// path
	public CSVFileParser(String filePath) {
		super(filePath);
	}

	public CSVFileParser(Part filePart) {
		super(filePart);
	}

	// TDD + DDD
	@Override
	public Collection<ArticuloDTO> parse() throws ParseException {

		InputStream is = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			
			if (this.filePart != null) {
				is = this.filePart.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
			} else {
				//url = filepaht
				File file = super.getFile();
				fr = new FileReader(file);
				br = new BufferedReader(fr);
			}
			return this.builArchivo(br);
		}catch (IOException ioe) {
			throw new ParseException(ioe.getMessage(),ioe);
		}finally {
			if(is != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new ParseException(e.getMessage(),e);
				}
			}
		}
		

	}

	private Collection<ArticuloDTO> builArchivo(BufferedReader br) throws IOException {

		String line = null;
		// leo la primer linea y ladescarto xq representa las columnas
		line = br.readLine();

		List<ArticuloDTO> list = new ArrayList<>();

		while ((line = br.readLine()) != null) {
			ArticuloDTO fileData = rowFromString(line);
			list.add(fileData);
		}

		br.close();
		return list;

	}

	private ArticuloDTO rowFromString(String linea) {
		// apellido
		String[] rowData = linea.split(";");
		String id = rowData[0];
		String title = rowData[1];
		String code = rowData[2];
		String price = rowData[3];

		return new ArticuloDTO(Long.parseLong(id), title, code, Double.parseDouble(price));

	}

	

}
