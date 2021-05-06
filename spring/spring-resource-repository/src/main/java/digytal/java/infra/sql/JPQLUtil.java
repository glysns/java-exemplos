package digytal.java.infra.sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import digytal.java.infra.sql.Condition.Operator;

public class JPQLUtil {
	private String select;
	private List<Condition> conditions = new ArrayList<Condition>();
	public Map<String, Object> params = new HashMap<String, Object>();
	private static JPQLUtil instance;
	
	public static JPQLUtil of(Class cls) {
		return of(String.format("SELECT e FROM %s e", cls.getName()));
	}
	public static JPQLUtil of(String select) {
		instance = new JPQLUtil();
		instance.select = select;
		return instance;
	}
	public JPQLUtil conditions(List<Condition> conditions ) {
		instance.conditions = conditions;
		return instance;
	}
	public String sql() {
		StringBuilder sb = new StringBuilder(select);
		int p=0;
		Condition orderBy=conditions.stream().filter(c -> c.field.equals("orderBy")).findFirst().orElse(null);
		conditions.remove(orderBy);
		for(Condition c: instance.conditions) {
			if(c.value!=null) {
				Operator l= p==0? Operator.WHERE : c.logic;
				String pname ="p"+p++;
				sb.append(String.format(" %s e.%s %s :%s", l, c.field, c.comparator.symbol, pname));
				params.put(pname, c.value);
				
			}
		}
		if(orderBy!=null)
			sb.append(" ORDER BY " + "e." + orderBy.value.toString().replaceAll("\\%", ""));
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
}
