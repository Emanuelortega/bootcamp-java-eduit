package ar.com.educacionit.daos.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.MenuDaoMySqlImpl;
import ar.com.educacionit.domain.Menu;

public class MenuDaoImpl {

	public static void main(String[] args) throws GenericException {

		List<Menu> menu = new MenuDaoMySqlImpl().findAll();
		List<Menu> menu2 = buildMenu2(menu);
	}

	private static List<Menu> buildMenu2(List<Menu> listMenu) {
		Map<Long, Menu> mapRoot = new HashMap<Long, Menu>();
		
		
		for (Menu m : listMenu) {
			if (m.isRoot()) {
				mapRoot.put(m.getId(), m);
				//los quito de la lista?
			}
		}
		
		for (Menu m : listMenu) {
			if (!m.isRoot()) {
				if (m.getIdMenuPadre() != null && m.getId() != 0) {
					Menu menuRoot = mapRoot.get(m.getIdMenuPadre());
					if(menuRoot != null) {
						menuRoot.getSubMenu().add(m);
					}else {
						addToParent(listMenu, m);
					}
				}
			}
		}

		List<Menu> menuFiltrados = new ArrayList<Menu>();
		menuFiltrados.addAll(mapRoot.values());
		return menuFiltrados;
	}
	
	private static List<Menu> buildMenu(List<Menu> listMenu) {
		List<Menu> menuFiltrado = new ArrayList<Menu>();

		
		for (Menu m : listMenu) {
			if (m.isRoot()) {
				menuFiltrado.add(m);
			}
		}
		
		for (Menu m : listMenu) {

			if (!m.isRoot()) {
				if (m.getIdMenuPadre() != null && m.getId() != 0) {
					if( addToParent(menuFiltrado, m)) {
						addToParent(listMenu, m);
					}
					
				}
			}
		}


		return menuFiltrado;
	}

	public static boolean addToParent(List<Menu> listMenu, Menu m) {
		boolean exist = false;
		for (Menu aux : listMenu) {
			if (m.getIdMenuPadre().equals(aux.getId())) {
				aux.getSubMenu().add(m);
				exist = true;
				break;
			}

		}
		return exist;
	}

}
