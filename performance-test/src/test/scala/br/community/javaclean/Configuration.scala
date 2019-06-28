package br.community.javaclean

import com.typesafe.config.ConfigFactory

object Configuration {
  private val config = ConfigFactory.load("gatling-defaults")

  def getString(name: String): String = {
    return config.getString(name)
  }

  def getInt(name: String): Int = {
    return config.getInt(name)
  }

  Database.disableFeatureToggles()
}
