package br.community.javaclean.gateways.http;

import static br.community.javaclean.gateways.http.jsons.ErrorResponse.BAD_REQUEST;
import static br.community.javaclean.gateways.http.jsons.ErrorResponse.INTERNAL_SERVER_ERROR;
import static br.community.javaclean.gateways.http.jsons.ErrorResponse.UNPROCESSABLE_ENTITY;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.community.javaclean.domains.exceptions.JavaCleanException;
import br.community.javaclean.domains.exceptions.PokemonIntegrationException;
import br.community.javaclean.gateways.http.jsons.ErrorResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(JavaCleanException.class)
  @ResponseBody
  public ResponseEntity handleJavaClean(JavaCleanException exception) {
    log.warn("Throw JavaCleanException with message {}", exception.getMessage(), exception);
    return ResponseEntity.status(exception.getHttpStatus()).body(exception.getErrorResponse());
  }

  @ExceptionHandler(PokemonIntegrationException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public ErrorResponse handlePokemonIntegration(PokemonIntegrationException exception) {
    log.error(
        "Throw PokemonIntegrationException with message {}", exception.getMessage(), exception);
    return ErrorResponse.build(UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse handleException(Exception exception) {
    log.error("Throw Exception with message {}", exception.getMessage(), exception);
    return ErrorResponse.build(INTERNAL_SERVER_ERROR);
  }

  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ValidationException.class)
  public ErrorResponse handleValidation(ValidationException exception) {
    log.warn("Throw ValidationException with message {}", exception.getMessage(), exception);
    return ErrorResponse.build(BAD_REQUEST);
  }

  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public ErrorResponse handleConstraintViolation(ConstraintViolationException exception) {
    log.warn(
        "Throw ConstraintViolationException with message {}", exception.getMessage(), exception);
    return ErrorResponse.build(BAD_REQUEST);
  }
}
