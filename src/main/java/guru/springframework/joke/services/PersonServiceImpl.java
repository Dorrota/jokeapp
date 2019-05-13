package guru.springframework.joke.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import guru.springframework.joke.model.Person;

@Service
public class PersonServiceImpl implements PersonService{
	
	private final PersonConfig personConfig;
	private List<Person> personList;
	
//	@Value("${person.list}")
//	private String properties;
//	private List<Person> newPersonList;

	public PersonServiceImpl(PersonConfig personConfig) {
		this.personConfig = personConfig;
//		List<String> propTable = Arrays.asList(properties.split(","));
//		newPersonList = new ArrayList<>();
//		for(String s : propTable) {
//			String[] splited = s.split("|");
//			Person person = new Person(splited[0], splited[1]);
//			newPersonList.add(person);
//		}
		
	}
    
	@PostConstruct
	public void init() {
		List<String> personSList = personConfig.getPersonList();
		personList = new ArrayList<Person>();
		for (String s: personSList) {
			System.out.println(s);
		}
		
		
		for(String s: personSList) {
			String[] pers = s.split("\\|");
			for(String splited: pers) {
			    System.out.println(splited);
			}
			Person p= new Person(pers[0] , pers[1]);
			personList.add(p);
		}
		
	}
	
	@Override
	public List<Person> listAllPerson() {
		return personList;
	}

	@Override
	public Person getPersonByName(String name) {
		return personList.stream().filter(x-> x.getName().equals(name)).findFirst().get();
		
	}

}
