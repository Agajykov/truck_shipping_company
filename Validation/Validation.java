package Validation;

import Enums.City;
import Exceptions.CityNotFoundException;
import Exceptions.ItemNotFoundException;
import Tanks.Item;
import java.util.List;

public class Validation {

	public static City checkIfCityExist(String cityName) throws CityNotFoundException {
    try {
        return City.valueOf(cityName.trim().toUpperCase());
    } catch (IllegalArgumentException e) {
        throw new CityNotFoundException("Invalid city name: " + cityName, e);
    }
}
	public static Item checkIfItemExist(String inputName, List<Item> allItems) throws ItemNotFoundException {
    for (Item item : allItems) {
        if (item.getName().equalsIgnoreCase(inputName.trim())) {
            return item;
        }
    }
    throw new ItemNotFoundException("Invalid item name: " + inputName);
}

}
