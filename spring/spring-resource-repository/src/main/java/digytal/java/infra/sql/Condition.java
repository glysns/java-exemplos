package digytal.java.infra.sql;

import java.util.Collection;
import java.util.Map.Entry;

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

	public static Condition of(String field,Object value,Class ... clsEnum) {
		return of(field,Operator.EQUALS, value,clsEnum);
	}
	public static Condition of(String field, Operator comparator, Object value,Class ... clsEnum) {
		return of(field,comparator, value,true, Operator.AND,clsEnum);
	}
	public static Condition of(Entry<String, Object> condition,Class ... clsEnum) {
		return of(condition,Operator.EQUALS,clsEnum);
	}
	public static Condition of(Entry<String, Object> condition, Operator comparator,Class ... clsEnum) {
		return of(condition, comparator,Operator.AND,clsEnum);
	}
	public static Condition of(Entry<String, Object> condition, Operator comparator, Operator logic, Class ... clsEnum) {
		return of(condition.getKey(), comparator, condition.getValue(), true, logic,clsEnum);
	}
	public static Condition of(String field, Operator comparator, Object value, boolean like, Operator logic, Class ... clsEnum) {
		//value = prepare(value, like);
		Condition condition = new Condition();
		
		if(value !=null && !value.toString().isEmpty()) {
			if(value instanceof Collection)
				comparator = Operator.IN;
			else {
				String v = value.toString();
				if(clsEnum.length>0)
					value = Enum.valueOf(clsEnum[0], value.toString().toUpperCase());
				else if(v.matches("-?\\d+"))
					value = Integer.valueOf(v);
				else if(v.matches("-?\\d+\\.\\d+"))
					value = Double.valueOf(v);
				else if(v.matches("true|false"))
					value = Boolean.valueOf(v);
				else if(like) {
					value="%" + value+"%";
					comparator = Operator.LIKE;
				}
			}
		}else
			value=null;
		
		condition.field=field;
		condition.comparator=comparator;
		condition.value=value;
		condition.logic=logic;
		return condition;
		
	}
	
	@Override
	public String toString() {
		return "Condition [field=" + field + ", comparator=" + comparator + ", value=" + value + ", logic=" + logic
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condition other = (Condition) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		return true;
	}
	
}