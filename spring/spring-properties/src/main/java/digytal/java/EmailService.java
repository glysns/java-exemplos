package digytal.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	//@Value("${remetente:gleyson@digytal.com.br}")
	@Value("${remetente}")
	private String remetente;
	
	@Value("${destinatarios}")
	private List<String>destinatarios;
	
	public void enviar() {
		System.out.println("Remetente:" + remetente);
		System.out.println("Destinatarios:" + destinatarios);
		System.out.println("Email enviado com sucesso");
	}
}
