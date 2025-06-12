package tanks;

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
public class Item {

	public Item() {
		
	}

    private String name;
	private double riskFactor;
	private double densityPerGallon; // kg per gallon

    public void setName(String name) {
		this.name = name;
	}

	public void setRiskFactor(double riskFactor) {
		this.riskFactor = riskFactor;
	}

	public void setDensityPerGallon(double densityPerGallon) {
		this.densityPerGallon = densityPerGallon;
	}

    public double getRiskFactor() { return riskFactor; }
    public String getName() { return name; }
    public double getDensityPerGallon() { return densityPerGallon; }


	/**
	 * 1 US gallon = 3.78541 liters
	 * 1 liter = 0.001 cubic meters
	 * 
	 * 1 gallon = 3.78541 * 0.001 = 0.00378541 cubic meters
	 * @param gallons
	 * @return
	 */
    public double volumeInCubicMeters(double gallons) {
        return gallons * 0.00378541;
    }

    public void printItemInfo() {
        System.out.println("Item: " + name);
        System.out.println("Risk Factor: " + riskFactor);
        System.out.println("Density (kg/gal): " + densityPerGallon);
    }
}


