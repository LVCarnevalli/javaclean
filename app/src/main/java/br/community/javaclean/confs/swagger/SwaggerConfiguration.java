package br.community.javaclean.confs.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  @Autowired private Docket docket;

  @PostConstruct
  public Docket api() {
    return docket
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.community.javaclean"))
        .paths(regex("/api/.*"))
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("JAVA Clean").version("1.0").build();
  }
}
