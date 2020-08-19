package pl.stormit.kp.oop.attraction.location;

import pl.stormit.kp.oop.attraction.Attraction;

import java.util.ArrayList;
import java.util.List;

public abstract class Location {
	private String name;

	private List<Attraction> attractions = new ArrayList<>();

	public Location(String name) {
		this.name = name;
	}

	public void addAttraction(Attraction attraction){
		attractions.add(attraction);
	}
}
