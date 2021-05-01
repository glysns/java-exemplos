package digytal.java;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import digytal.java.model.categoria.CategoriaEntity;
import digytal.java.model.estoque.CompraEntity;
import digytal.java.model.estoque.CompraItemEntity;
import digytal.java.model.marca.MarcaEntity;
import digytal.java.model.produto.ProdutoEntity;
import digytal.java.repository.sample.CustomRepository;

@SpringBootApplication
public class SpringResourceRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringResourceRepositoryApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(CustomRepository pr) throws Exception {
		return args -> {
			MarcaEntity marca = new MarcaEntity();
			marca.setAtivo(true);
			marca.setNome("DELL");
			pr.save(marca);
			
			marca = new MarcaEntity();
			marca.setAtivo(true);
			marca.setNome("ACER");
			pr.save(marca);
			
			marca = new MarcaEntity();
			marca.setAtivo(true);
			marca.setNome("RAZZOR");
			pr.save(marca);
			
			CategoriaEntity categoria = new CategoriaEntity();
			categoria.setNome("NOTEBOOKS");
			
			pr.save(categoria);
			
			ProdutoEntity produto = new ProdutoEntity();
			produto.setCategoria(1);
			produto.setMarca(marca);
			produto.setNome("NOTE BOOK DELL 2X1 INSPIRON");
			
			List<String> tags = new ArrayList<String>();
			tags.add("INSPIRON");
			tags.add("2X1");
			tags.add("TECNOLOGIA");
			
			produto.setTags(tags);
			
			pr.save(produto);
			
			CompraEntity compra = new CompraEntity();
			compra.setNota("NF123");
			compra.getItens().add(new CompraItemEntity(1, 10.0, 2.75, 27.5));
			compra.getItens().add(new CompraItemEntity(2, 5.0, 3.0, 15.0));
			pr.save(compra);
			
		};
	}	

}
