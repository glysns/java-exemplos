# Digytal - Programação, Pesquisa e Educação
www.digytal.com.br
(11) 95894 0362

# Java Exemplos - Spring Configuration Properties
Projeto open source que explora os recursos via applications.properties.

#### Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

###Introdução
As propriedades do aplicativo nos ajudam a trabalhar em diferentes ambientes. Neste capítulo, você aprenderá como configurar e especificar as propriedades para um aplicativo Spring Boot.

####application.properties
Os arquivos de propriedades são usados ​​para manter o número 'N' de propriedades em um único arquivo para executar o aplicativo em um ambiente diferente. No Spring Boot, as propriedades são mantidas no arquivo application.properties no classpath.

O arquivo application.properties está localizado no diretório src / main / resources . O código para o arquivo application.properties de amostra é fornecido abaixo

```
nome="digytal"
email="gleyson@digytal.com.br"
```
####Uso da anotação @Value
A anotação @Value é usada para ler o ambiente ou o valor da propriedade do aplicativo no código Java. A sintaxe para ler o valor da propriedade é mostrada abaixo -
```
@Value("${property_key_name}")
```
![](https://github.com/glysns/java-exemplos/blob/main/java-swing/desktop-utils/src/main/resources/window-builder-install.png)

Nota - Se a propriedade não for encontrada durante a execução do aplicativo, Spring Boot lança a exceção de Argumento Ilegal como Não foi possível resolver o marcador 'spring.application.name' no valor "$ {remetente}" .
Para resolver o problema do espaço reservado, podemos definir o valor padrão para a propriedade usando a sintaxe fornecida abaixo:
```
@Value("${remetente:gleyson@digytal.com.br}")
```


####Listas
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


####Propriedades Externalizadas
Em vez de manter o arquivo de propriedades no caminho de classe, podemos manter as propriedades em locais ou caminhos diferentes. Ao executar o arquivo JAR, podemos especificar o caminho do arquivo de propriedades. Você pode usar o seguinte comando para especificar a localização do arquivo de propriedades ao executar o JAR -
```
-Dspring.config.location = C:\application.properties
```
![](https://github.com/glysns/java-exemplos/blob/main/java-swing/desktop-utils/src/main/resources/window-builder-install.png)




### Inicialização

- Execute a classe `digytal.java.PropertiesApplication`.

#####Referências
* https://www.tutorialspoint.com/spring_boot/spring_boot_application_properties.htm

