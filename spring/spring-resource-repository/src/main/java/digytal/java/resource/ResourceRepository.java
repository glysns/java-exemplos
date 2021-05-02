package digytal.java.resource;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import digytal.java.commons.http.Response;
import digytal.java.infra.exception.config.BusinessException;
import digytal.java.infra.sql.Search;
import digytal.java.repository.CrudRepository;

public abstract class ResourceRepository<D> extends CrudRepository<D>{
	protected void process(D dto) throws BusinessException {} ;	
	@PostMapping("/save")
	@Transactional
	public Response post(@RequestBody D instance)  throws RuntimeException {
		process	(instance);
		Object response= insert(instance);
		return Response.ok(response);
	}
	@GetMapping("/one/{id}")
	public Response one(@PathVariable("id") Integer id)  throws BusinessException {
		Object model= find(id);
		return Response.ok(model);
	}
	@GetMapping("/all/")
	public Response all()  throws BusinessException {
		return Response.ok(list());
	}
		@PostMapping(path="/search")
	public List search(@RequestBody Search search) {
		return list(search.conditions);
	}
}
