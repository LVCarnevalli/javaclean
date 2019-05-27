package br.community.javaclean.gateways;

import br.community.javaclean.domains.Pokemon;

@FunctionalInterface
public interface PokemonGateway {

  Pokemon detail(String name);
}
