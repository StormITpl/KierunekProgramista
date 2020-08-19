package pl.stormit.kp.dataformats;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

// JavaScript Object Notation
public class JSONApp {
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		City city = new City("Gdańsk", new Country("Poland"), Arrays.asList("Sea", "Old city"));

		System.out.println(objectMapper.writeValueAsString(city));

		String json = "{\"name\":\"Gdańsk\",\"country\":{\"name\":\"Poland\"},\"attractions\":[\"Sea\",\"Old city\"]}";

		City cityFromJson = objectMapper.readValue(json, City.class);

		System.out.println(cityFromJson);

	}
}
