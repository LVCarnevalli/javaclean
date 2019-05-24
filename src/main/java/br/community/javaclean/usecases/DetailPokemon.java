package br.community.javaclean.usecases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.gateways.PokemonGateway;
import javassist.NotFoundException;

@Component
public class DetailPokemon {

  private final PokemonGateway pokemonGateway;

  @Autowired
  public DetailPokemon(PokemonGateway pokemonGateway) {
    this.pokemonGateway = pokemonGateway;
  }

  public Pokemon execute(Integer id, String name) throws NotFoundException {
    Pokemon pokemon = pokemonGateway.detail(name);

    if (!Optional.ofNullable(pokemon).isPresent() || !pokemon.getId().equals(id)) {
      throw new NotFoundException("Pokemon not found");
    }
    return pokemon;
  }
}
