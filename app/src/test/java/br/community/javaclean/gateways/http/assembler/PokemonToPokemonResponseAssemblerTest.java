package br.community.javaclean.gateways.http.assembler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import br.community.javaclean.conf.UnitTest;
import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.domains.enums.Ability;
import br.community.javaclean.gateways.http.jsons.pokemon.PokemonResponse;

class PokemonToPokemonResponseAssemblerTest extends UnitTest {

  @InjectMocks private PokemonToPokemonResponseAssembler pokemonToPokemonResponseAssembler;

  @Test
  void shouldAssemble() {
    Pokemon pokemon = from("a valid pokemon", Pokemon.class);

    PokemonResponse pokemonResponse = pokemonToPokemonResponseAssembler.assemble(pokemon);

    assertThat(pokemonResponse, notNullValue());
    assertThat(
        pokemonResponse.getAbilities(), equalTo(Arrays.asList(Ability.LIMBER, Ability.OVERGROW)));
    assertThat(pokemonResponse.getBaseExperience(), equalTo(2000));
    assertThat(pokemonResponse.getHeight(), equalTo(12));
    assertThat(pokemonResponse.getName(), equalTo("ditto"));
    assertThat(pokemonResponse.getWeight(), equalTo(21));
  }
}
