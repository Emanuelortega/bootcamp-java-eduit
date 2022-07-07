package ar.com.educacionit.web.enums;

import java.util.HashMap;
import java.util.Map;

public class ActionBuilder {

	private static Map<FormatoEnum, IFormato> actionMap = buildActionFormat();

	public static IFormato getAction(FormatoEnum _enum) {// NULL
		// IFormato action = actionMap.get(_enum);
		// return action == null ? new DefaultAction() : action;

		// opc 2 - contains
		IFormato action = new DefaultAction();
		if (actionMap.containsKey(_enum)) {
			action = actionMap.get(_enum);
		}
		return action;
	}

	private static Map<FormatoEnum, IFormato> buildActionFormat() {
		Map<FormatoEnum, IFormato> map = new HashMap<>();
		map.put(FormatoEnum.CSV, new CSVAction());
		map.put(FormatoEnum.PDF, new PDFAction());
		map.put(FormatoEnum.XLSX, new XLSXAction());

		return map;
	}

}
