# Digytal - Programação, Pesquisa e Educação
www.digytal.com.br
(11) 95894 0362

# Java Exemplos - Spring Configuration Properties
Projeto open source que explora os recursos via applications.properties.

#### Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

### Introdução
As propriedades do aplicativo nos ajudam a trabalhar em diferentes ambientes. Neste capítulo, você aprenderá como configurar e especificar as propriedades para um aplicativo Spring Boot.

#### application.properties
Os arquivos de propriedades são usados ​​para manter o número 'N' de propriedades em um único arquivo para executar o aplicativo em um ambiente diferente. No Spring Boot, as propriedades são mantidas no arquivo application.properties no classpath.

O arquivo application.properties está localizado no diretório src / main / resources . O código para o arquivo application.properties de amostra é fornecido abaixo

```
nome="digytal"
email="gleyson@digytal.com.br"
```
#### Uso da anotação @Value
A anotação @Value é usada para ler o ambiente ou o valor da propriedade do aplicativo no código Java. A sintaxe para ler o valor da propriedade é mostrada abaixo -
```
@Value("${property_key_name}")
```
![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-properties/src/main/resources/properties_value.png)

Nota - Se a propriedade não for encontrada durante a execução do aplicativo, Spring Boot lança a exceção de Argumento Ilegal como Não foi possível resolver o marcador 'spring.application.name' no valor "$ {remetente}" .
Para resolver o problema do espaço reservado, podemos definir o valor padrão para a propriedade usando a sintaxe fornecida abaixo:
```
@Value("${remetente:gleyson@digytal.com.br}")
```
#### application.properties ternário
É possivel mudar o valor de uma propriedade em tempo de execução sem a necessidade de expor esta propriedade fora da aplicação, pode-se criar um parametro que o usuário passa a declarar para ser utilizada nas configurações reais:

* Imagina que a aplicação seja instalada para diferentes instâncias de banco de dados onde o usário e senha serão diferentes:
```
spring.datasource.username=${DATABASE_USER:postgres}
spring.datasource.password=${DATABASE_PASSWORD:postgres}
```

* Mudando o usuário do banco de dados através da variável `DATABASE_USER`
```
java -jar spring-properties-1.0.jar --DATABASE_USER=admin
```

#### Listas
A anotação @Value também suporta valores do tipo List conforme exemplos abaixo:
* `application.properties`
  ```
  destinatarios="huguinho@gmail.com","luizinho@hotmail.com","zezinho@yahoo.com"
  ```
* `EmailService`
  ```
  @Value("${destinatarios}")
  private List<String>destinatarios;
  ```
#### Criando um objeto através do application.properties 
É muito simples criar um objeto com o `application.properties` basta em sua classe incluir as anotações abaixo:

* `application.properties`
  ```
   ##OBTENDO Objeto com os atributos com a Anotação @Configuration e @ConfigurationProperties(prefix = "ftp") do Spring
   ftp.host:localhost
   ftp.port:21
   ftp.user:digytal
   ftp.pass:javaexemplos
  ```
* `FtpCredencial`
  ```
   @Configuration
   @ConfigurationProperties(prefix = "ftp")
  ```
![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-properties/src/main/resources/config_properties.png)


#### Propriedades Externalizadas
Em vez de manter o arquivo de propriedades no caminho de classe, podemos manter as propriedades em locais ou caminhos diferentes. Ao executar o arquivo JAR, podemos especificar o caminho do arquivo de propriedades. Você pode usar o seguinte comando para especificar a localização do arquivo de propriedades ao executar o JAR -
```
-Dspring.config.location = C:\application.properties
```
![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-properties/src/main/resources/externalized_properties.jpg)

#### Perfil da Aplicação
Vamos entender como ter o perfil ativo do Spring em application.properties. Por padrão, aplicativo. propriedades serão usadas para executar o aplicativo Spring Boot. Se você quiser usar propriedades baseadas em perfil, podemos manter arquivos de propriedades separados para cada perfil, conforme mostrado abaixo

* application.properties
```
server.port = 8080
spring.application.name = properties-app
```

* application-dev.properties
```
server.port = 9090
spring.application.name = properties-app
```

* application-prod.properties
```
server.port = 9191
spring.application.name = properties-app
```

* Definindo o perfil pelo arquivo selecionado:
```
java -jar spring-properties-1.0.jar --spring.profiles.active=dev
```

![](https://github.com/glysns/java-exemplos/blob/main/spring/spring-properties/src/main/resources/env.png)

### Inicialização

- Execute a classe `digytal.java.PropertiesApplication`.

##### Referências
* https://www.tutorialspoint.com/spring_boot/spring_boot_application_properties.htm

