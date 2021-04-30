package digytal.java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResourceRepositoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResourceRepositoryApplication.class, args);
	}
	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
			
		};
	}	
}
