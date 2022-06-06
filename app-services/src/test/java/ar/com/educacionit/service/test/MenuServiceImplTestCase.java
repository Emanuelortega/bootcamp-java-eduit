package ar.com.educacionit.service.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import ar.com.educacionit.domain.Menu;
import ar.com.educacionit.services.MenuService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.MenuServiceImpl;

public class MenuServiceImplTestCase {

	//@Test
	public void when_find_then_show_menu_list() throws ServiceException {
		
		MenuService service = new MenuServiceImpl();
		List<Menu>menuList = service.finAll();
		assertTrue(menuList.isEmpty());
		
	}
	
	//T.D.D => desde el test hacia la implementacion/logica
	//test driver developer

	@Test
	public void when_find_1_then_show_it() throws ServiceException {
		
		MenuService service = new MenuServiceImpl();
		List<Menu>menuList = service.finAll();
		System.out.println(menuList);
		assertEquals(1, menuList.size());
		
	}
	
}
