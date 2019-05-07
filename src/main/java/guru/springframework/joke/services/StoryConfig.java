package guru.springframework.joke.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import lombok.Getter;

@Configuration
@Getter
@PropertySource(value="classpath:application.properties")
public class StoryConfig {
	
	@Value("#{'${my.list.of.names}'.split(',')}")
	private List<String> nameList;
	
	
//	@Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
	
}
