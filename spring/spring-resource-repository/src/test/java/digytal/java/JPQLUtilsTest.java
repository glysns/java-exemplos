package digytal.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import digytal.java.infra.sql.Condition;
import digytal.java.infra.sql.JPQLUtil;
import digytal.java.model.marca.Marca;

public class JPQLUtilsTest {
	@Test
	public void sql() {
		String sql = String.format("SELECT e FROM %s e", Marca.class.getName());
		JPQLUtil jpql = JPQLUtil.of(Marca.class);
		assertEquals(sql, jpql.sql());
	}
	@Test
	public void sqlWhere1Param() {
		String sql = String.format("SELECT e FROM %s e WHERE e.id = :p0", Marca.class.getName());
		JPQLUtil jpql = JPQLUtil.of(Marca.class);
		
		List<Condition> filter = new ArrayList<Condition>();
		filter.add(Condition.of("id", 123));
		
		jpql.conditions(filter);
		
		assertEquals(sql, jpql.sql());
	}
	@Test
	public void sqlWhere2Param() {
		String sql = String.format("SELECT e FROM %s e WHERE e.id = :p0 AND e.status = :p1", Marca.class.getName());
		JPQLUtil jpql = JPQLUtil.of(Marca.class);
		
		List<Condition> filter = new ArrayList<Condition>();
		filter.add(Condition.of("id", 123));
		filter.add(Condition.of("status", false));
		
		jpql.conditions(filter);
		
		assertEquals(sql, jpql.sql());
	}
	@Test
	public void sqlWhere2Param1Null() {
		String sql = String.format("SELECT e FROM %s e WHERE e.id = :p0", Marca.class.getName());
		JPQLUtil jpql = JPQLUtil.of(Marca.class);
		
		List<Condition> filter = new ArrayList<Condition>();
		filter.add(Condition.of("id", 123));
		filter.add(Condition.of("status", null));
		
		jpql.conditions(filter);
		
		assertEquals(sql, jpql.sql());
	}
	@Test
	public void sqlWhere1ParamOrderBy() {
		String sql = String.format("SELECT e FROM %s e WHERE e.nome LIKE :p0 ORDER BY e.nome", Marca.class.getName());
		JPQLUtil jpql = JPQLUtil.of(Marca.class);
		
		List<Condition> filter = new ArrayList<Condition>();
		filter.add(Condition.of("nome", "JOSE"));
		filter.add(Condition.of("orderBy", "nome"));
		
		jpql.conditions(filter);
		
		assertEquals(sql, jpql.sql());
	}
}
