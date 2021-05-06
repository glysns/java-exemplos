package digytal.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
	public void sqlWhere() {
		String sql = String.format("SELECT e FROM %s e", Marca.class.getName());
		JPQLUtil jpql = JPQLUtil.of(Marca.class);
		assertEquals(sql, jpql.sql());
	}
}
