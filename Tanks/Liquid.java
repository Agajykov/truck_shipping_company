package Tanks;


/**
 * Benzene: Super E95
 * Benzene: Super
 * Water 
 * Milk
 */
public class Liquid extends Item {
	private String typeOfItem = "Liquid";
	public Liquid(String name, double riskFactor, double densityPerGallon) {
		super(name, riskFactor, densityPerGallon);
	}
	
	@Override
	public String typeOfItem() {
		return this.typeOfItem;
	}
    


}
