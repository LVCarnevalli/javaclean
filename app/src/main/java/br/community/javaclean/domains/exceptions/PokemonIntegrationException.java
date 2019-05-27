package br.community.javaclean.domains.exceptions;

public class PokemonIntegrationException extends RuntimeException {

  public PokemonIntegrationException() {}

  public PokemonIntegrationException(String message) {
    super(message);
  }

  public PokemonIntegrationException(String message, Throwable cause) {
    super(message, cause);
  }

  public PokemonIntegrationException(Throwable cause) {
    super(cause);
  }

  public PokemonIntegrationException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
