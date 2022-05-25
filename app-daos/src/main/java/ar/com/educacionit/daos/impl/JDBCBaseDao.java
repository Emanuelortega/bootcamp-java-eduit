package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.daos.GenericDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;

public abstract class JDBCBaseDao<T> implements GenericDao<T> {

	protected String tabla;

	public JDBCBaseDao(String tabla) {
		if (tabla == null) {
			throw new IllegalArgumentException("Debe indicar la tabla del dao");
		}
		this.tabla = tabla;
	}

	@Override
	public List<T> findAll() throws GenericException {
		List<T> registros = new ArrayList<>();
		String sql = "SELECT * FROM " + this.tabla;

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {

				T entity = fromResultSetToEntity(rs);
				registros.add(entity);
			}
			return registros;

		} catch (SQLException e) {
			throw new GenericException("Error ejecutando" + sql, e);
		}

	}

	@Override
	public void save(T orden) throws GenericException, DuplicatedException {
		// TODO Auto-generated method stub

	}

	@Override
	public T getByPK(Long id) throws GenericException {
		String sql = "SELECT * FROM " + this.tabla + " WHERE ID =" + id;

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
				ResultSet rs = st.executeQuery(sql)) {

			T entity = null;
			if (rs.next()) {
				entity = fromResultSetToEntity(rs);
			}
			return entity;

		} catch (SQLException e) {
			throw new GenericException("no se pudo obtener el entity " + this.tabla + "id:" + id, e);
		}
		/*
		 * catch (SQLException e) { throw new
		 * GenericException("no se pudo obtener el entity" +this.tabla+"id:" + id, e); }
		 */
	}

	@Override
	public void update(T ordenToUpdate) throws GenericException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws GenericException {
				String sql = "DELETE FROM " + this.tabla +" WHERE ID =" + id;
				
			try(Connection con2 =AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement()) {
				
						st.executeLargeUpdate(sql);
						
				} catch (GenericException ge) {
					throw new GenericException(sql, ge);

				} catch (SQLException se) {
					throw new GenericException(sql, se);
				}
	}
	
	@Override
	public List<T> findPageable(Integer currentPage, Integer size) throws GenericException {
		List<T> registros = new ArrayList<>();
		String sql = "SELECT * FROM " + this.tabla+ " LIMIT "+ size+ " OFFSET "+ (currentPage -1);

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {

				T entity = fromResultSetToEntity(rs);
				registros.add(entity);
			}
			return registros;

		} catch (SQLException e) {
			throw new GenericException("Error ejecutando" + sql, e);
		}

	}

	public abstract T fromResultSetToEntity(ResultSet rs) throws SQLException;
	/*
	 * // extraer los datos que vienen en el resultset rs // convertir el resulseta
	 * Categorias Long idCategorias = rs.getLong("id"); String titulo =
	 * rs.getString("titulo"); String codigo = rs.getString("codigo"); Date
	 * fechaCreacion = rs.getDate("fecha_creacion"); Double precio =
	 * rs.getDouble("precio"); Long stock = rs.getLong("stock"); Long marcasID =
	 * rs.getLong("marca_id"); Long categoriasId = rs.getLong("categoria_id");
	 * 
	 * return new Categorias(idCategorias, titulo, codigo, fechaCreacion, precio,
	 * stock, marcasID,categoriasId);
	 */

}
