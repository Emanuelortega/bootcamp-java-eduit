package ar.com.educacionit.web.controllers;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class UpdateArticuloController {

	public static void main(String[] args) throws ServiceException {

		
		ArticulosService service = new ArticulosServiceImpl();
		
		Articulo articulo = service.getByCodigo("004");
		
		articulo.setPrecio(50000d);
		
		service.update(articulo);
		
		
	}

}
