package br.community.javaclean.domains.exceptions;

import org.springframework.http.HttpStatus;

import br.community.javaclean.gateways.http.jsons.ErrorResponse;
import lombok.Getter;

@Getter
public class JavaCleanException extends RuntimeException {

  private final HttpStatus httpStatus;
  private final ErrorResponse errorResponse;

  public JavaCleanException(HttpStatus httpStatus, ErrorResponse errorResponse) {
    this.httpStatus = httpStatus;
    this.errorResponse = errorResponse;
  }
}
