package digytal.java.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.java.infra.converter.ModelConveter;
import digytal.java.model.marca.Marca;
import digytal.java.model.marca.MarcaEntity;
import digytal.java.repository.PersistRepository;

@RestController
@RequestMapping("/get")
public class PostResource {
	@Autowired
	private PersistRepository repository;
	@PostMapping("/marcas")
	public void marca(@RequestBody Marca marca) throws Exception {
		MarcaEntity entity = ModelConveter.getInstance(marca).newInstance();
		repository.save(entity);
	}
}
