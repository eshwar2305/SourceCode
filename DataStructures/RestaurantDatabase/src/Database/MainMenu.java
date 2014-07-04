package Database;
import java.util.ArrayList;


public class MainMenu {
	ArrayList<SubMenu> subMenuList = new ArrayList<SubMenu>();

	public ArrayList<SubMenu> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(ArrayList<SubMenu> subMenuList) {
		this.subMenuList = subMenuList;
	}
	
	public void addSubMenu(SubMenu sb){
		subMenuList.add(sb);
	}
}
