package ar.com.educacionit.web.enums;

import java.io.Serializable;
import java.util.Collection;

import ar.com.educacionit.domain.Articulo;

public class DefaultAction implements IExportable {

	@Override
	public String exportar(Collection<Serializable> datos) {
		return "default action";
	}

}
