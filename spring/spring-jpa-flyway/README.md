# Digytal - Programação, Pesquisa e Educação
www.digytal.com.br
(11) 95894 0362

## Springboot - PostgreSQL - FlyWay - Migration

Projeto Spring para demonstração do uso de Springboot, Postgres e Controle de Versão de Scripts com FlyWay

* Flyway é uma dentre as várias ferramentas que se propõem a trazer ordem e organização para os scripts SQL que são executados no banco de dados, funcionando como um controle de versão do mesmo.


#### Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

#### Requisitos
###### [Database Versioning With Flyway and Java](https://dzone.com/articles/database-versioning-with-flyway-and-java)
###### [Flyway: Naming Patterns Matter](https://www.red-gate.com/blog/database-devops/flyway-naming-patterns-matter)
![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-rest-api/src/main/resources/swagger.png)

#### Estrutura do Projeto
Nosso foco aqui é na pasta `src/main/resources` 
- Dentro da pasta `resources` criamos uma pasta `db`
- Dentro da pasta `db` criamos uma pasta `migration`
- Dentro da pasta `migration` criamos 03 arquivos .sql conforme abaixo:
	- **V1__create_schema_one.sql**: Contém script para gerar o `shema_one`.
	- **V2__create_schema_two.sql**: Contém script para gerar o `shema_two`.
	- **V3__carga_ceps.sql**: Contém script para realizar uma carga de ceps. **NOTA**: Foi necessário criar via script a tabela `schema_one.tab_endereco`   

#### Configuração do Postgres e Flyway

##### Precisamos adicionar duas novas dependencias em nosso projeto

```
<!-- FLY WAY -->
<dependency>
	<groupId>org.flywaydb</groupId>
	<artifactId>flyway-core</artifactId>
</dependency>

<!-- POSTGRES -->
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>
    
```


##### Agora precisamos informar os dados de conexão no arquivo `application.properties`
 ``` 
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://${DATABASE_HOST:localhost}:${DATABASE_PORT:5432}/${DATABASE_NAME:db_flyway}?stringtype=unspecified

spring.datasource.username=${DATABASE_USER:postgres}
spring.datasource.password=${DATABASE_PASSWORD:postgres}
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.jpa.show-sql=true
 ```
 
 
 
#### Iniciando a aplicação

1. Execute a classe `digytal.java.SpringJpaFlyWayApplication`: A aplicação será iniciada.
   	* Esta classe contém um Bean que realizar uma instrução de exemplo de inclusão de Endereço (comentado).
   

#### Veja também

###### [Criando uma Rest API com Springboot](https://github.com/glysns/java-exemplos/tree/main/spring/spring-rest-api)
