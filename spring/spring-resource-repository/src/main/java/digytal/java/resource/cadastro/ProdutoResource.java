package digytal.java.resource.cadastro;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.java.infra.sql.Condition;
import digytal.java.model.produto.Produto;
import digytal.java.resource.ResourceRepository;

@RestController
@RequestMapping ("/produtos")
public class ProdutoResource extends ResourceRepository<Produto> {
	public List<Condition> filter(Map<String, Object> conditions){
		return conditions.entrySet().stream().map(condition->{
			Condition param = Condition.of(condition);
			if(condition.getKey().equals("anoFabricacao"))
				param = Condition.of(condition, Condition.Operator.GREATER_EQUAL);
			return param;
		}).collect(Collectors.toList());
	}
}
