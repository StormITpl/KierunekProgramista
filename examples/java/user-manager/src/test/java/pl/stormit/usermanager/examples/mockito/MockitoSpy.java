package pl.stormit.usermanager.examples.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import pl.stormit.usermanager.model.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockitoSpy {

	@Spy
	Person person1;

	@Spy
	Person person2 = new Person("Imię2", "Nazwisko2", 18);

	Person person3;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);

		person3 = Mockito.spy(new Person("Imię3", "Nazwisko3", 18));
	}

	@Test
	void testDefaultInitialization() {
		assertThat(person1.getName()).isNull();
		assertThat(person2.getName()).isEqualTo("Imię2");
		assertThat(person3.getName()).isEqualTo("Imię3");
	}

	@Test
	void testMockMethod() {
		when(person2.getName()).thenReturn("Zmienione imię");

		assertThat(person2.getName()).isEqualTo("Zmienione imię");
	}

	@Test
	void testVerify() {
		person2.getName();
		person2.getName();

		verify(person2, Mockito.times(2)).getName();
	}
}
