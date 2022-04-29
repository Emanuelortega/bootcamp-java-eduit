package practicasemana6;

import java.util.HashMap;
import java.util.Map;

import clase7.Articulo;

public class InMemoryDB {

	static private Map<Long, Articulo> db = new HashMap<>();

	public static void save(Long key, Articulo valor) throws ExceptionIdExistente {

		if (InMemoryDB.db.containsKey(key) || valor == null) {
			throw new ExceptionIdExistente("Este id ya existe");
		} else {
			InMemoryDB.db.put(key, valor);
		}
	}

	public static void update(Long key, Articulo newValue) throws ExceptionIdInexistente {
		if (InMemoryDB.db.containsKey(key) && newValue != null) {
			InMemoryDB.db.replace(key, newValue);
		} else {
			throw new ExceptionIdInexistente("no existe el iD a reemplazar, debe agregarlo");

		}
	}

	public static void delete(Long key) throws ArticuloInexistente {
		if (InMemoryDB.db.containsKey(key)) {
			InMemoryDB.db.remove(key);
		} else {
			throw new ArticuloInexistente("El articulo a eliminar no existe");

		}
	}

	public static Articulo getById(Long key) throws ArticuloNull {
		Articulo value = null;
		if (InMemoryDB.db.containsKey(key)) {
			value = InMemoryDB.db.get(key);
		} else {
			throw new ArticuloNull("Este articulo no existe, se devuelve Null");
		}
		return value;
	}

	public static void listAll() throws CollectionEmpy {
		if (InMemoryDB.db.isEmpty()) {
			throw new CollectionEmpy("Sin elementos que mostrar");

		} else {
			System.out.println(InMemoryDB.db.values());
			// impime los valores/ datos del articulo
			// pero no las claves;
		}
	}
}
