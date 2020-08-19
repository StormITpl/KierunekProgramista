package pl.stormit.usermanager.examples.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import pl.stormit.usermanager.model.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockitoVerify {

	@Mock
	Person person;

	@Mock
	DaoExample daoExample;

	@InjectMocks
	ServiceExample serviceExample;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);

		when(person.getName()).thenReturn("N");
		when(person.getSurname()).thenReturn("S");
	}

	@Test
	void testVerifyTimes() {
		// given

		// when
		String result = serviceExample.doComputations();

		// then
		assertThat(result).isEqualTo("N S");
		verify(daoExample, Mockito.atLeast(1)).save(ArgumentMatchers.isA(Person.class));
	}

	@Test
	void testArgumentCaptor() {
		// given
		ArgumentCaptor<Person> argumentCaptor = ArgumentCaptor.forClass(Person.class);

		// when
		String result = serviceExample.doComputations();

		// then
		verify(daoExample).save(argumentCaptor.capture());
		Person savedPerson = argumentCaptor.getValue();

		assertThat(savedPerson.getName()).isEqualTo("N");
		assertThat(savedPerson.getSurname()).isEqualTo("S");
	}
}
