package digytal.java.infra.sql;

import java.util.ArrayList;
import java.util.List;

import digytal.java.model.produto.ProdutoView;

public class Condition {
	public String field;
	public Operator comparator = Operator.EQUALS;
	public Object value;
	public Operator logic = Operator.AND;
	//https://docs.microsoft.com/pt-br/sql/t-sql/language-elements/comparison-operators-transact-sql?view=sql-server-ver15
	public enum Operator {
		AND("AND"),
		OR("OR"),
		EQUALS("="), 
		BETWEEN("BETWEEN"),
		GREATER_THAN(">"),
		LESS_THAN("<"), 
		GREATER_EQUAL(">="), 
		LESS_EQUAL("<="), 
		NOT_EQUAL("!="),
		LIKE("LIKE"), 
		EXISTS("EXISTS"),
		IN("IN"),
		IS("IS"),
		EMPTY(""),
		; 
		
		String symbol;
		
		Operator(String op) {
			this.symbol = op;
		}		
	}
	public static void main(String[] args) throws Exception {
		List<Condition> conditions = new ArrayList<Condition>();
		Condition c = new Condition();
		c.field="nome";
		c.value="FORD";
		conditions.add(c);
		String sql = JPQLUtil.of(ProdutoView.class).conditions(conditions).sql();
		System.out.println(sql);
	}

}
