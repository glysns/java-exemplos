package digytal.java.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.java.infra.converter.ModelConveter;
import digytal.java.model.marca.Marca;
import digytal.java.model.marca.MarcaEntity;
import digytal.java.repository.PersistRepository;

@RestController
@RequestMapping("/post")
public class GetResource {
	@Autowired
	private PersistRepository repository;
	@GetMapping("/marcas/{id}")
	public Marca marca(@PathVariable Integer id) throws Exception {
		return repository.find(MarcaEntity.class, id);
	}
}
