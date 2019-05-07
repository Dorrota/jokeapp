package guru.springframework.joke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("guru.springframework.joke")
public class JokeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JokeappApplication.class, args);
	}

}
