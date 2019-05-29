package br.community.javaclean.simulations

import br.community.javaclean.scenarios.Pokemon
import br.community.javaclean.{JavaCleanSimulation, Protocol}
import io.gatling.core.Predef._

class PokemonSimulation extends JavaCleanSimulation {

  setUp(
    Pokemon.detailPokemon.inject(
      constantUsersPerSec(noOfUsersPerSec) during (durationTime)
    )
  ).assertions(
    global.responseTime.mean.lte(150),
    forAll.failedRequests.percent.is(0.0)
  ).protocols(Protocol.Application)

}
