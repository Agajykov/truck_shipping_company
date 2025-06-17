package Tanks;

/**
 * Represents an item (usually a liquid or gas) that can be transported by a tanker truck.
 * This class contains key properties such as the name of the item, its risk factor for transport,
 * and its density per gallon.
 * <p>
 * It also provides utility methods to:
 * - Convert volume from gallons to cubic meters
 * - Print item details
 * </p>
 * 
 * These are gas type:
 * 
 * Oxygen,
 * Hydrogen
 * Nitrogen
 * Propene
 * Carbon Dioxide
 * Methane
 *
 * @author Avdyrahman Agajykov
 */
public abstract class Item {
	
	// Conversion factor from US gallons to cubic meter.
	private static final double CONVERSION_FACTOR = 0.00378541;
	
	private String name;
	private double riskFactor;
	private double densityPerGallon; // kg per gallon
	private double volumeInCubicMeter;
	private double gallons;
	private double weightOfItemInKg;
	

	public abstract String typeOfItem();

	public Item(String name, double riskFactor, double densityPerGallon) {
		this.name = name;
		this.riskFactor = riskFactor;
		this.densityPerGallon = densityPerGallon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setRiskFactor(double riskFactor) {
		this.riskFactor = riskFactor;
	}

	public double getRiskFactor() {
		return riskFactor;
	}

	public void setDensityPerGallon(double densityPerGallon) {
		this.densityPerGallon = densityPerGallon;
	}

	public double getDensityPerGallon() {
		return densityPerGallon;
	}


	public void setGallons(double gallons) {
		this.gallons = gallons;
		calculateVolumeInCubicMeters();
	}
	
	/**
	 * 1 US gallon = 3.78541 liters
	 * 1 liter = 0.001 cubic meters
	 * 
	 * 1 gallon = 3.78541 * 0.001 = 0.00378541 cubic meters
	 * @param gallons
	 * @return
	 */
	public void calculateVolumeInCubicMeters() {
		this.volumeInCubicMeter = this.gallons * CONVERSION_FACTOR;
	}
	
	public double getVolumeInCubicMeter() {
		return this.volumeInCubicMeter;
	}
	
	public void calculateWeightOfItem() {
		this.weightOfItemInKg  = this.gallons * this.densityPerGallon;
	}

	public double getWeightOfItemInKg() {
		calculateWeightOfItem();	
		return this.weightOfItemInKg;
	}

	public void printItemInfo() {
	System.out.println("Item: " + name);
	System.out.println("Material of Item:" + typeOfItem());
	System.out.println("Risk Factor: " + riskFactor);
	System.out.println("Density (kg/gal): " + densityPerGallon);
	System.out.println("Gallons: " + gallons);
	System.out.println("Volume (m^3): " + getVolumeInCubicMeter());
	System.out.println("Weight (kg): " + getWeightOfItemInKg());
	}
}


