package ar.com.educacionit.web.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FiltroMain {

	public static void main(String[] args) {

		List<Integer> edades = new ArrayList<>();

		edades.add(150);
		edades.add(100);
		edades.add(55);
		edades.add(45);
		edades.add(175);

		// forma imperativa: le digo que quiero y como lo hago
		// filtrar los > a 55
		List<Integer> edadesFiltradas = new ArrayList<>();

		for (Integer edad : edades) {
			if (edad > 55) {
				edadesFiltradas.add(edad);
			}
		}
		System.out.println(edadesFiltradas);
		
		//ahora quiero una lista de string
		List<String> edadesString = new ArrayList<>(); 
		for (Integer edad : edadesFiltradas) {
			edadesString.add("EDAD: "+ edad);
		}
		System.out.println(edadesString);
		//--------
		
		//version 1
		//1 conecto el stream de datos
		Stream<Integer> stEdades = edades.stream();
		
		//2_aplico una funcion intermedia
		stEdades = stEdades.filter(edad -> edad > 55);

		//3_ funcion terminal
		
		edadesFiltradas = stEdades.collect(Collectors.toList());
		
		System.out.println(edadesFiltradas);
		
		//-----------
		//version 2
		edadesString = edades
								.stream()
								.filter(edad -> edad > 55 && edad <150)
								.map(edad -> "Edad:"+ edad)//define el tipo de dato de salida
								.collect(Collectors.toList());
		System.out.println(edadesFiltradas);
		System.out.println(edadesString);
		
		//64 min 54
	}

}







