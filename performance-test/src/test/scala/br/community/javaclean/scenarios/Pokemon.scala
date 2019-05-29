package br.community.javaclean.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Pokemon {

  val URIDetailPokemon = "/api/v1/pokemon/{id}/{name}"

  val detailPokemon = scenario("Detail Pokemon").exec(
    exec(
      http(URIDetailPokemon)
        .get(URIDetailPokemon
          .replace("{id}", "132")
          .replace("{name}", "ditto"))
        .check(status.is(200)))
  )
}
