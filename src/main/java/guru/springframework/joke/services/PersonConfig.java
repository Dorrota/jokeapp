package guru.springframework.joke.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@Getter
@PropertySource(value="classpath:application.properties")
public class PersonConfig {

	@Value("#{'${person.list}'.split(',')}")
	private List<String> personList;
}
