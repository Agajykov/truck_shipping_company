package validation;

import enums.City;
import exceptions.ValidationException;
import java.util.List;
import tanks.Item;

/**
 * Utility class for validating and converting input values.
 */
public class Validation {

    /**
     * Converts a city name string to the corresponding {@link City} enum.
     *
     * @param cityName the name of the city as a string
     * @return the corresponding {@link City} enum if valid
     * @throws ValidationException if the city name is invalid
     */
    public static City toCityEnum(String cityName) throws ValidationException {
        try {
            return City.valueOf(cityName.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Invalid city name: " + cityName);
        }
    }

    /**
     * Finds and returns an {@link Item} from the given list that matches the input name.
     *
     * @param inputName the name of the item to find
     * @param allItems the list of {@link Item} objects to search
     * @return the matching {@link Item} if found
     * @throws ValidationException if no matching item is found
     */
    public static Item toItem(String inputName, List<Item> allItems) throws ValidationException {
        for (Item item : allItems) {
            if (item.getName().equalsIgnoreCase(inputName.trim())) {
                return item;
            }
        }
        throw new ValidationException("Invalid item name: " + inputName);
    }
}
