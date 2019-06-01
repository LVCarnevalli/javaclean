package br.community.javaclean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@SpringBootApplication(exclude = ThymeleafAutoConfiguration.class)
public class JavacleanApplication {

  public static void main(String[] args) {
    SpringApplication.run(JavacleanApplication.class, args);
  }
}
