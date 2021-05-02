package digytal.java.infra.sql;

public class Condition {
	public String field;
	public Operator comparator = Operator.EQUALS;
	public Object value;
	public Operator logic = Operator.AND;
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
	public static Condition condition(String field, Object value) {
		return condition(field,Operator.EQUALS, value,Operator.AND);
	}
	public static Condition condition(String field,Operator comparator, Object value) {
		return condition(field, comparator, value, Operator.AND);
	}
	public static Condition condition(String field, Operator comparator, Object value, Operator logic) {
		return condition(field, comparator, value, true, logic);
	}
	public static Condition condition(String field, Operator comparator, Object value, boolean like, Operator logic) {
		Object v = value;
		if( like && value instanceof String) {
			comparator = Operator.LIKE;
			v="%" + value+"%";
		}
		Condition condition = new Condition();
		condition.comparator=comparator;
		condition.logic=logic;
		condition.field=field;
		condition.value=v;
		return condition;
		
	}
}
