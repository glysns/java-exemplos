package digytal.java.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(Object entity) {
		em.persist(entity);
	}
	@Transactional
	public void update(Object entity) {
		em.merge(entity);
	}
	public <E> E find(Class entityClass, Object id) {
		return (E) em.find(entityClass, id);
	}
	public List list(Class entityClass) {
		Query q = em.createQuery(String.format("SELECT e FROM %s e",entityClass.getName()));
		return q.getResultList();
	}
	
	public <E> E findGraph(Class cls, Object id, String ...graph) {
		EntityGraph<E> eg = em.createEntityGraph(cls);
		Arrays.asList(graph).forEach(g-> eg.addAttributeNodes(g));
		Map<String, Object> props = new HashMap<>();
		props.put("javax.persistence.fetchgraph", eg);
		Object entity = em.find(cls, id, props);
		return (E) entity;
	}
}
