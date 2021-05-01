package digytal.java.model.estoque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tab_compra")
public class CompraEntity extends Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	private List<CompraItemEntity> itens = new ArrayList<CompraItemEntity>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_compra")
	public List<CompraItemEntity> getItens() {
		return itens;
	}
	public void setItens(List<CompraItemEntity> itens) {
		this.itens = itens;
	}
	
	
}
