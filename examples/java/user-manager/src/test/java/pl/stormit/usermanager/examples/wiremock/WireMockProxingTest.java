package pl.stormit.usermanager.examples.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WireMockProxingTest {

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
	void proxyGoogle() {
		// given
		stubFor(get(urlMatching("/search.*"))
				.willReturn(aResponse().proxiedFrom("https://www.google.com/")));

		Client client = ResteasyClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/search?q=Java");

		// when
		String content = target.request()
				.get().readEntity(String.class);

		// then
		assertThat(content).contains("https://pl.wikipedia.org/wiki/Java");
		verify(getRequestedFor(urlEqualTo("/search?q=Java"))
				.withQueryParam("q", equalTo("Java")));
	}
}
