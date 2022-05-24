package ar.com.educacionit.web.controllers;

import java.util.List;
import java.util.Scanner;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class DeleteArticuloController {

	public static void main(String[] args) throws ServiceException {

		ArticulosService service = new ArticulosServiceImpl();

		System.out.println("articulos existentes:");
		List<Articulo> list = service.finAll();
		System.out.println(list);

		try (Scanner teclado = new Scanner(System.in)) {
			System.out.println("ingrese id del articulo a eliminar");
			Long id = teclado.nextLong();
			service.delete(id);
		}

	}

}
