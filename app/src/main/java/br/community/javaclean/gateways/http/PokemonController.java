package br.community.javaclean.gateways.http;

import static br.community.javaclean.gateways.http.jsons.ErrorResponse.POKEMON_NOT_FOUND;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.domains.exceptions.JavaCleanException;
import br.community.javaclean.domains.exceptions.NotFoundException;
import br.community.javaclean.domains.logs.LogKey;
import br.community.javaclean.domains.types.Regex;
import br.community.javaclean.gateways.http.assembler.PokemonToPokemonResponseAssembler;
import br.community.javaclean.gateways.http.jsons.ErrorResponse;
import br.community.javaclean.gateways.http.jsons.pokemon.PokemonResponse;
import br.community.javaclean.usecases.DetailPokemon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/pokemon")
@Api(value = "/api/v1/pokemon", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class PokemonController {

  private final DetailPokemon detailPokemon;
  private final PokemonToPokemonResponseAssembler pokemonToPokemonResponseAssembler;

  @Autowired
  public PokemonController(
      DetailPokemon detailPokemon,
      PokemonToPokemonResponseAssembler pokemonToPokemonResponseAssembler) {
    this.detailPokemon = detailPokemon;
    this.pokemonToPokemonResponseAssembler = pokemonToPokemonResponseAssembler;
  }

  @ApiOperation(value = "Detail pokemon")
  @GetMapping("/{id}/{name}")
  public PokemonResponse detail(
      @ApiParam(value = "Id of pokemon", required = true) @PathVariable @Max(999) @NotNull
          Integer id,
      @ApiParam(value = "Name of pokemon", required = true)
          @PathVariable
          @Size(max = 20)
          @Pattern(regexp = Regex.ALPHA)
          @NotBlank
          String name) {
    log.warn(
        "Get detail pokemon with id {} and name {}",
        LogKey.value(LogKey.POKEMON_ID, id),
        LogKey.value(LogKey.POKEMON_NAME, name));

    Pokemon pokemon;
    try {
      pokemon = detailPokemon.execute(id, name);
    } catch (NotFoundException exception) {
      log.warn("Pokemon not found");
      throw new JavaCleanException(HttpStatus.NOT_FOUND, ErrorResponse.build(POKEMON_NOT_FOUND));
    }
    return pokemonToPokemonResponseAssembler.assemble(pokemon);
  }
}
