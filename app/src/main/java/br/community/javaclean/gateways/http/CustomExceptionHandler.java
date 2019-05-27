package br.community.javaclean.gateways.http;

import static br.community.javaclean.gateways.http.jsons.ErrorResponse.INTERNAL_SERVER_ERROR;
import static br.community.javaclean.gateways.http.jsons.ErrorResponse.UNPROCESSABLE_ENTITY;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.community.javaclean.domains.exceptions.JavaCleanException;
import br.community.javaclean.domains.exceptions.PokemonIntegrationException;
import br.community.javaclean.gateways.http.jsons.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(JavaCleanException.class)
  @ResponseBody
  public ResponseEntity handleJavaClean(JavaCleanException exception) {
    return ResponseEntity.status(exception.getHttpStatus()).body(exception.getErrorResponse());
  }

  @ExceptionHandler(PokemonIntegrationException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public ErrorResponse handlePokemonIntegration(PokemonIntegrationException exception) {
    return ErrorResponse.build(UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse handleException(Exception exception) {
    return ErrorResponse.build(INTERNAL_SERVER_ERROR);
  }
}
