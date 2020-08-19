package pl.stormit.usermanager.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.stormit.usermanager.model.Person;
import pl.stormit.usermanager.repository.PersonRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PersonServiceTest {

	@Mock
	PersonRepository personRepository;

	@InjectMocks
	PersonServiceImpl personService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void createPerson() {
		// given
		Person person = new Person("N", "S", 0);

		// when
		personService.createPerson(person);

		// then
		verify(personRepository).save(eq(person));
	}

	@Test
	void deletePerson() {
		// given
		Person person = new Person("N", "S", 0);

		// when
		personService.deletePerson(person);

		// then
		verify(personRepository).delete(eq(person));
	}

	@Test
	void getAllPersons() {
		// given
		Person person = new Person("N", "S", 0);
		when(personRepository.findAll()).thenReturn(Arrays.asList(person));

		// when
		List<Person> result = personService.getAllPersons();

		// then
		verify(personRepository).findAll();
		assertThat(result)
				.hasSize(1)
				.containsExactly(person);

	}
}