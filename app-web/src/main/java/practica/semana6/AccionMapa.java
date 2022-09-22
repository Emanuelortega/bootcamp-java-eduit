package practica.semana6;

import java.util.HashMap;
import java.util.Map;

public class AccionMapa {

	static Map<Integer, IAccion> AccionMapa = CargarMap();

	private static Map<Integer, IAccion> CargarMap() {

		Map<Integer, IAccion> AccionMapa = new HashMap<>();

		AccionMapa.put(1, new AccionAlta());
		AccionMapa.put(2, new AccionBaja());
		AccionMapa.put(3, new AccionModificar());
		AccionMapa.put(3, new AccionListar());

		return AccionMapa;
	}

	public static IAccion GetAccion(Integer opc) {

		IAccion accion = new AccionDefault();

		if (AccionMapa.containsKey(opc)) {
			accion = AccionMapa.get(opc);
		}

		return accion;

	}

}
