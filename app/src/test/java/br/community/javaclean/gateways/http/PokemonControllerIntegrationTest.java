package br.community.javaclean.gateways.http;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.community.javaclean.confs.HTTPIntegrationTest;
import br.community.javaclean.gateways.http.assembler.PokemonToPokemonResponseAssembler;
import br.community.javaclean.usecases.DetailPokemon;

@WebMvcTest(controllers = PokemonController.class)
class PokemonControllerIntegrationTest extends HTTPIntegrationTest {

  @MockBean private DetailPokemon detailPokemon;
  @MockBean private PokemonToPokemonResponseAssembler pokemonToPokemonResponseAssembler;

  @ParameterizedTest
  @ValueSource(
      strings = {
        "/api/v1/pokemon/1000/ditto",
        "/api/v1/pokemon/1/AAAAAAAAAAAAAAAAAAAAX",
        "/api/v1/pokemon/1/123"
      })
  void shouldBadRequestInDetailPokemon(String uri) throws Exception {
    mockMvc.perform(get(uri)).andExpect(status().isBadRequest()).andReturn();
  }

  @ParameterizedTest
  @ValueSource(strings = {"/api/v1/pokemon/1/", "/api/v1/pokemon//ditto"})
  void shoudNotFoundInDetailPokemon(String uri) throws Exception {
    mockMvc.perform(get(uri)).andExpect(status().isNotFound()).andReturn();
  }
}
