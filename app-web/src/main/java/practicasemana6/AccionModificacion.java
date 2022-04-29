package practicasemana6;

import clase7.Articulo;

public class AccionModificacion implements IAccion {

	@Override
	public void exec(Articulo ctx) throws Exception {

		if (ctx == null) {
			throw new Exception("Articulo null");

		} else {
			InMemoryDB.update(ctx.getId(), ctx);
		}
	}

}
