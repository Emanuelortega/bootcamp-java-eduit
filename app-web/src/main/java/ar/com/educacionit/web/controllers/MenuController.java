package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Menu;
import ar.com.educacionit.services.MenuService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.MenuServiceImpl;

@WebServlet("/controllers/menu")
public class MenuController extends HttpServlet {

	private static final long serialVersionUID = 5201437682934264327L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MenuService ms = new MenuServiceImpl();
		try {
			List<Menu> list = ms.finAll();
			
			request.setAttribute("menus", list);
			
			getServletContext().getRequestDispatcher("/tablaMenu.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			getServletContext().getRequestDispatcher("/registroFail.jsp").forward(request, response);
		}
		
	}
	
}
