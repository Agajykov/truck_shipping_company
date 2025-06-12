package validation;

import Exceptions.CityNotFoundException;
import Exceptions.ItemNotFoundException;
import enums.City;
import java.util.List;
import tanks.Item;

public class Validation {

	public static City toCityEnum(String cityName) throws CityNotFoundException {
    try {
        return City.valueOf(cityName.trim().toUpperCase());
    } catch (IllegalArgumentException e) {
        throw new CityNotFoundException("Invalid city name: " + cityName, e);
    }
}
	public static Item toItem(String inputName, List<Item> allItems) throws ItemNotFoundException {
    for (Item item : allItems) {
        if (item.getName().equalsIgnoreCase(inputName.trim())) {
            return item;
        }
    }
    throw new ItemNotFoundException("Invalid item name: " + inputName);
}

}
