package br.community.javaclean.gateways.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.community.javaclean.confs.feign.PokemonClientConfiguration;
import br.community.javaclean.gateways.feign.jsons.pokemon.PokemonInfo;

@FeignClient(
    name = "pokemon",
    url = "${clients.pokemon.endpoint}",
    configuration = PokemonClientConfiguration.class)
public interface PokemonClient {

  @GetMapping(
      value = "/pokemon/{name}",
      headers = {"User-Agent=Mozilla/5.0"})
  PokemonInfo detail(@PathVariable("name") String name);
}
