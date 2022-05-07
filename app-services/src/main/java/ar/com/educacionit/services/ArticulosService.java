package ar.com.educacionit.services;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ArticulosService {

	// obtiene un articulo dado su id=PK

	public Articulo getById(Long id) throws ServiceException;

}
