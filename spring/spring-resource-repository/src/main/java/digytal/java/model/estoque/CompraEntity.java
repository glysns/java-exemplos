package digytal.java.model.estoque;

import java.util.ArrayList;
import java.util.List;

public class CompraEntity extends Compra {
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	private List<CompraItemEntity> itens = new ArrayList<CompraItemEntity>();
	public List<CompraItemEntity> getItens() {
		return itens;
	}
	public void setItens(List<CompraItemEntity> itens) {
		this.itens = itens;
	}
}
