package digytal.java.model.estoque;

public class CompraItem {
	public Integer produto;
	public Double quantidade;
	public Double valorUnitario;
	public Double valorTotal;
	public CompraItem(Integer produto, Double quantidade, Double valorUnitario, Double valorTotal) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
	}
	public CompraItem() {
		
	}
	
	
}
