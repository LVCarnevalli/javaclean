package br.community.javaclean.gateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.domains.exceptions.PokemonIntegrationException;
import br.community.javaclean.domains.logs.LogKey;
import br.community.javaclean.gateways.feign.PokemonClient;
import br.community.javaclean.gateways.feign.assembler.PokemonInfoToPokemonAssembler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PokemonGatewayImpl implements PokemonGateway {

  private final PokemonClient pokemonClient;
  private final PokemonInfoToPokemonAssembler pokemonInfoToPokemonAssembler;

  @Autowired
  public PokemonGatewayImpl(
      PokemonClient pokemonClient, PokemonInfoToPokemonAssembler pokemonInfoToPokemonAssembler) {
    this.pokemonClient = pokemonClient;
    this.pokemonInfoToPokemonAssembler = pokemonInfoToPokemonAssembler;
  }

  @Override
  public Pokemon detail(String name) {
    log.info("Detail pokemon with name {}", LogKey.value(LogKey.POKEMON_NAME, name));

    try {
      return pokemonInfoToPokemonAssembler.assemble(pokemonClient.detail(name));
    } catch (RuntimeException exception) {
      log.error("Occurred exception in pokemon client detail", exception);
      throw new PokemonIntegrationException(exception);
    }
  }
}
