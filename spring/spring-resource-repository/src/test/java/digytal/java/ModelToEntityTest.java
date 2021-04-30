package digytal.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import digytal.java.infra.converter.ModelConveter;
import digytal.java.model.cadastro.marca.Marca;
import digytal.java.model.cadastro.marca.MarcaEntity;
import digytal.java.model.cadastro.produto.Produto;
import digytal.java.model.cadastro.produto.ProdutoEntity;

public class ModelToEntityTest {
	@Test
	void modelToEntity(){
		try {
			Marca dto = new Marca();
			dto.nome="DELL";
			dto.id=1234;
			dto.ativo=true;
			MarcaEntity entity = ModelConveter.getInstance(dto).newInstance();
			assertEquals(dto.id, entity.getId());
			assertEquals(dto.nome, entity.getNome());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void modelToEntityAssociation(){
		try {
			Marca marca = new Marca();
			marca.nome="DELL";
			marca.id=1234;
			
			Produto dto = new Produto();
			dto.nome="NOTEBOOK DELL 13' 2X1";
			dto.id=1234;
			dto.marca=marca;
			dto.ativo=true;
			
			
			ProdutoEntity entity = ModelConveter.getInstance(dto).newInstance();
			assertEquals(dto.id, entity.getId());
			assertEquals(dto.nome, entity.getNome());
			
			assertNotNull(entity.getMarca());
			assertEquals(dto.marca.id, entity.getMarca().getId());
			assertEquals(dto.marca.nome, entity.getMarca().getNome());
			assertEquals(dto.ativo, entity.isAtivo());
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void modelToEntitySimpleList(){
		try {
			Produto dto = new Produto();
			dto.nome="NOTEBOOK DELL 13' 2X1";
			dto.id=1234;
			dto.ativo=true;
			dto.tags = new ArrayList<String>();
			dto.tags.add("INSPIRON");
			dto.tags.add("2X1");
			dto.tags.add("TECNOLOGIA");
			
			ProdutoEntity entity = ModelConveter.getInstance(dto).newInstance();
			assertEquals(dto.id, entity.getId());
			assertEquals(dto.nome, entity.getNome());
			assertEquals(dto.ativo, entity.isAtivo());
			assertEquals(3, entity.getTags().size());
			assertEquals(true, entity.getTags().containsAll(dto.tags));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
