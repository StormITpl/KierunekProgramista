package pl.stormit.usermanager.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import pl.stormit.usermanager.client.PersonDto;
import pl.stormit.usermanager.client.RestServiceClient;
import pl.stormit.usermanager.model.Person;
import pl.stormit.usermanager.repository.PersonRepository;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ImportServiceTest {

	@Mock
	PersonRepository personRepository;

	@Mock
	RestServiceClient restServiceClient;

	@InjectMocks
	ImportService importService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void shouldImportPersons() {
		// given
		when(restServiceClient.persons()).thenReturn(Arrays.asList(
				new PersonDto("Imię1"),
				new PersonDto("Imię2"),
				new PersonDto("Imię3")
		));
		ArgumentCaptor<Person> argumentCaptor = ArgumentCaptor.forClass(Person.class);

		// when
		importService.doImport();

		// then
		verify(personRepository, Mockito.times(3)).save(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues()).extracting(Person::getName).containsExactly("Imię1", "Imię2", "Imię3");
	}
}