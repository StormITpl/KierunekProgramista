package pl.stormit.usermanager.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pl.stormit.usermanager.client.PersonDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PersonTest {

	@Test
	void shouldThrowExceptionOnNullArgument() {
		// given

		// when
		Throwable throwable = catchThrowable(() -> new Person(null));

		// then
		assertThat(throwable).isInstanceOf(NullPointerException.class);
	}

	@Test
	void shouldCreatePeronFromPersonDto() {
		// given
		PersonDto personDto = new PersonDto("Tomek");

		// when
		Person person = new Person(personDto);

		// then
		SoftAssertions.assertSoftly(sf -> {
			sf.assertThat(person).isNotNull();
			sf.assertThat(person.getName()).isEqualTo("Tomek");
			sf.assertThat(person.getSurname()).isEqualTo("imported...");
			sf.assertThat(person.getAge()).isEqualTo(0);
		});
	}
}