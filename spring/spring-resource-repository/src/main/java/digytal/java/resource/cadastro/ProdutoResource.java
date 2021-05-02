package digytal.java.resource.cadastro;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.java.commons.http.Response;
import digytal.java.infra.exception.config.BusinessException;
import digytal.java.infra.sql.Condition;
import digytal.java.infra.sql.Search;
import digytal.java.model.produto.Produto;
import digytal.java.resource.ResourceRepository;

@RestController
@RequestMapping ("/produtos")
public class ProdutoResource extends ResourceRepository<Produto> {
	@PostMapping("/search")
	public Response search(@RequestBody Search search)  throws BusinessException {
		List list= list(search.conditions);
		return Response.ok(list);
	}
	public List<Condition> filter(Map<String, Object> conditions){
		return conditions.entrySet().stream().map(c->{
			Condition p = null;
			p = Condition.of(c);
			if(c.getKey().equals("anoFabricao"))
				p = Condition.of(c.getKey(), Condition.Operator.GREATER_EQUAL, c.getValue());
			return p;
		}).collect(Collectors.toList());
	}
}
