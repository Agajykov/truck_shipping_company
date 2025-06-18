import Distance.Calculation;
import Enums.City;
import Exceptions.CityNotFoundException;
import Exceptions.ItemNotFoundException;
import Orders.Order;
import Orders.OrderService;
import Tanker.LargeTruck;
import Tanker.MediumTruck;
import Tanker.SmallTruck;
import Tanker.Truck;
import Tanks.Gas;
import Tanks.Item;
import Tanks.Liquid;
import Validation.Validation;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        // Liqud Items
        Item benzeneSuperE95 = new Liquid("Benzene Super E95", 20, 3.1);
		Item benzeneSuper = new Liquid("Benzene Super", 20, 3.1);
		Item water = new Liquid("Water", 0, 8.34);
		Item milk = new Liquid("Milk", 0, 8.6);

		// Gas Items
		Item oxygen = new Gas("Oxygen", 17, 1.14);	
		Item hydrogen = new Gas("Hydrogen", 18, 0.07);
		Item nitrogen = new Gas("Nitrogen", 2, 0.81);
		Item propene = new Gas("Propene",20, 2.3);
		Item carbonDioxide = new Gas("Carbon Dioxide", 10, 1.5);
		Item methane = new Gas("Methane", 18, 0.42);
		//Setters and getters are there incase if you want to add more Items
		
        // Trucks
        Truck smallTruck = new SmallTruck("Small", 5, 0.8, 5000);
        Truck mediumTruck = new MediumTruck("Medium", 8, 1.2, 10000);
        Truck largeTruck = new LargeTruck("Large", 12, 1.6, 20000);
		//Setters and getters are there incase if you want to add more Trucks

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

		OrderService orderService = new OrderService(calc);	
		
		Scanner scanner = new Scanner(System.in);

		boolean isOrderComplete = false;

		while (!isOrderComplete) {

			System.out.print("Provide amount of gallons: ");
			int gallonAmount = Integer.parseInt(scanner.nextLine());

			System.out.print("Provide Item to be shipped: ");
			String desiredItemToShip = scanner.nextLine().trim();

			System.out.print("Provide destination City: ");
			String destinationCity = scanner.nextLine().trim();
		
			try {

				Item itemToBeShipped = Validation.checkIfItemExistsInStock(desiredItemToShip, calc.getItems());
				City city = Validation.checkIfCityExist(destinationCity);

				orderService.createOrder(gallonAmount, itemToBeShipped, city);
			} 
			catch (ItemNotFoundException | CityNotFoundException e) {
				System.err.println(e.getMessage());
				continue; // skip this order and ask again
			}

			System.out.print("Do you want to finish ordering? (yes/no): ");
			String response = scanner.nextLine().trim().toLowerCase();
			isOrderComplete = response.equals("yes") || response.equals("y");
		}

		orderService.getOrders().forEach(Order::getOrderReport);
    }
}