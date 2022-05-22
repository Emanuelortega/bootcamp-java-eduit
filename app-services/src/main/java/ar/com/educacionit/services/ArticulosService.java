package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ArticulosService {

	// obtiene un articulo dado su id=PK

	public Articulo getById(Long id) throws ServiceException;
	public void deleteArticulo(Long id) throws ServiceException;
	public void updateArticulo (Articulo entity) throws ServiceException;
	public List<Articulo> ObtenerTodos() throws ServiceException;
	public void createArticulo(Articulo nuevo) throws ServiceException;
	public Articulo getByCodigo(String codigo)throws ServiceException;
}
