package ar.com.educacionit.daos.test;

import java.util.List;

import ar.com.educacionit.daos.CategoriaDao;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.CategoriasDaoMysqlImpl;
import ar.com.educacionit.domain.Categorias;

public class CategoriasDaoMySqlImplTestCase {

	public static void main(String[] args) throws GenericException {

		
		//test when_finAll_then_showlist
		CategoriaDao dao = new CategoriasDaoMysqlImpl();
		
		List<Categorias> list = dao.findAll();
		
		System.out.println(list.size()>0);
	}

}
