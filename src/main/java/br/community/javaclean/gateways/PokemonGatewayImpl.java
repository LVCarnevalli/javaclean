package br.community.javaclean.gateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.domains.exceptions.PokemonIntegrationException;
import br.community.javaclean.gateways.feign.PokemonClient;
import br.community.javaclean.gateways.feign.assembler.PokemonInfoToPokemonAssembler;

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
    try {
      return pokemonInfoToPokemonAssembler.assemble(pokemonClient.detail(name));
    } catch (RuntimeException exception) {
      throw new PokemonIntegrationException(exception);
    }
  }
}
