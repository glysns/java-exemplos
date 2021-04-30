package digytal.java.repository;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import digytal.java.commons.Dto;

public abstract class CrudRepository<D extends Dto> {
	@PersistenceContext
	protected EntityManager em;

	protected Class<D> dto;

	public CrudRepository() {
		this.dto = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
}