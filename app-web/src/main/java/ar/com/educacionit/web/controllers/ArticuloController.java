package ar.com.educacionit.web.controllers;

import java.util.List;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class ArticuloController {

	public static void main(String[] args) {

		// necesito el service

		ArticulosService service = new ArticulosServiceImpl();

		try {
			//obtengo todos los articulos
			List<Articulo> list = service.ObtenerTodos();
			
			if(!list.isEmpty()) {
				
				Articulo articulo = service.getById(list.get(0).getId());
				System.out.println(articulo);
				
				//quiero eliminar el articulo
				//service.deleteArticulo(articulo.getId());
				//System.out.println("se ha eliminado :"+ articulo.getId());
				articulo.setStock(25l);
				articulo.setPrecio(100000d);
				
				service.updateArticulo(articulo);
			}
		} catch (ServiceException e) {

			e.printStackTrace();
		}

	}

}
