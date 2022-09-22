package ar.com.educacionit.daos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SociosDaoMysqlImpl extends JDBCBaseDao<Socios> implements SociosDao {

	// private Connection con;
	public SociosDaoMysqlImpl() {
		super("socios");
	}

	public String getSaveSQL() {
		return ("(APELLIDO,NOMBRE,CODIGO) VALUES (?,?,?)");
	}

	@Override
	public void saveData(Socios entity, PreparedStatement pst) throws SQLException {

		pst.setString(1, entity.getApellido());
		pst.setString(2, entity.getNombre());
		pst.setString(3, entity.getCodigo());

	}

	@Override
	public String updateSQL(Socios entity) {

		return "";
	}

	@Override
	public void saveUpdateData(Socios entity, PreparedStatement pst) throws SQLException {

	}


	public Socios fromResultSetToEntity(ResultSet rs) throws SQLException {

		// extraer los datos que vienen en el resultset rs
		// convertir el resulseta Articulo
		Long id = rs.getLong("id");
		String apellido = rs.getString("apellido");
		String nombre = rs.getString("nombre");
		String codigo = rs.getString("codigo");
		return new Socios(id, apellido, nombre, codigo);

	}

}
