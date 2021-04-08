package digytal.java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PropertiesApplication {
	public static void main(String[] args) {
		SpringApplication.run(PropertiesApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(FtpService ftp, EmailService email) {
        return args -> {
			System.out.println("Teste");
        	ftp.conectar();
        	email.enviar();
		};
    }
}
