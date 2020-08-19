package pl.stormit.usermanager.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import pl.stormit.usermanager.client.RestServiceClient;
import pl.stormit.usermanager.client.RestServiceClientConfiguration;
import pl.stormit.usermanager.model.Person;
import pl.stormit.usermanager.repository.PersonRepository;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ImportServiceWithWireMockTest {

	static WireMockServer wireMockServer;

	@BeforeAll
	static void setUpAll() {
		wireMockServer = new WireMockServer();
		wireMockServer.start();
	}

	@AfterAll
	static void tearDownAll() {
		wireMockServer.stop();
	}


	@BeforeEach
	void setUp() {
		WireMock.reset();
	}

	@Test
	void shouldImportPersons() {
		// given
		// stub: http://localhost:8080/persons
		stubFor(get(WireMock.urlPathMatching("/persons"))
				.willReturn(
						okJson("[{\"name\":\"Imię1\"},{\"name\":\"Imię2\"}]")
				)
		);

		RestServiceClient restServiceClient = new RestServiceClientConfiguration().createClient();
		PersonRepository personRepository = mock(PersonRepository.class);
		ImportService importService = new ImportService(personRepository, restServiceClient);

		ArgumentCaptor<Person> argumentCaptor = ArgumentCaptor.forClass(Person.class);

		// when
		importService.doImport();

		// then
		verify(personRepository, Mockito.times(2)).save(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues()).extracting(Person::getName).containsExactly("Imię1", "Imię2");
	}
}