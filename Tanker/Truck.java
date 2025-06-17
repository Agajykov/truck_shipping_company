package Tanker;

public abstract class Truck {
	private String name;
    private double length;
	private double radius;
	private double volumeInCubicMeter;
	private double maxWeight;

	// Constructor
    public Truck(String name, double length, double radius, double maxWeight) {
        this.name = name;
        this.length = length;
        this.radius = radius;
        this.maxWeight = maxWeight;
        calculateVolume();  // Always update volume
    }
	

	public abstract void displayTruckDescription();
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
    public double getMaxWeight() {
		return maxWeight;
	}
	
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public double getTruckVolumeInCubicMeter() {
		calculateVolume();
		return this.volumeInCubicMeter;
	}
	
	public void calculateVolume() {
		double volume = Math.PI * Math.pow(this.radius, 2) * this.length;
		this.volumeInCubicMeter = volume;
	}

	public void printTruckInfo() {
        System.out.printf("Truck length: %.1f m \n", length);
		System.out.printf("Truck Radius: %.1f m \n", radius);
        System.out.printf("Volume in cubic meters: %.2f m³\n", getTruckVolumeInCubicMeter());
    }

}