package ar.com.educacionit.services.exceptions;

import ar.com.educacionit.daos.db.exceptions.GenericException;

public class ServiceException extends Exception {

	public ServiceException(String msj, Throwable e) {
		super(msj, e);
	}

}
