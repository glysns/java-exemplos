package digytal.java.resource;

import digytal.java.commons.Dto;
import digytal.java.repository.CrudRepository;

public abstract class ResourceRepository<D extends Dto> extends CrudRepository<D>{
	public void process(D dto) {} ;	
}
