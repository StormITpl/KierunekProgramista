package pl.stormit.usermanager.examples.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class WireMockBasicStubTest {

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
	void basicStub() {
		// given
		WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/java"))
				.willReturn(WireMock.aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "text/plain")
						.withBody("Java rocks!"))
		);

		Client client = ResteasyClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/java");

		// when
		Response response = target.request().get();

		// then
		assertThat(response.getStatus()).isEqualTo(200);
		assertThat(response.getHeaderString("Content-Type")).isEqualTo("text/plain");
		assertThat(response.readEntity(String.class)).isEqualTo("Java rocks!");
	}

	@Test
	void withBasicAuth() {
		// given
		WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/java"))
				.willReturn(WireMock.aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "text/plain")
						.withBody("Java rocks!")
				)
				.withBasicAuth("own-login", "own-password")
		);

		Client client = ResteasyClientBuilder.newClient();
		client.register(new BasicAuthentication("own-login", "own-password"));
		WebTarget target = client.target("http://localhost:8080/java");

		// when
		Response response = target.request().get();

		// then
		assertThat(response.getStatus()).isEqualTo(200);
		assertThat(response.getHeaderString("Content-Type")).isEqualTo("text/plain");
		assertThat(response.readEntity(String.class)).isEqualTo("Java rocks!");
	}

}
