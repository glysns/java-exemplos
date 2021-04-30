package digytal.java.model.cadastro.marca;

import digytal.java.commons.Model;

public class MarcaEntity extends Marca implements Model {
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
	
}
