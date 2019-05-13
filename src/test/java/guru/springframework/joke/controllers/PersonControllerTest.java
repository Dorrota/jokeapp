package guru.springframework.joke.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import guru.springframework.joke.model.Person;
import guru.springframework.joke.services.PersonService;
import guru.springframework.joke.services.PersonServiceImpl;

public class PersonControllerTest {

	@Mock
	PersonService personService;

	@Mock
	Model model;

	PersonController controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		List<Person> list = new ArrayList<>();
		list.add(new Person("dupa", "blada"));
		list.add(new Person("pies", "chomik"));
		when(personService.listAllPerson()).thenReturn(list);
		when(personService.getPersonByName("Dupa")).thenReturn(new Person("Dupa", "Blada"));
		controller = new PersonController(personService);
	}

	@Test
	public void mockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		MvcResult mvcResult = mockMvc.perform(get("/person/list")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Odpowiedz z serwera", "[{\"name\":\"dupa\",\"lastName\":\"blada\"},{\"name\":\"pies\",\"lastName\":\"chomik\"}]", content);
		
//		 mockMvc.perform(get("/person/list")).
//		 andExpect(status().isOk()).
//		 andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		 
		 verify(personService, times(1)).listAllPerson();
		 
		
		// andExpect(view().name("/person/list"));

	}
	
	@Test
	public void getByNameAllUpperCaseTest() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		MvcResult mvcResult = mockMvc.perform(get("/person/name/DUPA")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Odpowiedz z serwera", "{\"name\":\"Dupa\",\"lastName\":\"Blada\"}", content);

	}
	
	@Test
	public void getByNameAllLowerCaseTest() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		MvcResult mvcResult = mockMvc.perform(get("/person/name/dupa")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Odpowiedz z serwera", "{\"name\":\"Dupa\",\"lastName\":\"Blada\"}", content);

	}
	
	@Test
	public void getByNameFirstLowerCaseTest() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		MvcResult mvcResult = mockMvc.perform(get("/person/name/dUPA")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Odpowiedz z serwera", "{\"name\":\"Dupa\",\"lastName\":\"Blada\"}", content);

	}
	

}
