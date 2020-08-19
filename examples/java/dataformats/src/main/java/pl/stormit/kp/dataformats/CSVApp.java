package pl.stormit.kp.dataformats;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.util.Arrays;

// Comma-separated values
public class CSVApp {
	public static void main(String[] args) throws JsonProcessingException {
		CsvMapper csvMapper = new CsvMapper();
		csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

		CsvSchema schema = CsvSchema.builder()
				.addColumn("name")
				.addColumn("attractions")
				.build();

		City city = new City("Gdańsk", new Country("Poland"), Arrays.asList("Sea", "Old city"));

		System.out.println(csvMapper.writer(schema).writeValueAsString(Arrays.asList(city, city)));
	}
}
