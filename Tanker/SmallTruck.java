package Tanker;

public class SmallTruck extends Truck {
	@Override
	public void printTruckInfo() {
		System.out.println("Truck Type: Small");
		super.printTruckInfo();
	}

	@Override
	public void displayTruckInfo() {
		System.out.println("This Small Size Truck is dedicated to shipp small size volume elements");
	}
}
