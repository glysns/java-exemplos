package digytal.java.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.java.model.categoria.Categoria;
import digytal.java.model.categoria.CategoriaEntity;
import digytal.java.model.estoque.Compra;
import digytal.java.model.estoque.CompraEntity;
import digytal.java.model.marca.Marca;
import digytal.java.model.marca.MarcaEntity;
import digytal.java.model.produto.Produto;
import digytal.java.model.produto.ProdutoEntity;
import digytal.java.repository.PersistRepository;

@RestController
@RequestMapping("/get")
public class GetResource {
	@Autowired
	private PersistRepository repository;
	@GetMapping("/marcas/{id}")
	public Marca marca(@PathVariable Integer id) throws Exception {
		return repository.find(MarcaEntity.class, id);
	}
	@GetMapping("/categorias/{id}")
	public Categoria categoria(@PathVariable Integer id) throws Exception {
		return repository.find(CategoriaEntity.class, id);
	}
	@GetMapping("/produtos/{id}")
	public Produto produto(@PathVariable Integer id) throws Exception {
		return repository.find(ProdutoEntity.class, id);
	}
	@GetMapping("/compras/{id}")
	public Compra compra(@PathVariable Integer id) throws Exception {
		return repository.find(CompraEntity.class, id);
	}
}
