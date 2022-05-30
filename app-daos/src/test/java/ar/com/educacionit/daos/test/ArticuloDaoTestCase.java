package ar.com.educacionit.daos.test;

import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.domain.Articulo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@TestMethodOrder(OrderAnnotation.class)
public class ArticuloDaoTestCase {

	@Order(1)
	@Test
	public void then_initialize_then_showIt() {
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		assertNotNull(art);
	}

	@Order(2)
	@Ignore
	// @Test
	public void when_newArticulo_then_persistIt() throws GenericException, DuplicatedException, SQLException {
		// quiero testear el metodo save

		ArticuloDao art = new ArticuloDaoMysqlImpl();

		// nesecito un articulo
		Articulo articulo = new Articulo("titulo", "32165544", new Date(), 1500d, 100l, 1l, 1l);
		art.save(articulo);
		assertNotNull(articulo.getId());

	}

	@Order(3)
	@Test
	public void when_findAll_then_persistIt() throws GenericException, DuplicatedException, SQLException {
		// quiero testear el metodo save

		ArticuloDao art = new ArticuloDaoMysqlImpl();

		List<Articulo> list = art.findAll();

		assertNotEquals(0, list.size());
		assertEquals(19, list.size());

	}

	@Order(4)
	@Test
	public void when_getOneCode_showIt() throws GenericException {
		ArticuloDao artDao = new ArticuloDaoMysqlImpl();
		Articulo art = artDao.getByCode("32165544");
		assertEquals("32165544", art.getCodigo());
	}

	@Order(5)
	@Test
	public void when_exist_then_updateIt() throws GenericException {

		ArticuloDao artDao = new ArticuloDaoMysqlImpl();
		Articulo art = artDao.getByCode("32165544");
		art.setTitulo("nuevo titulo");

		artDao.update(art);

		assertEquals("nuevo titulo", art.getTitulo());

	}

	// insert, update, delete
	@Test
	public void when_create_update_delete_then_notExits() throws GenericException, DuplicatedException, SQLException {
		ArticuloDao artDao = new ArticuloDaoMysqlImpl();
		// Test save
		Articulo testArticulo = new Articulo("tituloTest", "codigoTest", new java.util.Date(), 1500d, 100l, 1l, 1l);
		artDao.save(testArticulo);

		Long id = testArticulo.getId();
		assertNotNull(id);

		// Test update
		testArticulo = artDao.getByCode("codigoTest");
		testArticulo.setTitulo("codigoTestUpdated");
		artDao.update(testArticulo);
		assertEquals("codigoTestUpdated", testArticulo.getTitulo());

		// Test delete
		artDao.delete(id);
		// buscar si existe art con ese id

		// opcional!
		Articulo artDeleted = artDao.getByPK(id);
		assertNull(artDeleted);
	}

	@Test
	public void when_duplicate_then_throw_exception() throws GenericException, DuplicatedException, SQLException {
		// quiero probar el metodo save
		ArticuloDao art = new ArticuloDaoMysqlImpl();

		Articulo newArticulo = new Articulo("titulo", "codigo1001", new java.util.Date(), 1500d, 100l, 1l, 1l);

		art.save(newArticulo);

		assertThrows(DuplicatedException.class, () -> {
			newArticulo.setCodigo("codigo1002");
			art.save(newArticulo);
		});

	}

}
