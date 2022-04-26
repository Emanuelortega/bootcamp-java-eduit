package clase19;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mainpractica {

	public static void main(String[] args) {

		Map<Integer, String> mapa1 = new HashMap<>();

		mapa1.put(1, "lunes");
		mapa1.put(2, "martes");
		mapa1.put(3, "miercoles");

		System.out.println(mapa1);

		System.out.println(mapa1.containsKey(2));

		// mapa1.clear();

		// System.out.println(mapa1);

		mapa1.put(1, "otro valor");
		mapa1.replace(2, "segundo valor");
		System.out.println(mapa1);

		Set<Integer> Keys = mapa1.keySet();

		System.out.println(Keys);

		Collection<String> valor = mapa1.values();

		System.out.println(valor);

		// mapa1.get(K)= devuelve su valor;

		for (Integer K : Keys) {

			String SuValor = mapa1.get(K);
			System.out.println("Clave :" + K + "Valor: " + SuValor);
		}

		System.out.println(mapa1);
		// recorrido por valores

		for (String SuValor : valor) {
			System.out.println("valor: " + SuValor);
		}
		
		//Map.Entry<K,V>
		Set<Map.Entry<Integer, String>> EntrySet=mapa1.entrySet();
		
		for(Map.Entry<Integer, String> oneEntry : EntrySet) {
			
			Integer oneKey = oneEntry.getKey();
			String oneValor = oneEntry.getValue();
			
			System.out.println(oneKey+ "-" +oneValor);
			
			
		}
	}
}
