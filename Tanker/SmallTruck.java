package Tanker;

public class SmallTruck extends Truck {

	public SmallTruck(String name, double length, double radius, double maxWeight) {
		super(name, length, radius, maxWeight);
		//TODO Auto-generated constructor stub
	}

	@Override
	public void printTruckInfo() {
		System.out.println("Truck Type: Small");
		super.printTruckInfo();
	}

	@Override
	public void displayTruckDescription() {
		System.out.println("This Small Size Truck is dedicated to shipp small size volume elements");
	}
}
