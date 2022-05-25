package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoMysqlImpl extends JDBCBaseDao<Articulo> implements ArticuloDao {

	// private Connection con;
	public ArticuloDaoMysqlImpl() {
		super("articulos");
	}

	@Override
	public void save(Articulo articulo) throws DuplicatedException, GenericException {// ctrl+f
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {

			StringBuffer sql = new StringBuffer(
					"INSERT INTO ARTICULOS (TITULO,CODIGO, PRECIO, CATEGORIA_ID, MARCA_ID,FECHA_CREACION,STOCK) VALUES(");
			sql.append("?,?,?,?,?,?,?)");

			try (PreparedStatement st = con2.prepareStatement(sql.toString(),
					PreparedStatement.RETURN_GENERATED_KEYS)) {

				st.setString(1, articulo.getTitulo());
				st.setString(2, articulo.getCodigo());
				st.setDouble(3, articulo.getPrecio());
				st.setLong(4, articulo.getCategoriasId());
				st.setLong(5, articulo.getMarcaId());
				st.setDate(6, new java.sql.Date(System.currentTimeMillis()));// java.sql.Date
				st.setLong(7, articulo.getStock());

				st.execute();

				try (ResultSet rs = st.getGeneratedKeys()) {

					if (rs.next()) {

						Long id = rs.getLong(1);

						articulo.setId(id);
					}
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

	@Override
	public void update(Articulo ArticuloToUpdate) throws GenericException {

		StringBuffer sql = new StringBuffer("UPDATE ARTICULOS SET ");

		if (ArticuloToUpdate.getTitulo() != null) {
			sql.append("titulo=?").append(", ");
		}

		if (ArticuloToUpdate.getCodigo() != null) {
			sql.append("codigo=?").append(", "); // respetar los espacios en las sentencias.
		}
		if (ArticuloToUpdate.getPrecio() != null) {
			sql.append("precio=?").append(", ");
		}
		if (ArticuloToUpdate.getStock() != null) {
			sql.append("stock=?").append(", ");
		}
		if (ArticuloToUpdate.getMarcaId() != null) {
			sql.append("marca_id=?").append(", ");
		}
		if (ArticuloToUpdate.getCategoriasId() != null) {
			sql.append("categoria_id=?").append(",");
		}

		sql = new StringBuffer(sql.substring(0, sql.length() - 1));
		sql.append(" WHERE id= ?");

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			// auto commit en false
			// si se realizo la conexion entoces:
			// 2_abrir un statement > Statement
			try (PreparedStatement st = con2.prepareStatement(sql.toString())) {

				// puedo setear atributo = valor con el tipo correcto
				// ejecuto la sentencia de la db
				if (ArticuloToUpdate.getTitulo() != null) {
					st.setString(1, ArticuloToUpdate.getTitulo());
				}
				if (ArticuloToUpdate.getCodigo() != null) {
					st.setString(2, ArticuloToUpdate.getCodigo());
				}
				if (ArticuloToUpdate.getPrecio() != null) {
					st.setDouble(3, ArticuloToUpdate.getPrecio());
				}
				if (ArticuloToUpdate.getStock() != null) {
					st.setLong(4, ArticuloToUpdate.getStock());
				}
				if (ArticuloToUpdate.getMarcaId() != null) {
					st.setLong(5, ArticuloToUpdate.getMarcaId());
				}
				if (ArticuloToUpdate.getCategoriasId() != null) {
					st.setLong(6, ArticuloToUpdate.getCategoriasId());
				}
				st.setLong(7, ArticuloToUpdate.getId());

				st.execute();
			}

		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);

		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}

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