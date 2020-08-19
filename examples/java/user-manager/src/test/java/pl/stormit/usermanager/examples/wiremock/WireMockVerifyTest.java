package pl.stormit.usermanager.examples.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.BasicCredentials;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.stormit.usermanager.model.Person;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WireMockVerifyTest {

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
	void verifyGetRequest() {
		// given
		Client client = ResteasyClientBuilder.newClient();
		client.register(new BasicAuthentication("own-login", "own-password"));
		WebTarget target = client.target("http://localhost:8080/java");

		// when
		target.request()
				.header("Content-Type", "text/plain")
				.get();

		// then
		WireMock.verify(
				WireMock.getRequestedFor(WireMock.urlEqualTo("/java"))
						.withHeader("Content-Type", WireMock.equalTo("text/plain"))
						.withBasicAuth(new BasicCredentials("own-login", "own-password"))
		);
	}

	@Test
	void verifyPostRequest() {
		// given
		Client client = ResteasyClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/person");

		Person person = new Person("Tomek", "W", 18);

		// when
		target.request()
				.header("Content-Type", MediaType.APPLICATION_JSON)
				.post(Entity.json(person));

		// then
		WireMock.verify(
				WireMock.postRequestedFor(WireMock.urlEqualTo("/person"))
						.withHeader("Content-Type", WireMock.equalTo("application/json"))
						.withRequestBody(WireMock.equalToJson("{\"name\": \"Tomek\", \"surname\":\"W\", \"age\": 18}", true, true))
		);
	}
}
