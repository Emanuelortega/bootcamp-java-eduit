package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoMysqlImpl implements ArticuloDao {

	// private Connection con;

	public ArticuloDaoMysqlImpl() {
		/*
		 * try { this.con = AdministradorDeConexiones.obtenerConexion(); } catch
		 * (GenericException e) { throw new IllegalArgumentException(e.getMessage(), e);
		 * }
		 */
	}

	@Override
	public Articulo save(Articulo Articulo) {// ctrl+f

		return Articulo;
	}

	@Override
	public Articulo getByPK(Long id) throws GenericException {
		// connection
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			// Statement
			try (Statement st = con2.createStatement()) {

				// resulset
				// execute del sql
				try (ResultSet rs = st.executeQuery("SELECT * FROM ARTICULOS WHERE ID = " + id)) {
					Articulo articulo = null;
					if (rs.next()) {
						articulo = fromResultSetToEntity(rs);
					}
					return articulo;
				}
			} catch (SQLException e) {
				throw new GenericException("no se pudo obtener el articulo id :" + id, e);
			}
		} catch (SQLException e) {
			throw new GenericException("no se pudo obtener el articulo id :" + id, e);
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
				
				//puedo setear atributo = valor con el tipo correcto 
				// ejecuto la sentencia de la db
				if(ArticuloToUpdate.getTitulo() != null) {
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
	public void delete(Long id) throws GenericException {
		// ELIMINA UN REGISTRO
		// DELETE FROM TABLA/ARTICULOS WHERE ID
		String sql = "DELETE FROM ARTICULOS WHERE ID =" + id;
		Connection con2 = null;
		// 1_abrir conexion > Connection

		try {
			con2 = AdministradorDeConexiones.obtenerConexion();
			// auto commit en false
			con2.setAutoCommit(false);

			// si se realizo la conexion entoces:
			// 2_abrir un statement > Statement
			try (Statement st = con2.createStatement()) {
				// ejecuto la sentencia de la db
				st.executeLargeUpdate(sql);
			}

			con2.commit();
		} catch (GenericException ge) {
			roolback(con2, sql);
			throw new GenericException(sql, ge);

		} catch (SQLException se) {
			roolback(con2, sql);
			throw new GenericException(sql, se);
		}

		// 3_
		// 4auto commit en false

	}

	private void roolback(Connection con2, String sql) throws GenericException {
		try {
			con2.rollback();
		} catch (SQLException e) {
			throw new GenericException(sql, e);
		}
	}

	@Override
	public List<Articulo> findAll() throws GenericException {
		List<Articulo> registros = new ArrayList<>();
		String sql="SELECT * FROM ARTICULOS";
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			try (Statement st = con2.createStatement()) {
				try (ResultSet rs = st.executeQuery(sql)) {
					while(rs.next()) {
						
						Articulo articulo = fromResultSetToEntity(rs);
						registros.add(articulo);
					}
				}
			} catch (SQLException e) {
				throw new GenericException("no se pudo obtener los registros:", e);
			}
		} catch (SQLException e) {
			throw new GenericException("Error ejecutando" + sql, e);
		}
		return registros;
	}

	private Articulo fromResultSetToEntity(ResultSet rs) throws SQLException {
	
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

			return new Articulo(idArticulo, titulo, codigo, fechaCreacion, precio, stock, marcasID,categoriasId);
		
	}

}
