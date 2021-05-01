package digytal.java.model.produto;

import java.util.ArrayList;
import java.util.List;

import digytal.java.model.marca.Marca;

public class Produto {
	public Integer id;
	public String nome;
	public Marca marca;
	public boolean ativo;
	public List<String> tags = new ArrayList<String>();
}
