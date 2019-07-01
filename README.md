JAVA Clean
======================
[![Build Status](https://travis-ci.org/LVCarnevalli/javaclean.svg?branch=master)](https://travis-ci.org/LVCarnevalli/javaclean) [![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=br.community:javaclean&metric=alert_status)](https://sonarcloud.io/dashboard?id=br.community:javaclean) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=br.community%3Ajavaclean&metric=coverage)](https://sonarcloud.io/dashboard?id=br.community%3Ajavaclean) <a href="https://github.com/osvaldjr/easy-cucumber"><img  src="https://img.shields.io/badge/use-easycucumber-green.svg"/></a>


Estrutura de projeto JAVA abrangendo implementação do clean architecture, features toggles e pirâmide de testes.

<p align="center">
  <img src="https://github.com/LVCarnevalli/javaclean/blob/master/explanation.jpg?raw=true" width="800 "align="center" />
</p>

## Conteúdo

- [Referência](https://github.com/LVCarnevalli/javaclean#refer%C3%AAncia)
- [Tecnologias](https://github.com/LVCarnevalli/javaclean#tecnologias)
- [Pré-requisitos](https://github.com/LVCarnevalli/javaclean#pr%C3%A9-requisitos)
- [Como utilizar](https://github.com/LVCarnevalli/javaclean#como-utilizar)
- [Atenção](https://github.com/LVCarnevalli/javaclean#aten%C3%A7%C3%A3o)
- [Créditos](https://github.com/LVCarnevalli/javaclean#cr%C3%A9ditos)
- [Licença](https://github.com/LVCarnevalli/javaclean#licen%C3%A7a)

## Referência

<p align="center">
  <img src="https://github.com/LVCarnevalli/javaclean/blob/master/pyramid_test.jpg?raw=true" width="400 "align="center" />
</p>

O projeto JAVA Clean têm como objetivo demonstrar como é simples trabalhar com toggles, clean architecture (não o by the book) e testes possibilitando o trunk based development.

A pirâmide de testes implementada nesse projeto têm como referência o documento [Microservice Testing](https://martinfowler.com/articles/microservice-testing/) com algumas adaptações. Basicamente a implementação têm o seguinte princípio:

>**Unitário**: Testa isoladamente as classes, o objetivo desse teste é validar se a regra da classe está funcionando corretamente sem precisar subir qualquer contexto de framework ou integrações.

>**Integração**: Teste que valida a integração, necessita que simule um contexto externo para testar a regra da classe, por exemplo, bancos em memória e contextos de um framework.

>**Componente**: Testa as regras de negócio da aplicação como um todo, mockando todas as depedências. Geralmente são testes que fazem um request e dado os mocks esperam por uma resposta específica.

>**Performance**: Teste que valida a performance da aplicação como um todo, mockando todas as depedências. Se algo aumentar o tempo de resposta é uma camada que pegaria o problema, esse teste não têm como objetivo validar a performance da integração.

>**Segurança**: Teste que vai verificar falhas de segurança que podem ser exploradas através do contrato da API. Em alguns casos pode até ser considerado um teste de contrato pois o contrato da API será validado de diversas formas nesse teste.

Os testes de E2E não se aplica a esse projeto, mais pra frente pretendemos colocar um exemplo de uma aplicação frontend integrando com o serviço, e todo o fluxo testado com o E2E. Esse projeto têm como objetivo mostrar os testes sendo executados de maneira isoladas em uma aplicação.

## Tecnologias
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [FF4j](https://ff4j.github.io/)
- [Swagger](https://swagger.io/)
- [Feign](https://github.com/OpenFeign/feign)
- [JUnit 5](https://junit.org/junit5/), [Factory Fixture](https://github.com/six2six/fixture-factory), [Hamcrest](http://hamcrest.org/JavaHamcrest/tutorial), [Easy Random](https://github.com/j-easy/easy-random) e [Mockito](https://site.mockito.org/) (Testes unitários)
- [Spock](http://spockframework.org/) (Testes unitários de regra de negócio)
- [Gatling](https://gatling.io/) (Testes de performance)
- [Cucumber](https://cucumber.io/) (Testes de componente)
- [OWASP Zap](https://github.com/zaproxy/zaproxy) (Testes de segurança)

## Pré-requisitos
- JDK 8
- Maven
- Docker
- Docker Compose 3

## Como utilizar
#### Iniciar a aplicação
```shell
mvn clean verify -f app/pom.xml
mvn spring-boot:run -f app/pom.xml
```
Por padrão a aplicação sobe na porta 8080.<br><br>
Swagger: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) <br>
Console FF4J: [http://localhost:8080/ff4j-web-console/](http://localhost:8080/ff4j-web-console/)
#### Executar testes de componente, performance ou segurança
```shell
mvn clean verify -f component-test/pom.xml
mvn clean verify -f performance-test/pom.xml
mvn clean verify -f security-test/pom.xml (Está sendo implementado)
```
Os testes são executados através do docker-compose, enquanto os testes estão rodando o docker é iniciado e ao término da execução o docker é desligado.

**Reports**
- Component test: target/cucumber-html-reports/overview-features.html
- Performance test: target/gatling/pokemonsimulation-*/index.html
- Security test: target/security-reports/*-scan-report.html

## Atenção
- Ao alterar a versão do docker compose é necessário verificar se o plugin utilizado no pom.xml suporta.
- Toda vez que houver alguma alteração na aplicação é necessário compilar e realizar o build do docker compose novamente, pois assim o docker estará utilizando a versão atual da aplicação.

## Créditos
[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/0)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/0)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/1)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/1)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/2)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/2)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/3)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/3)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/4)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/4)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/5)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/5)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/6)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/6)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/7)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/7)

## Licença
Esse projeto possui licença MIT license, veja [LICENSE.md](LICENSE.md) para mais detalhes.
