package practicasemana6;

import clase7.Articulo;

public class AccionDefault implements IAccion {

	public void exec(Articulo ctx) throws Exception {

		if (ctx == null) {
			throw new Exception("Articulo null");
		} else {
			System.out.println("Accion default");
		}
	}
}
