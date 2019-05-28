package br.community.javaclean.gateways.http;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.community.javaclean.domains.exceptions.JavaCleanException;
import br.community.javaclean.domains.exceptions.PokemonIntegrationException;
import br.community.javaclean.gateways.http.jsons.ErrorResponse;

@RestController
class CustomExceptionHandlerTestController {

  @GetMapping("/shouldThrowJavacleanException")
  void shouldThrowJavacleanException() {
    throw new JavaCleanException(HttpStatus.NOT_FOUND, ErrorResponse.build("exception"));
  }

  @GetMapping("/shouldThrowPokemonIntegrationException")
  void shouldThrowPokemonIntegrationException() {
    throw new PokemonIntegrationException();
  }

  @GetMapping("/shouldThrowException")
  void shouldThrowException() {
    throw new RuntimeException();
  }

  @GetMapping("/shouldThrowValidationException")
  void shouldThrowValidationException() {
    throw new ValidationException("exception");
  }

  @GetMapping("/shouldThrowConstraintViolationException")
  void shouldThrowConstraintViolationException() {
    throw new ConstraintViolationException(null);
  }
}
