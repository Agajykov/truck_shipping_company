package Tanker;

public class MediumTruck extends Truck {

	public MediumTruck(String name, double length, double radius, double maxWeight) {
		super(name, length, radius, maxWeight);
	}

	@Override
	public void printTruckInfo() {
		System.out.println("Truck Type: Medium");
		super.printTruckInfo();
	}

	@Override
	public void displayTruckDescription() {
		System.out.println("This Medium Size Truck is dedicated to shipp middle size volume elements");
	}
}
