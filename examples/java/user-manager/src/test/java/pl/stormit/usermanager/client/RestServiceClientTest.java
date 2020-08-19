package pl.stormit.usermanager.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

class RestServiceClientTest {


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
	void beforeEach() {
		WireMock.reset();
	}

	@Test
	void shouldReturnPersons() {
		// given
		// stub: http://localhost:8080/persons
		stubFor(get(WireMock.urlPathMatching("/persons"))
				.willReturn(
						okJson("[{\"name\":\"MockedPerson1\"},{\"name\":\"MockedPerson2\"}]")
								.withHeader("X-Powered-By", "WireMockTest")
				)
		);
		RestServiceClient client = new RestServiceClientConfiguration().createClient();

		// when
		List<PersonDto> persons = client.persons();

		// then
		assertThat(persons)
				.hasSize(2)
				.extracting(PersonDto::getName)
				.containsExactly("MockedPerson1", "MockedPerson2");
	}
}