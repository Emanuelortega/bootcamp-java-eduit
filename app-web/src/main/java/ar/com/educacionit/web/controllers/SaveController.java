package ar.com.educacionit.web.controllers;

import java.sql.SQLException;
import java.util.Date;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class SaveController {

	public static void main(String[] args) throws ServiceException, IllegalArgumentException, IllegalAccessException, SQLException {

	
		Articulo articulo = new Articulo("carpeta", "5566465",new Date(), 200d,15l,2l,3l);
		ArticulosService service = new ArticulosServiceImpl();
		
		service.create(articulo);
		System.out.println("articulo cargado");
		
	
		/*
		Categorias categoria = new Categorias("futbol", 10l);
		CategoriasService service2 =  new CategoriasServiceImpl();
		
		service2.create(categoria);
		System.out.println("articulo cargado");
		*/
		
		//new java.sql.Date(System.currentTimeMillis());
	}
}
