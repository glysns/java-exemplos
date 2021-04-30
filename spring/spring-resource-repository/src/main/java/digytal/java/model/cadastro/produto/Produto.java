package digytal.java.model.cadastro.produto;

import java.util.List;

import digytal.java.model.cadastro.marca.Marca;

public class Produto {
	public Integer id;
	public String nome;
	public Marca marca;
	public boolean ativo;
	public List<String> tags;
	
	
}
