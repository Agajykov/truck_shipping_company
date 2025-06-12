package tanker;

public class Truck {

    private int length;
	private double radius;
	private double volumeInCubicMeter;
	
	public void updateVolume() {
		this.volumeInCubicMeter = Math.PI * Math.pow(this.radius, 2) * this.length;
	}
    
	public double getVolumeInCubicMeter() {
		return this.volumeInCubicMeter;
	}


	public int getLength() {
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

    public void printTruckInfo() {
        System.out.println("Truck length:" + length + "\n Truck Radius:" + radius );
        System.out.println("Volume in gallons: " + getVolumeInCubicMeter());
    }

}