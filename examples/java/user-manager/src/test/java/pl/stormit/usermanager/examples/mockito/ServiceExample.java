package pl.stormit.usermanager.examples.mockito;

import pl.stormit.usermanager.model.Person;

public class ServiceExample {
	private Person person;
	private DaoExample daoExample;

	public ServiceExample(Person person, DaoExample daoExample) {
		this.person = person;
		this.daoExample = daoExample;
	}

	public String doComputations() {
		daoExample.save(person);
		return person.getName() + " " + person.getSurname();
	}
}
