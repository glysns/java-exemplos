package digytal.java.infra.sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JPQLUtil {
	public Class entity;
	public List<Condition> conditions = new ArrayList<Condition>();
	public Map<String, Object> params = new HashMap<String, Object>();
	public static JPQLUtil instance;
	
	public static JPQLUtil of(Class entity) {
		instance = new JPQLUtil();
		instance.entity = entity;
		return instance;
	}
	public JPQLUtil conditions(List<Condition> conditions ) {
		instance.conditions = conditions;
		return instance;
	}
	public String sql() {
		StringBuilder sb = new StringBuilder(String.format("SELECT e FROM %s e", instance.entity.getName()));
		int p=0;
		sb.append(instance.conditions.size()==0?"":" WHERE ");
		for(Condition c: instance.conditions) {
			String pname ="p"+p++;
			sb.append(String.format("e.%s %s :%s %s ", c.field, c.comparator.symbol, pname, (conditions.size()==p?"" :c.logic)));
			params.put(pname, c.value);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
}
