package digytal.java.model.produto;

import java.util.List;

import digytal.java.commons.Model;
import digytal.java.model.marca.MarcaEntity;

public class ProdutoEntity extends Produto implements Model {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private MarcaEntity marca;
	public MarcaEntity getMarca() {
		return marca;
	}
	public void setMarca(MarcaEntity marca) {
		this.marca = marca;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
