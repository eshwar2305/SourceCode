package Database;
import java.util.ArrayList;

import javax.swing.event.MenuListener;


public class SubMenu {
	String name;
	ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	
	public void addMenuItem(MenuItem mn){
		menuItemList.add(mn);
	}
}
