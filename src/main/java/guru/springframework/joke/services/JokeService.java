package guru.springframework.joke.services;

import java.util.List;

public interface JokeService {
	
	String getJoke();

	List<String> getRandomNames(int count) throws Exception;
	
}
