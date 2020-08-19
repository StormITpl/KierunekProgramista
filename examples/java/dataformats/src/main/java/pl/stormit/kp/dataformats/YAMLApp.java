package pl.stormit.kp.dataformats;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Arrays;

// YAML Ain't Markup Language
// Yet Another Markup Language
public class YAMLApp {
	public static void main(String[] args) throws JsonProcessingException {
		YAMLMapper yamlMapper = new YAMLMapper();
		City city = new City("Gdańsk", new Country("Poland"), Arrays.asList("Sea", "Old city"));

		System.out.println(yamlMapper.writeValueAsString(city));

		String json = "name: \"Gdańsk\"\n" +
				"country:\n" +
				"  name: \"Poland\"\n" +
				"attractions:\n" +
				"- \"Sea\"\n" +
				"- \"Old city\" ";

		City cityFromYaml = yamlMapper.readValue(json, City.class);

		System.out.println(cityFromYaml);

	}
}
