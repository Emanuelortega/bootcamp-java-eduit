package ar.com.educacionit.web.controllers;

import java.util.List;

import ar.com.educacionit.domain.Menu;
import ar.com.educacionit.services.MenuService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.MenuServiceImpl;

public class MenuControllerEj {

	public static void main(String[] args) throws ServiceException {

		
		MenuService ms = new MenuServiceImpl();
		List<Menu> List = ms.finAll();
		
		
		
	}

}
