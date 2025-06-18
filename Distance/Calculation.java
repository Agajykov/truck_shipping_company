package Distance;

import Orders.Order;
import Tanker.Truck;
import Tanks.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Enums.City;

public class Calculation {

	// return cost/km
	private static final double RETURN_COST_PER_KM = 0.6;
	
	public Calculation() { }
	
	private List<Item> items = new ArrayList<>();
	private List<Truck> availableTrucks = new ArrayList<>();

	public void addItem(Item... newItems) {
		this.items.addAll(Arrays.asList(newItems));
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void addTruck(Truck... newTrucks) {
		this.availableTrucks.addAll(Arrays.asList(newTrucks));
	}

	public List<Truck> getAvailableTrucks() {
		return this.availableTrucks;
	}

	public List<Truck> findBestShipping(Item itemToBeShipped, City city ) {

		double itemRemainingVolume = itemToBeShipped.getVolumeInCubicMeter();
		double itemRemainingWeight = itemToBeShipped.getWeightOfItemInKg();

		List<Truck> chosenTrucks = new ArrayList<>();

		// Sort trucks: bigger volume first
		availableTrucks.sort((a, b) -> 
			Double.compare(b.getTruckVolumeInCubicMeter(), a.getTruckVolumeInCubicMeter()));

		System.out.println("\nTruck Distribution Plan for Order to " + city + ":");

		for (Truck truck : availableTrucks) {
			double truckVolume = truck.getTruckVolumeInCubicMeter();
			double truckWeight = truck.getMaxWeight();
			int count = 0;

			// Use this truck repeatedly as long as there's item left
			while ((itemRemainingVolume >= 0.0001 && itemRemainingVolume >= truckVolume * 0.9) ||
				(itemRemainingWeight >= 0.0001 && itemRemainingWeight >= truckWeight * 0.9)) {

				// Remove volume & weight used
				itemRemainingVolume -= Math.min(truckVolume, itemRemainingVolume);
				itemRemainingWeight -= Math.min(truckWeight, itemRemainingWeight);
				count++;

				// Add truck used to chosenTrucks list
				chosenTrucks.add(truck);
			}

			if (count > 0) {
				System.out.printf("%d x %s (%.2f m³, %.0f kg)\n", 
					count, truck.getName(), truckVolume, truckWeight);
			}
		}

		// If remaining item left, warn the user
		if (itemRemainingVolume > 0.01 || itemRemainingWeight > 0.01) {
			System.out.printf("Remaining: %.2f m³, %.2f kg (Not fully allocated!)\n", 
				itemRemainingVolume, itemRemainingWeight);
		} 
		else {
			System.out.println("All cargo allocated successfully.");
		}

		return chosenTrucks;
	}


	public double totalVolumeOfTruck(Truck tanker) {
		for (Truck truck : this.availableTrucks)
			if (tanker.getName().equals(truck.getName())) {
				return tanker.getTruckVolumeInCubicMeter();
			}
		return 0;
	}

	public double totalWeighteOfTruck(Truck tanker) {
		for (Truck truck : this.availableTrucks)
			if (tanker.getName().equals(truck.getName())) {
				return tanker.getMaxWeight();
			}
		return 0;
	}

	
	public double shippingPrice(int gallonAmmount, Item itemToBeShipped, City city) {

		// Convert risk factor from percent to decimal (e.g., 17% → 0.17)
		double risk = itemToBeShipped.getRiskFactor() / 100.0;

		// Base cost + risk surcharge
		double cost = gallonAmmount * 0.01 * (1 + risk) * city.getDistance();

		// Return cost (empty truck)
		double returnCost = city.getDistance() * RETURN_COST_PER_KM;

		return cost + returnCost;
	}
}
