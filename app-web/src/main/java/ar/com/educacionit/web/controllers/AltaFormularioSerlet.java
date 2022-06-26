package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;
//con la anotacion se convierte en un controller
@WebServlet("/controller/AltaFormularioServlet") 
public class AltaFormularioSerlet extends HttpServlet {
	
	private static final long serialVersionUID = -8914752493706445530L;

	//GET
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		//capturar los datos que se enviaron desde el form
		String fecha = request.getParameter("fecha");//strin
		//aplica logica
		
		//responder algo
		//response.getWriter().print("se ha grabado su orden");
		
	/*	  Double id = Math.random();
		//pasar a la siguiente pagina
		//guardo en el request el dato bajo una clave
		  request.setAttribute("idGen",id);
	*/	
		//ir a otra pagina(redireccionar)

		ArticulosService ar = new ArticulosServiceImpl();
		
		try {
			Collection<Articulo> list = ar.finAll();
			request.setAttribute("articulos", list);
			// si sale todo ok lo mando a:
			getServletContext().getRequestDispatcher("/registroOk.jsp").forward(request, response);
		} catch (ServiceException e) {
			//si sale mal lo 
			getServletContext().getRequestDispatcher("/registroFail.jsp").forward(request, response);
		}
	}
	
	
	//POST
	//FIlE
	public void doPo (HttpServletRequest request,HttpServletResponse response) {

		//capturar los datos que se enviaron desde el form
		//response.getWriter().print("se ha grabado su orden");
		
		//aplica logica
		
		//responder algo
	}

	
}
