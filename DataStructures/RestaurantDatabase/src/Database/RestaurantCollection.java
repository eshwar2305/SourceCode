package Database;

import java.util.ArrayList;

public class RestaurantCollection {
	ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();

	public ArrayList<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(ArrayList<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}
	
	public void addRestaurant(Restaurant res){
		this.restaurantList.add(res);
	}
	
}
