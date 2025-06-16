package Distance;

import Orders.Order;
import Tanker.Truck;
import Tanks.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculation {

	// return cost/km
	private static final double RETURN_COST_PER_KM = 0.6;

	private List<Item> items = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	private List<Truck> availableTrucks = new ArrayList<>();

	public Calculation() {
		
	}

	public void addItem(Item... newItems) {
			this.items.addAll(Arrays.asList(newItems));
	}

	public void addTruck(Truck... newTrucks) {
			this.availableTrucks.addAll(Arrays.asList(newTrucks));
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
	public double totalVolumeOfTruck(Truck tanker) {

		double radiusMeter = tanker.getRadius();
		double lengthMeter = tanker.getLength();
		double volumeInCubicMeter = Math.PI * Math.pow(radiusMeter, 2) * lengthMeter;
		return volumeInCubicMeter;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}

	public List<Item> getItems() {
		return  this.items;
	}

	public void findBestTruckCombo() {
		double itemTotalVolume;
		double itemTotalWeight;

		double truckVolume;
		double truckWeight;
		
		for (Order order : orders) {
			itemTotalVolume = order.getItemToBeShipped().getVolumeInCubicMeter();
			itemTotalWeight = order.getItemToBeShipped().getDensityPerGallon() * order.getGallonAmmount();
		}
		
		for (Truck truck : availableTrucks) {
			truckVolume = truck.getTruckVolumeInCubicMeter();
			truckWeight = truck.getMaxWeight();
		}
		
		
		while ()
		
		// for (Order order : this.orders) {

		// 	double itemTotalVolume = order.getItemToBeShipped().getVolumeInCubicMeter();
		// 	double itemTotalWeight = order.getItemToBeShipped().getDensityPerGallon() * order.getGallonAmmount();

		// 	availableTrucks.forEach(Truck::calculateVolume);

		// 	availableTrucks.sort((a, b) ->
		// 		Double.compare(b.getTruckVolumeInCubicMeter(), a.getTruckVolumeInCubicMeter()));

		// 	System.out.println("\nTruck Distribution Plan:");
		// 	double itemRemainingVolume = itemTotalVolume;
		// 	double itemRemainingWeight = itemTotalWeight;

		// 	for (Truck truck : availableTrucks) {
		// 		double truckVolume = truck.getTruckVolumeInCubicMeter();
		// 		double truckWeight = truck.getMaxWeight();
		// 		int count = 0;

		// 		// Use truck repeatedly as long as there's space/weight need
		// 		while (itemRemainingVolume >= truckVolume || itemRemainingWeight >= truckWeight) {
		// 			itemRemainingVolume -= Math.min(truckVolume, itemRemainingVolume);
		// 			itemRemainingWeight -= Math.min(truckWeight, itemRemainingWeight);
		// 			count++;

		// 			// Add a copy of the truck or reference to the truck
		// 			order.getTrucksUsed().add(truck);
		// 		}

		// 		if (count > 0) {
		// 			System.out.printf("%d x %s (%.2f m³, %.0f kg)\n", count, truck.getName(), truckVolume, truckWeight);
		// 		}
		// 	}

		// 	if (itemRemainingVolume > 0 || itemRemainingWeight > 0) {
		// 		System.out.printf("Remaining Volume: %.2f m³, Remaining Weight: %.2f kg\n", itemRemainingVolume, itemRemainingWeight);
		// 	} 
		// 	else {
		// 		System.out.println("All cargo allocated successfully.");
		// 	}
		// }
	}

	/**
	 * Calculates the total shipping price for an order, including both
	 * the cost of delivering the item and the cost of returning the truck empty.
	 * <p>
	 * The shipping price is based on:
	 * <ul>
	 *   <li>The number of gallons to be shipped</li>
	 *   <li>The risk factor of the item (as a percentage, e.g., 17%)</li>
	 *   <li>The distance to the destination city</li>
	 *   <li>A fixed cost for the return journey (empty truck)</li>
	 * </ul>
	 *
	 * The cost is computed as:
	 * <pre>
	 * cost = gallons * 0.01 * (1 + riskFactor) * distance
	 * returnCost = distance * RETURN_COST_PER_KM
	 * total = cost + returnCost
	 * </pre>
	 *
	 * @param order the order containing shipment details including the item,
	 *              destination city, and amount in gallons
	 * @return the total shipping price for the order (as a double)
	 */
	public double shippingPrice(Order order) {

		// Convert risk factor from percent to decimal (e.g., 17% → 0.17)
		double risk = order.getItemToBeShipped().getRiskFactor() / 100.0;

		// Base cost + risk surcharge
		double cost = order.getGallonAmmount() * 0.01 * (1 + risk) * order.getCityToShip().getDistance();

		// Return cost (empty truck)
		double returnCost = order.getCityToShip().getDistance() * RETURN_COST_PER_KM;

		return cost + returnCost;
	}

	/**
	 * Prints the report for each order in the current list of orders.
	 * <p>
	 * This method iterates through all stored orders and calls their
	 * {@code getOrderReport()} method to display relevant shipping information.
	 * </p>
	 *
	 * <p><b>Note:</b> It assumes that each {@code Order} object has a working
	 * {@code getOrderReport()} method that handles its own output logic.</p>
	 */
	public void printOrder() {
		for (Order order : this.orders) {
		order.getOrderReport();
		}
	}
}
