package ar.com.educacionit.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.educacionit.web.enums.AttributesEnum;
import ar.com.educacionit.web.enums.ViewsEnum;

public class  BaseServlet extends HttpServlet {

	
	public void redirect(ViewsEnum view, HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException {
	
		getServletContext().getRequestDispatcher(view.getValue()).forward(request, response);
	}
	
	public void setAttributes(AttributesEnum atribute, HttpServletRequest req, Object value) {
		req.setAttribute(atribute.getValue(),value);
	}
	
	public void setAttributes(AttributesEnum atribute, HttpSession session, Object value) {
		session.setAttribute(atribute.getValue(),value);
	}
}
