package digytal.java.repository;

import org.springframework.data.repository.CrudRepository;

import digytal.java.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
	Endereco findByCep(String cep);
}
