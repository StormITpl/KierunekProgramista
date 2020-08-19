package pl.stormit.kp.dataformats;

import java.io.Serializable;

public class Country implements Serializable {
	private String name;

	public Country() {
	}

	public Country(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country{" +
				"name='" + name + '\'' +
				'}';
	}
}
