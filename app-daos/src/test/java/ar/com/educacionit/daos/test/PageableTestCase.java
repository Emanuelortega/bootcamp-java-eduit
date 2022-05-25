package ar.com.educacionit.daos.test;

import java.util.List;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.domain.Articulo;

public class PageableTestCase {

	public static void main(String[] args) throws GenericException {

		ArticuloDao dao = new ArticuloDaoMysqlImpl();
		
		List<Articulo> articulo = dao.findPageable(1, 1);
		
		System.out.println(articulo);
		
	}

}
