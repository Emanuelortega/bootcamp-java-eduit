package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.daos.GenericDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Entity;

public abstract class JDBCBaseDao<T extends Entity> implements GenericDao<T> {

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
		String sql = " SELECT * FROM " + this.tabla;

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {

				T entity = fromResultSetToEntity(rs);
				registros.add(entity);
			}
			return registros;

		} catch (SQLException e) {
			throw new GenericException("Error ejecutando " + sql, e);
		}

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

	public  String getSaveSQL() {
		return "";
	}

	public  void saveData(T entity, PreparedStatement pst) throws SQLException{
		
	}

	private String getSaveSql2(T entity) throws SQLException, GenericException {

		String sqlgetColum = "SHOW COLUMNS FROM " + this.tabla;
		StringBuffer sql = new StringBuffer(" INSERT INTO " + this.tabla + " ( ");

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
				ResultSet rs = st.executeQuery(sqlgetColum)) {

			int columnID = 0;
			while (rs.next()) {

				if (columnID == 0) {
					columnID++;
					continue;
				} else {
					sql.append(rs.getString("Field")).append(",");
					columnID++;
				}
			}

			sql = new StringBuffer(sql.substring(0, sql.length() - 1));
			sql.append(" ) Values (");

			for (int a = 0; a < columnID - 1; a++) {
				sql.append("?,");
			}

			sql = new StringBuffer(sql.substring(0, sql.length() - 1)).append(")");
		}

		return sql.toString();

	}

	
	//prueba en app-web/ar.com.educacionit.web.controllers/Savecontroller
	
	@Override
	public void save(T entity) throws GenericException, DuplicatedException, SQLException {

		//String sql = getSaveSql2(entity);
		StringBuffer sql = new StringBuffer("INSERT INTO ").append(this.tabla).append(this.getSaveSQL());

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion();
				PreparedStatement st = con2.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS)) {

			this.saveData(entity, st);

			st.execute();

			try (ResultSet rs = st.getGeneratedKeys()) {
				if (rs.next()) {

					Long id = rs.getLong(1);
					entity.setId(id);
				}
			}

		} catch (SQLException se) {
			if (se instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido insertar el articulo, integridad de datos violada", se);
			}
			throw new GenericException(se.getMessage(), se);
		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		}
	}

	public  String updateSQL(T entity) {
		return "";
	}

	public  void saveUpdateData(T entity, PreparedStatement pst) throws SQLException{
		
	}

	@Override
	public void update(T entity) throws GenericException {

		String sql = " UPDATE " + this.tabla + " SET " + updateSQL(entity) + " WHERE id= ?";

		int idx = getWhereIndex(sql);

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			try (PreparedStatement st = con2.prepareStatement(sql)) {

				this.saveUpdateData(entity, st);
				st.setLong(idx, entity.getId());
				st.execute();
			}

		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);

		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}

	}

	// determina el indice del where en un update
	private int getWhereIndex(String sql) {
		int idx = 0;
		for (char c : sql.toString().toCharArray()) {
			if (c == '?') {
				idx++;
			}
		}
		return idx;
	}

	@Override
	public void delete(Long id) throws GenericException {
		String sql = "DELETE FROM " + this.tabla + " WHERE ID =" + id;

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion(); Statement st = con2.createStatement()) {

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
		String sql = "SELECT * FROM " + this.tabla + " LIMIT " + size + " OFFSET " + (currentPage - 1);

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

}
