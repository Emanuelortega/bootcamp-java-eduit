package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoMysqlImpl extends JDBCBaseDao<Articulo> implements ArticuloDao {

	// private Connection con;
	public ArticuloDaoMysqlImpl() {
		super("articulos");
	}

	public String getSaveSQL() {
		return ("(TITULO,CODIGO, PRECIO, CATEGORIA_ID, MARCA_ID,FECHA_CREACION,STOCK) VALUES (?,?,?,?,?,?,?)");
	}

	@Override
	public void saveData(Articulo entity, PreparedStatement pst) throws SQLException {

		pst.setString(1, entity.getTitulo());
		pst.setString(2, entity.getCodigo());
		pst.setDate(3, new java.sql.Date(System.currentTimeMillis()));// java.sql.Date
		pst.setDouble(4, entity.getPrecio());
		pst.setLong(5, entity.getStock());
		pst.setLong(6, entity.getMarcaId());
		pst.setLong(7, entity.getCategoriasId());

	}

	@Override
	public String updateSQL(Articulo entity) {

		StringBuffer sql = new StringBuffer();

		if (entity.getTitulo() != null) {
			sql.append("titulo=?").append(", ");
		}

		if (entity.getCodigo() != null) {
			sql.append("codigo=?").append(", "); // respetar los espacios en las sentencias.
		}
		if (entity.getPrecio() != null) {
			sql.append("precio=?").append(", ");
		}
		if (entity.getStock() != null) {
			sql.append("stock=?").append(", ");
		}
		if (entity.getMarcaId() != null) {
			sql.append("marca_id=?").append(", ");
		}
		if (entity.getCategoriasId() != null) {
			sql.append("categoria_id=?").append(",");
		}

		return sql.substring(0, sql.length() - 1).toString();

	}

	@Override
	public void saveUpdateData(Articulo entity, PreparedStatement pst) throws SQLException {

		if (entity.getTitulo() != null) {
			pst.setString(1, entity.getTitulo());
		}
		if (entity.getCodigo() != null) {
			pst.setString(2, entity.getCodigo());
		}
		if (entity.getPrecio() != null) {
			pst.setDouble(3, entity.getPrecio());
		}
		if (entity.getStock() != null) {
			pst.setLong(4, entity.getStock());
		}
		if (entity.getMarcaId() != null) {
			pst.setLong(5, entity.getMarcaId());
		}
		if (entity.getCategoriasId() != null) {
			pst.setLong(6, entity.getCategoriasId());
		}

		pst.setLong(7, entity.getId());

	}

	@Override
	public Articulo getByCode(String code) throws GenericException {
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			String sql = "SELECT * FROM ARTICULOS WHERE CODIGO = ? ";
			try (PreparedStatement st = con2.prepareStatement(sql)) {

				st.setString(1, code);
				try (ResultSet rs = st.executeQuery()) {
					Articulo articulo = null;
					if (rs.next()) {
						articulo = fromResultSetToEntity(rs);
					}
					return articulo;
				}
			} catch (SQLException e) {
				throw new GenericException("no se pudo obtener el articulo codigo :" + code, e);
			}
		} catch (SQLException e) {
			throw new GenericException("no se pudo obtener el articulo codigo :" + code, e);
		}

	}

	public Articulo fromResultSetToEntity(ResultSet rs) throws SQLException {

		// extraer los datos que vienen en el resultset rs
		// convertir el resulseta Articulo
		Long idArticulo = rs.getLong("id");
		String titulo = rs.getString("titulo");
		String codigo = rs.getString("codigo");
		Date fechaCreacion = rs.getDate("fecha_creacion");
		Double precio = rs.getDouble("precio");
		Long stock = rs.getLong("stock");
		Long marcasID = rs.getLong("marca_id");
		Long categoriasId = rs.getLong("categoria_id");

		return new Articulo(idArticulo, titulo, codigo, fechaCreacion, precio, stock, marcasID, categoriasId);

	}

}
