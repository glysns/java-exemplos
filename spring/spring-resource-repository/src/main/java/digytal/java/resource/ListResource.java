package digytal.java.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.java.model.categoria.CategoriaEntity;
import digytal.java.model.estoque.CompraEntity;
import digytal.java.model.marca.MarcaEntity;
import digytal.java.model.produto.ProdutoEntity;
import digytal.java.repository.PersistRepository;

@RestController
@RequestMapping("/list")
public class ListResource {
	@Autowired
	private PersistRepository repository;
	@GetMapping("/marcas")
	public List marca() throws Exception {
		return repository.list(MarcaEntity.class);
	}
	@GetMapping("/categorias")
	public List categoria() throws Exception {
		return repository.list(CategoriaEntity.class);
	}
	@GetMapping("/produtos")
	public List produto() throws Exception {
		return repository.list(ProdutoEntity.class);
	}
	@GetMapping("/compras")
	public List compra() throws Exception {
		return repository.list(CompraEntity.class);
	}
}
