package br.community.javaclean

import io.gatling.core.scenario.Simulation

import scala.concurrent.duration._

trait JavaCleanSimulation extends Simulation {

  val durationTime = 30 seconds
  val noOfUsersPerSec = 1
  val warmUpDurationTime = 10
  val warmUpNoOfUsers = 5
}