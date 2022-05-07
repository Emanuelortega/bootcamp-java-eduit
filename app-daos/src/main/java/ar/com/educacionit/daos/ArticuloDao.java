package ar.com.educacionit.daos;

import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;
/**
 * 
 * @author LopezCar
 *
 */
public interface ArticuloDao {

	// definir los metodos CRUD
	public Articulo save(Articulo orden);

	public Articulo getByPK(Long id) throws GenericException;

	public Articulo update(Articulo ordenToUpdate);

	public Articulo delete(Long id);
}
