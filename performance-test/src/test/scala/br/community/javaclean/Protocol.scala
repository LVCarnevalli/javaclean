package br.community.javaclean

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Protocol {

  val Application = http
    .baseUrl(Configuration.getString("application.url-local"))
    .warmUp(Configuration.getString("application.url-local"))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
}
