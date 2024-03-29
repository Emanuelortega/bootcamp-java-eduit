package ar.com.educacionit.services.files;

import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.domain.Menu;

public class MenuRecursivo {

	public static void main(String[] args) {

	
	List <Menu> menus = getMenuFromDB();
	
	mostrarMenu(menus);
	
	}

	private static void mostrarMenu(List<Menu> menus) {

		//caso base?
		for(Menu m : menus) {
			System.out.println(m.getTexto());
			if(m.isRoot()) {
				System.out.println("---------");
			}
				mostrarMenu(m.getSubMenu());
		}
	}

	private static List<Menu> getMenuFromDB() {
		List<Menu> subMenu = new ArrayList<Menu>();
		Menu html = new Menu("HTML",new ArrayList<>(), false,"http/prueba");
		subMenu.add(html);
		
		Menu references = new Menu("References", subMenu, true,"http/prueba");
		
		Menu hijosGuides = new Menu("H1",new  ArrayList<>(), false,"http/prueba");
		List<Menu> subMenuHG = new ArrayList<Menu>();
		subMenuHG.add(hijosGuides);
		
		subMenu = new ArrayList<>();
		Menu mdn = new Menu("MDN",subMenuHG, false,"http/prueba");
		subMenu.add(mdn);
		
		Menu guides = new Menu("Guides", subMenu, true,"http/prueba");
		
		
		List<Menu> menus = new ArrayList<>();
		menus.add(references);
		menus.add(guides);
		
		return menus;
	}

}
