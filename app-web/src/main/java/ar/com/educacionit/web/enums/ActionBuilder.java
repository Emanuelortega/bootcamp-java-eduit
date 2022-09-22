package ar.com.educacionit.web.enums;

import java.util.HashMap;
import java.util.Map;

public class ActionBuilder {

	private static Map<FormatoEnum, IExportable> actionMap = buildActionFormat();

	public static IExportable getAction(FormatoEnum _enum) {// NULL
		// IExportable action = actionMap.get(_enum);
		// return action == null ? new DefaultAction() : action;

		// opc 2 - contains
		IExportable action = new DefaultAction();
		if (actionMap.containsKey(_enum)) {
			action = actionMap.get(_enum);
		}
		return action;
	}

	private static Map<FormatoEnum, IExportable> buildActionFormat() {
		Map<FormatoEnum, IExportable> map = new HashMap<>();
		map.put(FormatoEnum.CSV, new CSVAction());
		map.put(FormatoEnum.PDF, new PDFAction());
		map.put(FormatoEnum.XLSX, new XLSXAction());

		return map;
	}

}
