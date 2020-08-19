package pl.stormit.kp.dataformats;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {

	private String name;

	private Country country;

	private List<String> attractions;

	public City() {
	}

	public City(String name, Country country, List<String> attractions) {
		this.name = name;
		this.country = country;
		this.attractions = attractions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<String> getAttractions() {
		return attractions;
	}

	public void setAttractions(List<String> attractions) {
		this.attractions = attractions;
	}

	@Override
	public String toString() {
		return "City{" +
				"name='" + name + '\'' +
				", country='" + country + '\'' +
				", attractions=" + attractions +
				'}';
	}
}
