package br.community.javaclean.gateways.http;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.community.javaclean.conf.HTTPIntegrationTest;
import br.community.javaclean.gateways.http.jsons.ErrorResponse;

class CustomExceptionHandlerTest extends HTTPIntegrationTest {

  private MockMvc mockMvc =
      MockMvcBuilders.standaloneSetup(new CustomExceptionHandlerControllerTest())
          .setControllerAdvice(new CustomExceptionHandler())
          .build();

  @Test
  void shouldThrowJavacleanException() throws Exception {
    mockMvc
        .perform(get("/shouldThrowJavacleanException"))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message").value("exception"));
  }

  @Test
  void shouldThrowPokemonIntegrationException() throws Exception {
    mockMvc
        .perform(get("/shouldThrowPokemonIntegrationException"))
        .andExpect(status().isUnprocessableEntity())
        .andExpect(jsonPath("$.message").value(ErrorResponse.UNPROCESSABLE_ENTITY));
  }

  @Test
  void shouldThrowException() throws Exception {
    mockMvc
        .perform(get("/shouldThrowException"))
        .andExpect(status().isInternalServerError())
        .andExpect(jsonPath("$.message").value(ErrorResponse.INTERNAL_SERVER_ERROR));
  }
}
