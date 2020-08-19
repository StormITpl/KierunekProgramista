package pl.stormit.kp.oop.attraction.location;

public class City extends Location {

	private Region region;

	public City(String name, Region region) {
		super(name);
		this.region = region;
	}

	public void display() {
		System.out.println(this);
	}
}
