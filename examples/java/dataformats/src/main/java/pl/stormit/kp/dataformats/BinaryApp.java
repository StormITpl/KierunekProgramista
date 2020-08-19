package pl.stormit.kp.dataformats;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Base64;

public class BinaryApp {
	public static void main(String[] args) {
		City city = new City("Gdańsk", new Country("Poland"), Arrays.asList("Sea", "Old city"));

		ObjectMapper objectMapper = new ObjectMapper();

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
		     ObjectOutputStream oos = new ObjectOutputStream(baos)) {

			oos.writeObject(city);

			System.out.println("Binary => " + new String(baos.toByteArray()));

			String base64 = Base64.getEncoder().encodeToString(baos.toByteArray());
			System.out.println("Base64 => " + base64);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
