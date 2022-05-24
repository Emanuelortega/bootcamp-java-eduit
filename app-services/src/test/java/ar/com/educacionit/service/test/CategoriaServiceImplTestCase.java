package ar.com.educacionit.service.test;

import java.util.List;

import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.services.CategoriasService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriasServiceImpl;

public class CategoriaServiceImplTestCase {

	public static void main(String[] args) throws ServiceException {

		
		CategoriasService service = new CategoriasServiceImpl();
		
		List<Categorias> list = service.finAll();
		
		System.out.println(list.size() > 0);
	}

}
