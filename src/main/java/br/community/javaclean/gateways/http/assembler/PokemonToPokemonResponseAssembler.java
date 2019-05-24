package br.community.javaclean.gateways.http.assembler;

import org.springframework.stereotype.Component;

import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.gateways.http.jsons.pokemon.PokemonResponse;

@Component
public class PokemonToPokemonResponseAssembler {

  public PokemonResponse assemble(Pokemon data) {
    return PokemonResponse.builder()
        .name(data.getName())
        .abilities(data.getAbilities())
        .baseExperience(data.getBaseExperience())
        .weight(data.getWeight())
        .height(data.getHeight())
        .build();
  }
}
