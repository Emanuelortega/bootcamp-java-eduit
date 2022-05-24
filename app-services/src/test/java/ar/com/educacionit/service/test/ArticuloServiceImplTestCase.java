package ar.com.educacionit.service.test;

import java.util.List;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class ArticuloServiceImplTestCase {

	public static void main(String[] args) throws ServiceException {

		
		ArticulosService service = new ArticulosServiceImpl();
		
		List<Articulo> list = service.finAll();
		
		System.out.println(list.size() > 0);
	}

}
