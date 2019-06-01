JAVA Clean
======================
[![Build Status](https://travis-ci.org/LVCarnevalli/javaclean.svg?branch=master)](https://travis-ci.org/LVCarnevalli/javaclean) [![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=br.community:javaclean&metric=alert_status)](https://sonarcloud.io/dashboard?id=br.community:javaclean) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=br.community%3Ajavaclean&metric=coverage)](https://sonarcloud.io/dashboard?id=br.community%3Ajavaclean) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


Estrutura de projeto Java abrangendo implementação do clean architecture, features toggles e toda pirâmide de testes.

<h1 align="center">
  <img src="https://github.com/LVCarnevalli/javaclean/blob/master/explanation.jpg?raw=true" width="800 "align="center" />
</h1>

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

## Utilizar
#### Iniciar a aplicação
```shell
mvn clean verify -f app/pom.xml
mvn spring-boot:run -f app/pom.xml
```
Por padrão a aplicação sobe na porta 8080, para acessar o Swagger acesse [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
#### Executar testes de componente, performance ou segurança
```shell
mvn clean test -f component-test/pom.xml
mvn clean test -f performance-test/pom.xml
mvn clean test -f security-test/pom.xml
```
Os testes são executados através do docker-compose, enquanto os testes estão rodando o docker é iniciado e ao término da execução o docker é desligado.

## Atenção
- Ao alterar a versão do docker compose é necessário verificar se o plugin utilizado no pom.xml suporta.

## Créditos
[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/0)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/0)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/1)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/1)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/2)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/2)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/3)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/3)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/4)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/4)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/5)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/5)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/6)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/6)[![](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/images/7)](https://sourcerer.io/fame/LVCarnevalli/LVCarnevalli/javaclean/links/7)
