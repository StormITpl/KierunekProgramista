package pl.stormit.usermanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stormit.usermanager.model.Person;
import pl.stormit.usermanager.repository.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deletePerson(Person person) {
		personRepository.delete(person);
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
}