package orders;

import enums.City;
import tanks.Item;

public class Order {

	private City cityToShip; 
	private int gallonAmmount;
	private Item itemToBeShipped;
	
	public Order(int gallonAmmount, Item item, City city) {
		this.itemToBeShipped = item;
		this.cityToShip = city;
	}
	
	public int getGallonAmmount() {
		return gallonAmmount;
	}

	public City getCityToShip() {
		return cityToShip;
	}

	public Item getItemToBeShipped() {
		return itemToBeShipped;
	}
	
	//"3200 gallons of Oxygen to be shipped from Hamburg to Berlin"
	public void getOrderReport() {
		System.out.printf("%d gallons of %s is to be shipped from %s to %s ", this.gallonAmmount, itemToBeShipped.getName() , this.cityToShip, this.cityToShip );
	}

}
