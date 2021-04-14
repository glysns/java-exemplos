# Digytal - Programação, Pesquisa e Educação
www.digytal.com.br
(11) 95894 0362

## Springboot - Postgres - FlyWay - Migration

Projeto Spring para demonstração do uso de Springboot, Postgres e Controle de Versão de Scripts com FlyWay

* Flyway é uma dentre as várias ferramentas que se propõem a trazer ordem e organização para os scripts SQL que são executados no banco de dados, funcionando como um controle de versão do mesmo.


#### Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

#### Requisitos
###### [Database Versioning With Flyway and Java](https://dzone.com/articles/database-versioning-with-flyway-and-java)
###### [Flyway: Naming Patterns Matter](https://www.red-gate.com/blog/database-devops/flyway-naming-patterns-matter)

#### Estrutura do Projeto
Dividimos as classes em pacotes de acordo com suas responsabilidades.
- Model: onde definimos os modelos ou seja as classes dos objetos que usamos no sistema
- Repository: onde definimos o JPA para acessar os dados do BD
- Resource: também chamado de Controller foi onde definimos a exponsição dos recursos via API por meio da definição dos endpoints
- Config: onde definimos as configurações do Swagger para documentar a API

#### Configuração do Banco para usar o Spring Data Jpa

##### Precisamos adicionar duas novas dependencias em nosso projeto: O starter do Spring Data Jpa e o banco de sua preferencia, no exemplo estamos usando o H2

```
<!-- RECURSOS DO JPA COM SPRING -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- BANCO EM MEMORIA -->
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
    
```

##### Definindo a classe `digytal.java.model.Endereco` como Entidade JPA: 
Uma entidade é uma classe contendo a anotação `javax.persistence.@Entity` e um atributo com a anotação `javax.persistence.@Id` que nosso caso é o próprio `cep` por não permitir valores duplicados (NOTA: No nosso exemplo, um Endereço representa um Código Postal)

##### Criando o repositório `digytal.java.repository.EnderecoRepository` que é uma interface que extends de `org.springframework.data.repository.CrudRepository`:
Com SprinDataJpa é abstraído todo o algorítimo de persistência necessária para realizar um CRUD simples. 


##### Agora precisamos informar os dados de conexão no arquivo `application.properties`
  * Habilitar o H2 Console em http://localhost:8080/h2-console:
  ``` 
  spring.h2.console.enabled=true
  spring.h2.console.path=/h2-console
  ```
   * Algumas versões do Spring tem exigido adicionar estas configurações no `application.properties`
  ``` 
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=
  spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
  ```
   
  * Exibir as intruções SQL executadas pela aplicação
  ``` 
  spring.jpa.show-sql=true
  ```
  
  * Testando em http://localhost:8080/h2-console:
  ``` 
  JDBC URL: jdbc:h2:mem:testdb
  User Name: sa
  Pasword: <deixa vazio>
  ``` 
 
#### Configuração do Swagger

A configuração do Swagger é bem simples, você só precisar criar um **@Bean** de **Docket** conforme a classe `digytal.java.config.SwaggerConfig`.

> NOTA 1: Mude o nome do pacote onde estão localizados os resources conforme linha 27.

> NOTA 2: Avalie as anotações do Swagger existentes nas classes digytal.java.model.Endereco e digytal.java.resource.EnderecoResource, estas anotações ajudam a documentar a API com o Swagger


#### Iniciando a aplicação

1. Execute a classe `digytal.java.SpringRestApiJpaApplication`: A aplicação será iniciada.
   * Esta classe contém um Bean que realizar uma instrução de exemplo de inclusão de Endereço.
   ```
	@Bean
	public CommandLineRunner run(EnderecoRepository repository) throws Exception {
		return args -> {
			Endereco end = new Endereco("01001000", "Praça da Sé", "Sé", "São Paulo");
			repository.save(end);
		};
	}
   ```
   
3. Digite no navegador `http://localhost:8080/swagger-ui.html`

#### Será disponível a pagina do Swagger exibindo todos os recursos da API.

![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-rest-api/src/main/resources/swagger.png)

#### Realizando um teste de cadastro de CEP
```
POST: http://localhost:8080/enderecos
{
  "bairro": "Norte",
  "cep": "65180000",
  "localidade": "Humberto de Campos",
  "logradouro": "Rua da Consolação"
}
```

> Deverá retornar status 200

3. Digite no navegador `http://localhost:8080/h2-console/`

![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-jpa-rest-api/src/main/resources/h2.png)
![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-jpa-rest-api/src/main/resources/h2-console.png)

#### Veja também

###### [Criando uma Rest API com Springboot](https://github.com/glysns/java-exemplos/tree/main/spring/spring-rest-api)
