package ar.com.educacionit.web.streams;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class FiltroMainObjetos {
	public static void main(String[] args) throws ServiceException {

		Set<Integer> edades = Set.of(10, 20, 30, 50, 5);

		Integer suma = 0;
		for (Integer edad : edades) {
			suma += edad;
		}
		System.out.println(suma);
		
		//----
		
		suma = edades.stream()
			.reduce(0,(x,y) -> x+y);
		System.out.println(suma);
		
		//
		Collection<Articulo> arts = new ArticulosServiceImpl().finAll();
			
		//suma de todos los articulos
		
		Double sumaD = arts.stream()
				.map(art -> art.getPrecio())
				.reduce(0D,(x,y) -> (x*1.2)+y);
		System.out.println(sumaD);
		//------
		
		Set<String> palabras= Set.of("Hola", "matias", "soy", "emanuel");
		
		String unaSolaCadena = palabras.stream()
				.reduce("", (x,y) -> x + "-" + y);
		System.out.println(unaSolaCadena);
		
		

	}

}