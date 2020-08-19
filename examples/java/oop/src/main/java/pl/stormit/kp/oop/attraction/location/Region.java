package pl.stormit.kp.oop.attraction.location;

public class Region extends Location {

	private Country country;

	public Region(String name, Country country) {
		super(name);
		this.country = country;
	}
}
