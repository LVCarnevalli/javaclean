package br.community.javaclean.usecases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.domains.exceptions.NotFoundException;
import br.community.javaclean.domains.types.Features;
import br.community.javaclean.gateways.PokemonGateway;
import br.community.javaclean.gateways.ff4j.FeatureGateway;

@Component
public class DetailPokemon {

  private final PokemonGateway pokemonGateway;

  private final FeatureGateway featureGateway;

  @Autowired
  public DetailPokemon(PokemonGateway pokemonGateway, FeatureGateway featureGateway) {
    this.pokemonGateway = pokemonGateway;
    this.featureGateway = featureGateway;
  }

  public Pokemon execute(Integer id, String name) {
    Pokemon pokemon;

    if (featureGateway.check(Features.FEATURE_DETAIL_POKEMON)) {
      pokemon = pokemonGateway.detail(name);
      if (!Optional.ofNullable(pokemon).isPresent() || !pokemon.getId().equals(id)) {
        throw new NotFoundException("Pokemon not found");
      }
    } else {
      throw new NotFoundException("Feature detail pokemon not enable");
    }
    return pokemon;
  }
}
