package pl.stormit.kp.oop;

import pl.stormit.kp.oop.attraction.Attraction;
import pl.stormit.kp.oop.attraction.location.City;
import pl.stormit.kp.oop.attraction.location.Country;
import pl.stormit.kp.oop.attraction.location.Region;

import java.util.ArrayList;
import java.util.List;

public class AttractionsApp {
	public static void main(String[] args) {
		List<Attraction> attractions = new ArrayList<>();

		Country poland = new Country("Poland");
		Region region = new Region("Pomorskie", poland);
		City city = new City("Gdańsk", region);

		Attraction sea = new Attraction("Sea", city);
	}
}
