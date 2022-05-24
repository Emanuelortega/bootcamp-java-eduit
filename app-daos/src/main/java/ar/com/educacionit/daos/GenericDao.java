package ar.com.educacionit.daos;

import java.util.List;

import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;

public interface GenericDao <T> {

	public List<T> findAll() throws GenericException;
	public void save(T orden)throws GenericException, DuplicatedException;
	public T getByPK(Long id) throws GenericException;
	public void update(T ordenToUpdate) throws GenericException;
	public void delete(Long id) throws GenericException;

	
}
