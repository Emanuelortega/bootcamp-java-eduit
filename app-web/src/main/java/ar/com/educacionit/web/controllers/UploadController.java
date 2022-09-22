package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.services.exceptions.ParseException;
import ar.com.educacionit.services.parse.CSVFileParser;
import ar.com.educacionit.services.parse.IParser;
import ar.com.educacionit.services.parse.ArticuloDTO;
import ar.com.educacionit.web.enums.AttributesEnum;
import ar.com.educacionit.web.enums.ViewsEnum;

@WebServlet("/controllers/UploadController")
@MultipartConfig
public class UploadController extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// captuarar el "file" > part
		Part filePart = req.getPart("file");

		ViewsEnum target = ViewsEnum.UPLOAD_PREVIEW;

		if (filePart == null || filePart.getSize() == 0) {
			super.setAttributes(AttributesEnum.ERROR_GENERAL, req, "Debe seleccionar un archivo");
			target = ViewsEnum.UPLOAD;
			redirect(null, req, resp);
		}
		// InputStream

		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		// algo.ext
		String ext = this.getExt(fileName);

		IParser<Collection<ArticuloDTO>> fileParser = null;
		switch (ext) {
		case "csv":{
			fileParser = new CSVFileParser(filePart);
			}
		}
		
		if (filePart == null || filePart.getSize() == 0) {
			// error
			super.setAttributes(AttributesEnum.ERROR_GENERAL, req, "Ext de archivo imcorrecto");
			target = ViewsEnum.UPLOAD;
			redirect(target, req, resp);
		}
		
		try {
			Collection<ArticuloDTO> articulos = fileParser.parse();
			super.setAttributes(AttributesEnum.UPLOAD_PREVIEW_KEY, req.getSession(), articulos);
		} catch (ParseException e) {
			super.setAttributes(AttributesEnum.ERROR_GENERAL, req.getSession(), "No se ha podido pasarsear el archivo:  " + fileName);
			target = ViewsEnum.UPLOAD;
		}
		
		redirect(target, req, resp);
	}

	private String getExt(String fileName) {

		String[] names = fileName.split("\\.");
		return names[names.length - 1];

		// nombre.nom.
	}
}