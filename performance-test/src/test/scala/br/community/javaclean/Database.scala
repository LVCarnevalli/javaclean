package br.community.javaclean

import com.redis.RedisClient

object Database {

  val featureToggles = List(
    "detail-pokemon"
  )

  private def toggleFeature(client: RedisClient, ft: String, enable: Boolean): Unit = {
    val featureToggleDescriptor = s"""{"uid":"$ft ","enable": $enable,"description":"Toggle $ft","group":null,"permissions":[],"flippingStrategy":null,"customProperties":{}}"""
    client.set(s"FF4J_FEATURE_$ft", featureToggleDescriptor)
  }

  def disableFeatureToggles() = {
    val client = new RedisClient(Configuration.getString("application.url-redis"), Configuration.getInt("application.port"))
    featureToggles.foreach { ft =>
      toggleFeature(client, ft, enable = false)
    }
  }

  def enableFeatureToggles() = {
    val client = new RedisClient(Configuration.getString("application.url-redis"), Configuration.getInt("application.port"))
    featureToggles.foreach { ft =>
      toggleFeature(client, ft, enable = true)
    }
  }
}
