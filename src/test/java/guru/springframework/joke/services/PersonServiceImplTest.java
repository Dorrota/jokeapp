package guru.springframework.joke.services;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.joke.model.Person;

public class PersonServiceImplTest {
	
	PersonServiceImpl personService;
	
	@Mock
	PersonConfig personConfig;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		personService = new PersonServiceImpl(personConfig);
		
	}

	@Test
	public void listAllPersonTest() {
		
		Iterable<Person> personList = personService.listAllPerson();
		System.out.println(personList + "toto");
	}

}
