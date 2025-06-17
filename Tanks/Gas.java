package Tanks;

public class Gas extends Item {
	private String typeOfItem = "Gas";
	
	public Gas(String name, double riskFactor, double densityPerGallon) {
		super(name, riskFactor, densityPerGallon);
	}

	@Override
	public String typeOfItem() {
		return typeOfItem;	
	}
	
}
