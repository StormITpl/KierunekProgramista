package pl.stormit.usermanager.client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonDto {

	private String name;

	public PersonDto() {
	}

	public PersonDto(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
