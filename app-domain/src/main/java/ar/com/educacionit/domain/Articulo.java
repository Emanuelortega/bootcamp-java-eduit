package ar.com.educacionit.domain;

import java.util.Date;

public class Articulo implements Entity {

	private Long id;
	private String titulo;
	private String codigo;
	private Date fechaCreacion;
	private Double precio;
	private Long Stock;
	private Long marcaId;
	private Long categoriasId;

	// constructor sin id > para el insert

	public Articulo(String titulo, String codigo, Date fechaCreacion, Double precio, Long stock, Long marcaId,
			Long categoriasId) {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
		this.fechaCreacion = fechaCreacion;
		this.precio = precio;
		this.Stock = stock;
		this.marcaId = marcaId;
		this.categoriasId = categoriasId;
	}

	// constructor con id :cuando obtenga el dato de la db

	public Articulo(Long id, String titulo, String codigo, Date fechaCreacion, Double precio, Long stock, Long marcaId,
			Long categoriasId) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.codigo = codigo;
		this.fechaCreacion = fechaCreacion;
		this.precio = precio;
		this.Stock = stock;
		this.marcaId = marcaId;
		this.categoriasId = categoriasId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return Stock;
	}

	public void setStock(Long stock) {
		Stock = stock;
	}

	public Long getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

	public Long getCategoriasId() {
		return categoriasId;
	}

	public void setCategoriasId(Long categoriasId) {
		this.categoriasId = categoriasId;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", titulo=" + titulo + ", codigo=" + codigo + ", fechaCreacion=" + fechaCreacion
				+ ", precio=" + precio + ", Stock=" + Stock + ", marcaId=" + marcaId + ", categoriasId=" + categoriasId
				+ "]";
	}

}
