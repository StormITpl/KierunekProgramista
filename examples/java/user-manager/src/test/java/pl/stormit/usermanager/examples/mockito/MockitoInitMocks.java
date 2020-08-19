package pl.stormit.usermanager.examples.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import pl.stormit.usermanager.model.Person;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

public class MockitoInitMocks {

	@Mock
	private List<Person> persons;

	@Mock
	private Person person;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testMockMethod() {
		// given
		when(persons.get(0)).thenReturn(new Person("Tomek", "W", 18));

		// when
		Person person = persons.get(0);

		// then
		assertThat(person.getName()).isEqualTo("Tomek");
	}

	@Test
	void testMockException() {
		// given
		when(person.getName()).thenThrow(new RuntimeException("RE"));

		// when
		Throwable throwable = catchThrowable(() -> person.getName());

		// then
		assertThat(throwable)
				.isInstanceOf(RuntimeException.class)
				.hasMessage("RE");
	}

	@Test
	void testAnswer() {
		// given
		when(person.getAge()).thenAnswer(new Answer<Integer>() {
			@Override
			public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
				// call db, read file...
				String methodName = invocationOnMock.getMethod().getName();
				assertThat(methodName).isEqualTo("getAge");

				return -1;
			}
		});

		// when


		// then
		assertThat(person.getAge()).isEqualTo(-1);
	}
}
