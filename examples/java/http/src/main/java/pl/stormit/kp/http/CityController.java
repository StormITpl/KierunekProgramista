package pl.stormit.kp.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(
		value = "/cities",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
)
public class CityController {

	private List<City> cities = new ArrayList<>();


	// localhost:8080/cities
	@GetMapping
	public List<City> getCities() {
		return cities;
	}

	@GetMapping("{id}")
	public City getCity(@PathVariable("id") int id) {
		City city = cities.stream()
				.filter(c -> c.getId() == id)
				.findAny()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found"));

		return city;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public City addCity(@RequestBody City city) {
		cities.add(city);
		return city;
	}

	@PutMapping("{id}")
	public City updateCity(@PathVariable("id") int id, @RequestBody City city) {
		City localCity = cities.stream()
				.filter(c -> c.getId() == id)
				.findAny()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found"));

		localCity.setName(city.getName());

		return localCity;
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCity(@PathVariable("id") int id) {
		City city = cities.stream()
				.filter(c -> c.getId() == id)
				.findAny()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found"));

		cities.remove(city);
	}

	@GetMapping("redirect")
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	public void redirect() {
	}

	@GetMapping("error")
	public void error() {
		String a = null;
		a.toString();
	}
}
