package Tanker;

public class LargeTruck extends Truck {

	@Override
	public void printTruckInfo() {
		System.out.println("Truck Type: Large");
		super.printTruckInfo();
	}

	@Override
	public void displayTruckDescription() {
		System.out.println("This Large Truck is dedicated to transport Large ammount of shipments");
	}
	
}
