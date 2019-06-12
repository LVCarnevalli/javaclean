package br.community.javaclean.gateways;

import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.community.javaclean.confs.UnitTest;
import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.domains.exceptions.PokemonIntegrationException;
import br.community.javaclean.gateways.feign.PokemonClient;
import br.community.javaclean.gateways.feign.assembler.PokemonInfoToPokemonAssembler;
import br.community.javaclean.gateways.feign.jsons.pokemon.PokemonInfo;
import io.github.glytching.junit.extension.random.Random;

class PokemonGatewayTest extends UnitTest {

  @Mock private PokemonClient pokemonClient;
  @Mock private PokemonInfoToPokemonAssembler pokemonInfoToPokemonAssembler;
  @InjectMocks private PokemonGatewayImpl pokemonGateway;

  @Test
  void shouldDetailPokemon(
      @Random String name, @Random PokemonInfo mockPokemonInfo, @Random Pokemon mockPokemon) {
    when(pokemonClient.detail(name)).thenReturn(mockPokemonInfo);
    when(pokemonInfoToPokemonAssembler.assemble(mockPokemonInfo)).thenReturn(mockPokemon);

    Pokemon pokemon = pokemonGateway.detail(name);

    assertThat(pokemon, equalToObject(mockPokemon));
    verify(pokemonClient, times(1)).detail(name);
    verify(pokemonInfoToPokemonAssembler, times(1)).assemble(mockPokemonInfo);
  }

  @Test
  void shouldThrowErrorInClient(@Random String name) {
    when(pokemonClient.detail(anyString())).thenThrow(new RuntimeException());

    assertThrows(PokemonIntegrationException.class, () -> pokemonGateway.detail(name));

    verify(pokemonInfoToPokemonAssembler, never()).assemble(any(PokemonInfo.class));
  }
}
