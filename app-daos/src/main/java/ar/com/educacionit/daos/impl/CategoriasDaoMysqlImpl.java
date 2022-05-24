package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import ar.com.educacionit.daos.CategoriaDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Categorias;

public class CategoriasDaoMysqlImpl extends JDBCBaseDao<Categorias> implements CategoriaDao {

	public CategoriasDaoMysqlImpl() {
		super("categorias");
	}

	@Override
	public void save(Categorias Categorias) throws DuplicatedException, GenericException {// ctrl+f
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {

			StringBuffer sql = new StringBuffer(
					"INSERT INTO CategoriasS (TITULO,CODIGO, PRECIO, CATEGORIA_ID, MARCA_ID,FECHA_CREACION,STOCK) VALUES(");
			sql.append("?,?,?,?,?,?,?)");

			try (PreparedStatement st = con2.prepareStatement(sql.toString(),
					PreparedStatement.RETURN_GENERATED_KEYS)) {

				st.execute();

				try (ResultSet rs = st.getGeneratedKeys()) {

					if (rs.next()) {

						Long id = rs.getLong(1);

						Categorias.setId(id);
					}
				}
			}
		} catch (SQLException se) {
			if (se instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido insertar el Categorias, integridad de datos violada",
						se);
			}
			throw new GenericException(se.getMessage(), se);
		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		}

	}

	@Override
	public void update(Categorias CategoriasToUpdate) throws GenericException {

		StringBuffer sql = new StringBuffer("UPDATE CategoriasS SET ");

		sql = new StringBuffer(sql.substring(0, sql.length() - 1));
		sql.append(" WHERE id= ?");

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			// auto commit en false
			// si se realizo la conexion entoces:
			// 2_abrir un statement > Statement
			try (PreparedStatement st = con2.prepareStatement(sql.toString())) {

				// puedo setear atributo = valor con el tipo correcto
				// ejecuto la sentencia de la db
				st.setLong(7, CategoriasToUpdate.getId());

				st.execute();
			}

		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);

		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}

	}

	public Categorias fromResultSetToEntity(ResultSet rs) throws SQLException {

		// extraer los datos que vienen en el resultset rs
		// convertir el resulseta Categorias
		Long idCategorias = rs.getLong("id");
		String descripcion = rs.getString("descripcion");
		Long habilitada = rs.getLong("habilitada");

		return new Categorias(idCategorias, descripcion, habilitada);

	}

}
//seguir cap 30 1:20