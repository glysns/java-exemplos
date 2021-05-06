package digytal.java.repository;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import digytal.java.commons.Model;
import digytal.java.commons.SimpleModel;
import digytal.java.infra.converter.ModelConveter;
import digytal.java.infra.sql.Condition;
import digytal.java.infra.sql.JPQLUtil;

//SEARCH REPOSITORY
public abstract class CrudRepository <D> {
	@PersistenceContext
	protected EntityManager em;
	protected Class<D> dto;
	public CrudRepository() {
		this.dto = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	private Class getEntity() {
		return getEntity(dto);
	}
	private Class getEntity(Class cls) {
		try {
			return Class.forName(String.format("%s.%sEntity", cls.getPackage().getName(), cls.getSimpleName().replaceAll("Entity", "")));
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	private Class getEntityView(Class cls) {
		Class clazz = null;
		String sname = cls.getSimpleName().replaceAll("Entity", "").replaceAll("View", "");
		try {
			clazz = Class.forName(String.format("%s.%sView", cls.getPackage().getName(), sname));
		} catch (ClassNotFoundException e) {
			try {
				clazz = Class.forName(String.format("%s.%sEntity", cls.getPackage().getName(), sname));
			} catch (ClassNotFoundException ex) {
				return null;
			}
		}
		return clazz;
	}
	protected Object insert(Object instance) {
		try {
			Model entity = null;
			if(instance instanceof Model) {
				entity =(Model) instance;
			}else {
				entity = ModelConveter.getInstance(instance).newInstance();
			}
			commit(entity);
			return entity.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao converter a requisição " + instance.getClass().getName());
		}
	}
	
	private Object commit(Model entity) {
		Object id = entity.getId();
		if (id != null)
			em.merge(entity);
		else {
			em.persist(entity);
			em.flush();
			id = entity.getId();
		}
		return id;
	}
	
	protected boolean exists(String field, Object param) {
		return findBy(field, param)!=null;
	}
	protected <D>D findBy(String field, Object param) {
		try {
			String sql = String.format("SELECT e FROM  %s e WHERE e.%s = :param", dto.getName(),field);
			Object entity= em.createQuery(sql).setParameter("param", param ).getSingleResult();
			return (D) entity;
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}
	protected <E> E find(Object id) {
		Object entity = em.find(getEntity(), id);
		return (E) entity;
	}
	protected <E> E find(Class type, Object id) {
		Object entity = em.find(getEntity(type), id);
		return (E) entity;
		//return convert(entity);
	}
	//"conditions": {"nome":"NOTEBOOK DELL 2X1 INSPIRON"}
	protected <E> List<E> list() {
		return list(dto);
	}
	protected <E> List<E> list(Class cls) {
		return list(cls, new HashMap<>());
	}
	protected <E> List<E> list(String field, Object value) {
		return list(Collections.singletonMap(field, value));
	}
	protected <E> List<E> list(Map<String, Object> conditions) {
		return list(dto,conditions);
	}
	
	protected <E> List<E> list(Class cls, Map<String, Object> conditions,String ... fields) {
		List<Condition> filter = filter(conditions);
		String select = String.format("SELECT e FROM %s e", getEntityView(cls).getName());
		if(fields.length>0) {
			select = String.format("SELECT NEW %s (%s) FROM %s e", SimpleModel.class.getName(),simpleModelFields(fields), getEntityView(cls).getName());
		}
		
		JPQLUtil jpql = JPQLUtil.of(select).conditions(filter);
		Query query = em.createQuery(jpql.sql());
		System.out.println(filter);
		jpql.params.entrySet().forEach(p->{
			query.setParameter(p.getKey(), p.getValue());
		});
		List list= query.getResultList();
		return list;
	}
	
	protected List<SimpleModel> simpleList(String field, Object value,String ... fields) {
		return simpleList(dto, field, value,fields);
	}
	
	protected List<SimpleModel> simpleList(Class cls, String field, Object value,String ... fields) {
		return simpleList(cls, Collections.singletonMap(field, value),fields);
	}
	
	protected List<SimpleModel> simpleList(Map<String, Object> conditions, String ... fields) {
		return simpleList(dto,conditions,fields);
	}
	
	
	protected List<SimpleModel> simpleList(Class cls, Map<String, Object> conditions, String ... fields) {
		return list(cls,conditions,fields);
	}
	
	private String simpleModelFields(String ... fields) {
		StringJoiner joiner = new StringJoiner(", ");
        for (CharSequence cs: fields) {
            joiner.add("e."+cs);
        }
        return joiner.toString();
	}
	protected List<Condition> filter(Map<String, Object> conditions){
		return conditions.entrySet().stream().map(c->{
			return Condition.of(c);
		}).collect(Collectors.toList());
	}
	
	
}
