import distance.Calculation;
import enums.City;
import java.util.Scanner;
import orders.Order;
import tanker.Truck;
import tanks.Item;
import tanks.Liquid;
import validation.Validation;


public class Main {
    public static void main(String[] args) {
        
        // Liqud Items
        Item benzeneSuperE95 = new Liquid();
		benzeneSuperE95.setName("Benzene Super E95");
		benzeneSuperE95.setRiskFactor(20);
		benzeneSuperE95.setDensityPerGallon(3.1);

		Item benzeneSuper = new Liquid();
		benzeneSuper.setName("Benzene Super");
		benzeneSuper.setRiskFactor(20);
		benzeneSuper.setDensityPerGallon(3.1);
		
		Item water = new Liquid();
		water.setName("Water");
		water.setRiskFactor(0);
		water.setDensityPerGallon(8.34);

		Item milk = new Liquid();
		milk.setName("Milk");
		milk.setRiskFactor(0);
		milk.setDensityPerGallon(8.6);

		// Gas Items
		Item oxygen = new Item();
		oxygen.setName("Oxygen");
		oxygen.setRiskFactor(17);
		oxygen.setDensityPerGallon(1.14);

		Item hydrogen = new Item();
		hydrogen.setName("Hydrogen");
		hydrogen.setRiskFactor(18);
		hydrogen.setDensityPerGallon(0.07);

		Item nitrogen = new Item();
		nitrogen.setName("Nitrogen");
		nitrogen.setRiskFactor(2);
		nitrogen.setDensityPerGallon(0.81);

		Item propene = new Item();
		propene.setName("Propene");
		propene.setRiskFactor(20);
		propene.setDensityPerGallon(2.3);

		Item carbonDioxide = new Item();
		carbonDioxide.setName("Carbon Dioxide");
		carbonDioxide.setRiskFactor(10);
		carbonDioxide.setDensityPerGallon(1.5);

		Item methane = new Item();
		methane.setName("Methane");
		methane.setRiskFactor(18);
		methane.setDensityPerGallon(0.42);

        // Trucks
        Truck smallTruck = new Truck();
		smallTruck.setLength(5);
		smallTruck.setRadius(0.8);
		
        Truck mediumTruck = new Truck();
		mediumTruck.setLength(8);
		mediumTruck.setRadius(1.2);

        Truck largeTruck = new Truck();
		largeTruck.setLength(12);
		largeTruck.setRadius(1.6);

        // Calculation
        Calculation calc = new Calculation();
		
        calc.addItem(
			benzeneSuperE95,
			benzeneSuper,
			water,
			milk,
			oxygen,
			hydrogen,
			nitrogen,
			propene,
			carbonDioxide,
			methane
			);
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Provide ammount of gallons:");
		final int gallonAmmount = scanner.nextInt();

		System.out.println("Provide Item to be shipped:");
		final String item = scanner.nextLine();
		
		Item itemToBeShipped = Validation.toItem(item, calc.getItems());
		
		System.out.println("Provide destination City:");
		final String destinationCity = scanner.nextLine();
		City city = Validation.toCityEnum(destinationCity);

		Order order = new Order(gallonAmmount, itemToBeShipped, city);

		calc.addOrder(order);
        

        // Print example cost
        double cost = calc.shippingPrice(order);
		calc.printOrder();
        System.out.println("Shipping Cost: " + cost + " Euros");
    }
}