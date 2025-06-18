package Orders;

import java.util.ArrayList;
import java.util.List;

import Distance.Calculation;
import Enums.City;
import Tanker.Truck;
import Tanks.Item;

public class OrderService {
    private Calculation calculation;
    private List<Order> orders;

    public OrderService(Calculation calculation) {
        this.calculation = calculation;
        this.orders = new ArrayList<>();
    }

    public void createOrder(int gallons, Item item, City city) {

        double cost = calculation.shippingPrice(gallons, item, city);
        
		List<Truck> trucks = calculation.findBestShipping(item, city);
        
		Order order = new Order(gallons, item, city, cost, trucks);
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
