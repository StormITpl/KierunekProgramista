package pl.stormit.restservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class PersonController {

	private List<Person> persons;

	@PostConstruct
	void init() {
		persons = Arrays.asList(
				new Person("Tomek"),
				new Person("Magda"),
				new Person("Łucja"),
				new Person("Marek")
		);
	}

	@RequestMapping("/persons")
	public List<Person> index() {
		Collections.shuffle(persons);

		return persons;
	}
}