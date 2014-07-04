package RecommendEngine;

import java.util.ArrayList;

import Database.MenuItem;
import Database.Restaurant;
import Database.RestaurantCollection;
import Database.SubMenu;
import Parser.DataParser;

public class Engine {
	
	public static void main(String []args){
		//-type Vegetarian
		RestaurantCollection restaurantColl = new RestaurantCollection();
		DataParser dp = new DataParser();
		Restaurant res = dp.mimiCafe("http://www.mimiscafe.com");
		restaurantColl.addRestaurant(res);
		
		res = dp.iHOP("http://www.ihop.com");
		restaurantColl.addRestaurant(res);

		
		if(args != null && args[0].contains("-type") && !args[1].contains("vegetarian")){
			ArrayList<Restaurant> resList = restaurantColl.getRestaurantList();
			for(int k =0 ; k<resList.size() ; k++){
				res = resList.get(k);
				System.out.println("------"+res.getURL()+"------");
				ArrayList<SubMenu> sbList = res.getMainMenu().getSubMenuList();
				
				for(int i=0;i<sbList.size();i++){
					SubMenu sb = sbList.get(i);
					System.out.println("------"+sb.getName()+"------");
					ArrayList<MenuItem> mtList = sb.getMenuItemList();
					for(int j=0;j<mtList.size();j++){
						MenuItem m = mtList.get(j);
						if(m.isVeg()){
							System.out.println("Item-"+ j);
							System.out.println("NAME = "+ m.getName());
							System.out.println("DESC = "+m.getDescription());	
						}
					}
				}
			}
		}else{
			ArrayList<Restaurant> resList = restaurantColl.getRestaurantList();
			for(int k =0 ; k<resList.size() ; k++){
				res = resList.get(k);
				System.out.println("------"+res.getURL()+"------");
				ArrayList<SubMenu> sbList = res.getMainMenu().getSubMenuList();
				
				for(int i=0;i<sbList.size();i++){
					SubMenu sb = sbList.get(i);
					System.out.println("------"+sb.getName()+"------");
					ArrayList<MenuItem> mtList = sb.getMenuItemList();
					for(int j=0;j<mtList.size();j++){
						MenuItem m = mtList.get(j);
						System.out.println("Item-"+ j);
						System.out.println("NAME = "+ m.getName());
						System.out.println("DESC = "+m.getDescription());
						System.out.println("VEG = " + m.isVeg());
					}
				}
			}	
		}	
	}
}
