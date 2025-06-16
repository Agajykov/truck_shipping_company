package Tanker;

public class MediumTruck extends Truck {
	@Override
	public void printTruckInfo() {
		System.out.println("Truck Type: Medium");
		super.printTruckInfo();
	}

	@Override
	public void displayTruckInfo() {
		System.out.println("This Medium Size Truck is dedicated to shipp middle size volume elements");
	}
}
