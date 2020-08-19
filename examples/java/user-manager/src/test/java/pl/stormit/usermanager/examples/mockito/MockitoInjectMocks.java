package pl.stormit.usermanager.examples.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.stormit.usermanager.model.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class MockitoInjectMocks {

	@Mock
	Person person;

	@Mock
	DaoExample daoExample;

	@InjectMocks
	ServiceExample serviceExample;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testInjectMocks() {
		// given
		when(person.getName()).thenReturn("N");
		when(person.getSurname()).thenReturn("S");

		// when
		String result = serviceExample.doComputations();

		// then
		assertThat(result).isEqualTo("N S");
	}
}
