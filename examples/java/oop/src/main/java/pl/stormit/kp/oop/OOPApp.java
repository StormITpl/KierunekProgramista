package pl.stormit.kp.oop;

import pl.stormit.kp.oop.attraction.Attraction;
import pl.stormit.kp.oop.attraction.location.City;
import pl.stormit.kp.oop.attraction.location.Country;
import pl.stormit.kp.oop.attraction.location.Region;

public class OOPApp {

	public static void main(String[] args) {
		Country country = new Country("Poland");
		Region region = new Region("Pomorskie", country);
		City city = new City("Gdańsk", region);
		Attraction attraction = new Attraction("Sea", city);

		city.addAttraction(attraction);

		city.display();
	}
}
