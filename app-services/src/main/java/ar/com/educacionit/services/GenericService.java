package ar.com.educacionit.services;

import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.services.exceptions.ServiceException;

public interface GenericService<T> {

	public T getById(Long id) throws ServiceException;
	public void delete(Long id) throws ServiceException;
	public void update(T entity) throws ServiceException;
	public List<T> finAll() throws ServiceException;
	public void create(T nuevo) throws ServiceException, SQLException;
	public void findPageable(Integer currentPage, Integer size) throws ServiceException;
}
