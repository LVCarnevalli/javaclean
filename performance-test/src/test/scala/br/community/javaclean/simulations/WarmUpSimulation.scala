package br.community.javaclean.simulations

import br.community.javaclean.scenarios.Healthcheck
import br.community.javaclean.{JavaCleanSimulation, Protocol}
import io.gatling.core.Predef._

class WarmUpSimulation extends JavaCleanSimulation {

  setUp(
    Healthcheck.health.inject(
      atOnceUsers(1)
    )
  ).assertions(
    forAll.failedRequests.percent.is(0.0)
  ).protocols(Protocol.Application)

}