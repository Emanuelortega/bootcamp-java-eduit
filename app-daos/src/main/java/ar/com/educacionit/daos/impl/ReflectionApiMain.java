package ar.com.educacionit.daos.impl;

import java.lang.reflect.Field;
import java.util.Date;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Orden;

public class ReflectionApiMain {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		Articulo art = new Articulo(1l, "titulo", "codigo", new Date(), 2000D, 1l, 1l, 1l);
		Categorias cat = new Categorias(5l, "des 20", 1l);
		Orden ord = new Orden(5l, "asd", 30f);

		Field[] atrs = cat.getClass().getDeclaredFields();

		// String sentencia = String.join(",", atrs);

		// System.out.println(sentencia);

		StringBuffer sent = new StringBuffer();
		for (Field f : atrs) {

			f.setAccessible(true);
			// sent.append(f.getName()).append(",");
			String valor = f.get(cat).getClass().getSimpleName(); // del campo dame su valor del objeto art
			System.out.println(valor);
			// System.out.println(f.getName());

		}

		Date hora = new java.sql.Date(System.currentTimeMillis());

		System.out.println(hora);

		// sent = new StringBuffer( sent.substring(0,sent.length()-1).toString());
		// System.out.println(sent.toString());

		// return sql.substring(0, sql.length() - 1).toString();

		/*
		 * 
		 * obtenerAtrsValor(art); System.out.println("-----"); obtenerAtrsValor(cat);
		 * System.out.println("-----"); obtenerAtrsValor(ord); }
		 * 
		 * private static void obtenerAtrsValor(Object obj) throws
		 * IllegalAccessException {
		 * 
		 * //obtengo los atributos de la clase articulo a traves de su objeto art Field
		 * [] atrs = obj.getClass().getDeclaredFields();
		 * 
		 * for(Field f : atrs) {
		 * 
		 * f.setAccessible(true); System.out.print(f.getName()+ "  "); //del campo dame
		 * su nombre Object valor = f.get(obj); // del campo dame su valor del objeto
		 * art System.out.println(valor); }
		 * 
		 */
	}

}
