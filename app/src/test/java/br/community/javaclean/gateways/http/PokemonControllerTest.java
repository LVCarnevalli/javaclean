package br.community.javaclean.gateways.http;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.MessageFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.community.javaclean.confs.HTTPUnitTest;
import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.domains.exceptions.JavaCleanException;
import br.community.javaclean.gateways.http.assembler.PokemonToPokemonResponseAssembler;
import br.community.javaclean.gateways.http.jsons.ErrorResponse;
import br.community.javaclean.gateways.http.jsons.pokemon.PokemonResponse;
import br.community.javaclean.usecases.DetailPokemon;
import io.github.glytching.junit.extension.random.Random;
import javassist.NotFoundException;

class PokemonControllerTest extends HTTPUnitTest {

  @Mock private DetailPokemon detailPokemon;
  @Mock private PokemonToPokemonResponseAssembler pokemonToPokemonResponseAssembler;
  @InjectMocks private PokemonController pokemonController;
  private MockMvc mockMvc;

  @BeforeEach
  void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(pokemonController).build();
  }

  @Test
  void shouldDetailPokemon(@Random Pokemon pokemon, @Random PokemonResponse pokemonResponse)
      throws Exception {
    Integer id = 1;
    String name = "ditto";
    when(detailPokemon.execute(id, name)).thenReturn(pokemon);
    when(pokemonToPokemonResponseAssembler.assemble(pokemon)).thenReturn(pokemonResponse);

    mockMvc
        .perform(get(MessageFormat.format("/api/v1/pokemon/{0}/{1}", id, name)))
        .andExpect(status().isOk())
        .andExpect(content().string(asJson(pokemonResponse)))
        .andReturn();

    verify(detailPokemon, times(1)).execute(anyInt(), anyString());
    verify(pokemonToPokemonResponseAssembler, times(1)).assemble(any(Pokemon.class));
  }

  @Test
  void shouldNotFoundPokemon() throws Exception {
    when(detailPokemon.execute(anyInt(), anyString()))
        .thenThrow(new NotFoundException("pokemon not found"));

    JavaCleanException thrown =
        assertThrows(
            JavaCleanException.class,
            () -> mockMvc.perform(get("/api/v1/pokemon/1/ditto")).andReturn());

    verify(detailPokemon, times(1)).execute(anyInt(), anyString());
    verify(pokemonToPokemonResponseAssembler, never()).assemble(any(Pokemon.class));
    assertThat(thrown.getHttpStatus(), equalTo(HttpStatus.NOT_FOUND));
    assertThat(thrown.getErrorResponse().getMessage(), equalTo(ErrorResponse.POKEMON_NOT_FOUND));
  }
}
