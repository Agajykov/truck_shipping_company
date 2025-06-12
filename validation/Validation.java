package validation;

import java.util.List;

import enums.City;
import tanks.Item;

public class Validation {


	public static City toCityEnum(String cityName) {
    try {
        return City.valueOf(cityName.trim().toUpperCase());
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid city name: " + cityName);
        return null;  // or throw your own exception
    }
}
	public static Item toItem(String inputName, List<Item> allItems) {
		for (Item item : allItems) {
			if (item.getName().equalsIgnoreCase(inputName.trim())) {
				return item;
			}
		}
		System.out.println("Invalid item name: " + inputName);
		return null; // or throw exception
	}
}
