package guru.springframework.joke.services;

import java.util.List;

import guru.springframework.joke.model.Person;

public interface PersonService {

	List<Person> listAllPerson();
	
	//Person getPersonByName(String name);
	Person getPersonByName(String name);
}
