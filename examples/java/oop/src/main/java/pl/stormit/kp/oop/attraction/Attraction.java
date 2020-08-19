package pl.stormit.kp.oop.attraction;

import pl.stormit.kp.oop.attraction.location.City;

public class Attraction {

	private String name;

	private City city;

	public Attraction(String name, City city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{" +
				"name='" + name + '\'' +
				'}';
	}
}
