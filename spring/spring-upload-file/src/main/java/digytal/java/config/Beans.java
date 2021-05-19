package digytal.java.config;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Beans {
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
}
