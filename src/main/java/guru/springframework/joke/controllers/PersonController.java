package guru.springframework.joke.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.joke.model.Person;
import guru.springframework.joke.services.PersonService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {
	
	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping(value="/list", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<Person> list(Model model){
    	
    	log.info("/person/list");

        Iterable<Person> personList = personService.listAllPerson();
        return personList;
	}
	
	@RequestMapping(value="/name/{name}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Person getOnePersonByName (@PathVariable String name) {
		
		log.info("/name");
		
		name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		Person fullName = personService.getPersonByName(name);
		
		return fullName;
	}
	

}
