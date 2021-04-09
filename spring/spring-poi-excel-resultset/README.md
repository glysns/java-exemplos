# Digytal - Treinamento, Consultoria e Fábrica de Software
www.digytal.com.br
(11) 95894 0362

## Springboot - Apache POI

Projeto Spring para demonstração do uso de Springboot o Apache POI.

**NOTA: NÃO é necessário o projeto ser Springboot para uso do Apache POI **

#### Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

#### Estrutura do Projeto
Dividimos as classes em pacotes de acordo com suas responsabilidades.
- Model: Classes que represetam o modelo da aplicação na qual é necessário criar através da leitura do arquivo
- Util: pacote que contém a classe `digytal.java.util.ExcelResultSet` com toda lógica de leitura de arquivo.

##### No pom.xml inclua a dependência

```
<!-- APACHE POI -->
<dependency>
	<groupId>org.apache.poi</groupId>
	<artifactId>poi-ooxml</artifactId>
	<version>3.15</version>
</dependency>
```
> ** ExcelResultSet: Definição de uma classe Utilitária que lê registros através de uma planilha Excel com base na estrutura JDBC ResultSet**


#### Iniciando a aplicação

1. Execute a classe `digytal.java.SpringExcelResultSetApplication`: A aplicação será iniciada.

![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-poi-excel-resultset/src/main/resources/exrs-poi-sample.png)

##### Semelhante o ResultSet do JDBC podemos ler colunas do Excel pela Label (Cabeçalho) e já converter para os tipos específicos.
```
	ClassPathResource resourceFile = new ClassPathResource("transformadores.xlsx");
	File file =  resourceFile.getFile();

	ExcelResultSet exRs = new ExcelResultSet(file);

	while(exRs.next()) {
		String cpf = exRs.getString("Cpf");
		String nome = exRs.getString("Nome");
		LocalDate dtNascimento = exRs.getLocalDate("Data Nascimento");
		Sexo sexo = Sexo.valueOf(exRs.getString("Sexo").toUpperCase());
		Double valorHora = exRs.getDouble("Valor Hora");
		Boolean brasileiro = exRs.getBoolean("Brasileiro?", "S");

		System.out.println(String.format("O professor %s de Cpf %s, nascido em %s, no País %s do Sexo %s, com valor hora R$ %.2f ",
				nome,
				cpf,
				dtNascimento.toString(),
				brasileiro?"BRASIL":"EXTERIOR",
				sexo.getDescricao(),
				valorHora
				));		
```

* Deverá retornar no console algo do tipo:
```
O professor GLEYSON SAMPAIO de Cpf 465866936, nascido em 1984-04-30, no País BRASIL do Sexo Masculino, com valor hora R$ 150,00 
O professor FRANK MARLON de Cpf 84598745612, nascido em 1998-09-01, no País BRASIL do Sexo Masculino, com valor hora R$ 180,00 
O professor RAIMUNDO NONATO de Cpf 95148766852, nascido em 1981-07-10, no País EXTERIOR do Sexo Masculino, com valor hora R$ 150,00 
O professor FABIANA MACHADO de Cpf 44896544798, nascido em 1989-10-12, no País BRASIL do Sexo Feminino, com valor hora R$ 90,00 
```

