package br.community.javaclean.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

object Healthcheck {

  val URIHealthcheck = "/actuator/health"

  val health = scenario("Healthcheck").exec(
    pause(30 seconds).exec(
      http(URIHealthcheck)
        .get(URIHealthcheck)
        .check(status.is(200))
    )
  )
}
