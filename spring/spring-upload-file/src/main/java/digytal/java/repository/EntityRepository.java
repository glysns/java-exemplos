package digytal.java.repository;

import org.springframework.data.repository.CrudRepository;

import digytal.java.model.Entity;

public interface EntityRepository extends CrudRepository<Entity, Integer> {

}
