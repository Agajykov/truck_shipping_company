import Distance.Calculation;
import Enums.City;
import Exceptions.CityNotFoundException;
import Exceptions.ItemNotFoundException;
import Orders.Order;
import Tanker.LargeTruck;
import Tanker.MediumTruck;
import Tanker.SmallTruck;
import Tanker.Truck;
import Tanks.Item;
import Tanks.Liquid;
import Validation.Validation;
import java.util.Scanner;


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
        Truck smallTruck = new SmallTruck();
		smallTruck.setName("Small");
		smallTruck.setLength(5);
		smallTruck.setRadius(0.8);
		smallTruck.setMaxWeight(5000);
		
        Truck mediumTruck = new MediumTruck();
		mediumTruck.setName("Medium");
		mediumTruck.setLength(8);
		mediumTruck.setRadius(1.2);
		mediumTruck.setMaxWeight(10000);

        Truck largeTruck = new LargeTruck();
		largeTruck.setName("Large");
		largeTruck.setLength(12);
		largeTruck.setRadius(1.6);
		largeTruck.setMaxWeight(20000);

        // Calculation
        Calculation calc = new Calculation();

		calc.addTruck(smallTruck, mediumTruck, largeTruck);
		
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

		boolean isOrderComplete = false;

		while (!isOrderComplete) {
			System.out.print("Provide amount of gallons: ");
			int gallonAmount = Integer.parseInt(scanner.nextLine());

			System.out.print("Provide Item to be shipped: ");
			String itemName = scanner.nextLine().trim();

			System.out.print("Provide destination City: ");
			String destinationCity = scanner.nextLine().trim();

			Item itemToBeShipped;
			try {
				itemToBeShipped = Validation.checkIfItemExist(itemName, calc.getItems());
			} 
			catch (ItemNotFoundException e) {
				System.err.println(e.getMessage());
				continue; // skip this order and ask again
			}

			City city;
			try {
				city = Validation.checkIfCityExist(destinationCity);
			} 
			catch (CityNotFoundException e) {
				System.err.println(e.getMessage());
				continue;
			}

			Order order = new Order(gallonAmount, itemToBeShipped, city);
			calc.addOrder(order);

			double cost = calc.shippingPrice(order);
			order.setShipmentCost(cost);
			System.out.printf("Shipping Cost:%.2f€ \n",order.getShipmentCost());
			double itemVolume = order.getItemToBeShipped().getVolumeInCubicMeter();
			double itemWeight = order.getItemToBeShipped().getWeightOfItemInKg();
			System.out.printf("Volume of item:%.2f m³ \n", itemVolume);
			System.out.printf("Weight of item:%.2f kg \n", itemWeight);

			System.out.print("Do you want to finish ordering? (yes/no): ");
			String response = scanner.nextLine().trim().toLowerCase();
			isOrderComplete = response.equals("yes") || response.equals("y");
		}
		calc.printOrder();
		calc.findBestTruckCombo();
		
	// FIXME: 
    }
}