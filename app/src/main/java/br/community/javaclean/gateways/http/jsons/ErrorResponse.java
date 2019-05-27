package br.community.javaclean.gateways.http.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ErrorResponse {

  public static final String UNPROCESSABLE_ENTITY = "error.unprocessableEntity";
  public static final String INTERNAL_SERVER_ERROR = "error.internalServerError";

  public static final String POKEMON_NOT_FOUND = "error.pokemon.notFound";

  private final String message;

  public ErrorResponse(String message) {
    this.message = message;
  }

  public static ErrorResponse build(String message) {
    return new ErrorResponse(message);
  }
}
