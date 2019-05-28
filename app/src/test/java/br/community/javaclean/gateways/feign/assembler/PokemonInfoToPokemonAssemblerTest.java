package br.community.javaclean.gateways.feign.assembler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import br.community.javaclean.confs.UnitTest;
import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.domains.enums.Ability;
import br.community.javaclean.gateways.feign.jsons.pokemon.PokemonInfo;

class PokemonInfoToPokemonAssemblerTest extends UnitTest {

  @InjectMocks private PokemonInfoToPokemonAssembler pokemonInfoToPokemonAssembler;

  @Test
  void shouldAssemble() {
    PokemonInfo pokemonInfo = fromJson("a valid pokemon info", PokemonInfo.class);

    Pokemon pokemon = pokemonInfoToPokemonAssembler.assemble(pokemonInfo);

    assertThat(pokemon, notNullValue());
    assertThat(pokemon.getAbilities(), equalTo(Arrays.asList(Ability.LIMBER)));
    assertThat(pokemon.getBaseExperience(), equalTo(101));
    assertThat(pokemon.getHeight(), equalTo(3));
    assertThat(pokemon.getId(), equalTo(132));
    assertThat(pokemon.getName(), equalTo("ditto"));
    assertThat(pokemon.getWeight(), equalTo(40));
  }
}
