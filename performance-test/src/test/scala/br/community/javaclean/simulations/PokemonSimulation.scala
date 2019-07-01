package br.community.javaclean.simulations

import br.community.javaclean.scenarios.Pokemon
import br.community.javaclean.{Database, JavaCleanSimulation, Protocol}
import io.gatling.core.Predef.{constantUsersPerSec, _}

class PokemonSimulation extends JavaCleanSimulation {

  before {
    Database.enableFeatureToggles()
  }

  setUp(
    Pokemon.detailPokemon.inject(
      constantUsersPerSec(noOfUsersPerSec) during (durationTime)
    )
  ).assertions(
    global.responseTime.mean.lte(150),
    forAll.failedRequests.percent.is(0.0)
  ).protocols(Protocol.Application)

}
