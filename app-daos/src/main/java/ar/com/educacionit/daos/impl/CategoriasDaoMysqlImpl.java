package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.CategoriaDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Categorias;

public class CategoriasDaoMysqlImpl extends JDBCBaseDao<Categorias> implements CategoriaDao {

	public CategoriasDaoMysqlImpl() {
		super("categorias");
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


	@Override
	public void saveData(Categorias entity, PreparedStatement pst) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String updateSQL(Categorias entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUpdateData(Categorias entity, PreparedStatement pst) throws SQLException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public String getSaveSQL() {
		// TODO Auto-generated method stub
		return null;
	}

		
	

}
