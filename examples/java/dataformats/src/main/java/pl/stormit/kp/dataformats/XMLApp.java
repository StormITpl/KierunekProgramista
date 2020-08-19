package pl.stormit.kp.dataformats;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.Arrays;

// Extensible Markup Language
public class XMLApp {
	public static void main(String[] args) throws JsonProcessingException {
		XmlMapper xmlMapper = new XmlMapper();
		City city = new City("Gdańsk", new Country("Poland"), Arrays.asList("Sea", "Old city"));

		System.out.println(xmlMapper.writeValueAsString(city));

		String json = "<City><name>Gdańsk</name><country><name>Poland</name></country><attractions><attractions>Sea</attractions><attractions>Old city</attractions></attractions></City>";

		City cityFromXML = xmlMapper.readValue(json, City.class);

		System.out.println(cityFromXML);

	}
}
