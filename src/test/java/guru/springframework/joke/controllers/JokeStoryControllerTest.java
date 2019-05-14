package guru.springframework.joke.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.joke.services.JokeService;

public class JokeStoryControllerTest {
	
	@Mock
	JokeService jokeService;
	
	JokeController jokeController;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		jokeController = new JokeController(jokeService);
		
		List<String> names = new ArrayList<>();
		names.add("Bolek");
		names.add("Lolek");
		names.add("Elza");
		
		when(jokeService.getRandomNames(3)).thenReturn(names);
		
	}

	@Test
	public void showNamesTest() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(jokeController).build();
		
		mockMvc.perform(get("/nameList/3"))
		 .andExpect(status().isOk())
		 .andExpect(view().name("namelist"));
		
	}

}





