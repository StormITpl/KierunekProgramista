package pl.stormit.usermanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.stormit.usermanager.model.Person;
import pl.stormit.usermanager.service.ImportService;
import pl.stormit.usermanager.service.PersonService;

import java.util.List;

@RestController
public class UserManagerController {

	private PersonService personService;

	private ImportService importService;

	public UserManagerController(PersonService personService, ImportService importService) {
		this.personService = personService;
		this.importService = importService;
	}

	@GetMapping("/import")
	public void importAction() {
		importService.doImport();
	}

	@GetMapping("/persons")
	public List<Person> persons() {
		return personService.getAllPersons();
	}

	@GetMapping("/clear")
	public void clear() {
		personService.getAllPersons().forEach(personService::deletePerson);
	}
}
