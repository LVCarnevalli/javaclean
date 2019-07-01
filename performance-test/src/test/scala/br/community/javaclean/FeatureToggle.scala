package br.community.javaclean

import com.redis.RedisClient

object FeatureToggle {

  val featureToggles = List(
    "detail-pokemon"
  )

  private def toggleFeature(client: RedisClient, ft: String, enable: Boolean): Unit = {
    val featureToggleDescriptor = s"""{"uid":"$ft ","enable": $enable,"description":"Toggle $ft","group":null,"permissions":[],"flippingStrategy":null,"customProperties":{}}"""
    client.set(s"FF4J_FEATURE_$ft", featureToggleDescriptor)
  }

  def disableAllFeatureToggles() = {
    val client = new RedisClient(Configuration.getString("application.url-redis"), Configuration.getInt("application.port-redis"))
    featureToggles.foreach { ft =>
      toggleFeature(client, ft, enable = false)
    }
  }

  def enableAllFeatureToggles() = {
    val client = new RedisClient(Configuration.getString("application.url-redis"), Configuration.getInt("application.port-redis"))
    featureToggles.foreach { ft =>
      toggleFeature(client, ft, enable = true)
    }
  }
}
