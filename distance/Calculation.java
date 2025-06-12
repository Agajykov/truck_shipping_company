package distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import orders.Order;
import tanker.Truck;
import tanks.Item;

public class Calculation {

	// return cost/km
	public static final double returnPrice = 0.6;

	private List<Item> items = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();

	public Calculation() {

	}

	/**
	 * The size of the Truck container is assumed to be cylindrical in this program.
	 * 
	 * CylinderVolume = pi * r^2 * L
	 * 
	 * Computational unit is in meters
	 * 
	 * @return double
	 */
	public double totalVolume(Truck tanker) {

		double radiusMeter = tanker.getRadius();
		double lengthMeter = tanker.getLength();
		double volumeInCubicMeter = Math.PI * Math.pow(radiusMeter, 2) * lengthMeter;
		return volumeInCubicMeter;
	}

	public void addItem(Item... newItems) {
            this.items.addAll(Arrays.asList(newItems));
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}

	public List<Item> getItems() {
		return  this.items;
	}

	//double gallons, Item item, City city
	public double shippingPrice(Order order) {

		// Convert risk factor from percent to decimal (e.g., 17% → 0.17)
		double risk = order.getItemToBeShipped().getRiskFactor() / 100.0;

		// Base cost + risk surcharge
		double cost = order.getGallonAmmount() * 0.01 * (1 + risk) * order.getCityToShip().getDistance();

		// Return cost (empty truck)
		double returnCost = order.getCityToShip().getDistance() * returnPrice;

		return cost + returnCost;
	}

	public void printOrder() {
		for (Order order : this.orders) {
		order.getOrderReport();
		}
	}
}
