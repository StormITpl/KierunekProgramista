package pl.stormit.usermanager.service;

import org.springframework.stereotype.Service;
import pl.stormit.usermanager.client.RestServiceClient;
import pl.stormit.usermanager.model.Person;
import pl.stormit.usermanager.repository.PersonRepository;

@Service
public class ImportService {

	private PersonRepository personRepository;

	private RestServiceClient restServiceClient;

	public ImportService(PersonRepository personRepository, RestServiceClient restServiceClient) {
		this.personRepository = personRepository;
		this.restServiceClient = restServiceClient;
	}

	public void doImport() {
		restServiceClient.persons().forEach(personDto -> personRepository.save(new Person(personDto)));
	}
}