package clase19;

import java.util.HashMap;
import java.util.Map;

import clase7.Articulo;

public class InMemoryDB {

	static private Map<Long,Articulo> db = new HashMap<>();
	
	
	public static void save(Long key,Articulo valor) {  //carga articulo
		InMemoryDB.db.put(key, valor);
	}
	
	public static void update(Long key, Articulo newValue) { //reemplaza un articulo con uno nuevo
		InMemoryDB.db.replace(key,newValue);
	}
	
	public static void delete(Long key) { //elimina un articulo
		InMemoryDB.db.remove(key);
	}
	
	public static Articulo getById(Long key) {  //retorna un articulo si existe
		Articulo value = null;
		if(InMemoryDB.db.containsKey(key)) {
			value = InMemoryDB.db.get(key);
		}
		return value;
	}

	public static void listAll() {					//muestra la coleccion
		System.out.println(InMemoryDB.db.values());		
	}
}
