package pl.stormit.usermanager.service;


import pl.stormit.usermanager.model.Person;

import java.util.List;

public interface PersonService {

	Person createPerson(Person person);

	void deletePerson(Person person);

	List<Person> getAllPersons();
}