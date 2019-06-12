package br.community.javaclean.confs.ff4j;

import java.util.List;
import java.util.stream.Collectors;

import org.ff4j.FF4j;
import org.ff4j.conf.XmlConfig;
import org.ff4j.core.Feature;
import org.ff4j.property.Property;
import org.ff4j.redis.RedisConnection;
import org.ff4j.store.EventRepositoryRedis;
import org.ff4j.store.FeatureStoreRedis;
import org.ff4j.store.PropertyStoreRedis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4jConfiguration {

  @Value("${ff4j.redis.server:#{null}}")
  private String redisServer;

  @Value("${ff4j.redis.port:#{null}}")
  private Integer redisPort;

  @Bean
  public FF4j getFF4j() {
    FF4j ff4j = new FF4j();

    if (redisServer != null && redisPort != null) {
      RedisConnection redisConnection = new RedisConnection(redisServer, redisPort);

      ff4j.setFeatureStore(new FeatureStoreRedis(redisConnection));
      ff4j.setPropertiesStore(new PropertyStoreRedis(redisConnection));
      ff4j.setEventRepository(new EventRepositoryRedis(redisConnection));
    }

    ff4j.audit();

    XmlConfig xmlConfig = ff4j.parseXmlConfig("ff4j-features.xml");
    ff4j.getFeatureStore().importFeatures(getNewFeatures(ff4j, xmlConfig));
    ff4j.getPropertiesStore().importProperties(getNewProperties(ff4j, xmlConfig));
    return ff4j;
  }

  private List<Feature> getNewFeatures(FF4j ff4j, XmlConfig xmlConfig) {
    return xmlConfig
        .getFeatures()
        .values()
        .stream()
        .filter(value -> !ff4j.getFeatures().containsKey(value.getUid()))
        .collect(Collectors.toList());
  }

  private List<Property<?>> getNewProperties(FF4j ff4j, XmlConfig xmlConfig) {
    return xmlConfig
        .getProperties()
        .values()
        .stream()
        .filter(value -> !ff4j.getProperties().containsKey(value.getName()))
        .collect(Collectors.toList());
  }
}
