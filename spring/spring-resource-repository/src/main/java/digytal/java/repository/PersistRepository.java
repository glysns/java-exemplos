package digytal.java.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersistRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(Object entity) {
		em.persist(entity);
	}
	
	public <E> E find(Class entityClass, Object id) {
		return (E) em.find(entityClass, id);
	}
}
