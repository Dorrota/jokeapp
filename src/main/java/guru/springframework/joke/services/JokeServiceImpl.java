package guru.springframework.joke.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import guru.springframework.joke.exception.DorotaNotFoundException;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeServiceImpl implements JokeService {

	private final ChuckNorrisQuotes chuckNorrisQuotes;
	private final StoryConfig storyConfig;
	
	public JokeServiceImpl(StoryConfig storyConfig) {
		this.chuckNorrisQuotes = new ChuckNorrisQuotes();
		this.storyConfig = storyConfig;
	}
	
	
	@Override
	public List<String> getRandomNames(int count) throws Exception {
		//todo if watrosoi
		
		List<String> myList = storyConfig.getNameList();
		Random rand = new Random();
		List<String> shortList = new ArrayList<String>();
		
		if (count <= 0 || count > myList.size()) {
			//shortList.add("Zły numerek!");
			//throw new RuntimeException("Do bani");
			throw new DorotaNotFoundException("Zły numerek!");
	
		} 
			
		
		
		for (int i = 0; i < count; i++) {
	        int randomIndex = rand.nextInt(myList.size());
	        shortList.add(myList.get(randomIndex));
	        // String randomElement = myList.get(randomIndex);
	    }

		
		System.out.println(myList.size());
		for(String temp : myList){
			System.out.println(temp);
		}
		
		System.out.println(shortList.size());
		for(String temp : shortList){
			System.out.println(temp);
		}
		
		return shortList;
	}
	@Override
	public String getJoke() {
		// TODO Auto-generated method stub
		return chuckNorrisQuotes.getRandomQuote();
	}
	
	
	
	
	
	
	
	

}
