package br.community.javaclean.confs.ff4j;

import org.ff4j.FF4j;
import org.ff4j.conf.XmlConfig;
import org.ff4j.redis.RedisConnection;
import org.ff4j.store.EventRepositoryRedis;
import org.ff4j.store.FeatureStoreRedis;
import org.ff4j.store.PropertyStoreRedis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4jConfiguration {

  @Value("${ff4j.redis.server:localhost}")
  private String redisServer;

  @Value("${ff4j.redis.port:6379}")
  private Integer redisPort;

  @Bean
  public FF4j getFF4j() {
    FF4j ff4j = new FF4j();
    RedisConnection redisConnection = new RedisConnection(redisServer, redisPort);

    ff4j.setFeatureStore(new FeatureStoreRedis(redisConnection));
    ff4j.setPropertiesStore(new PropertyStoreRedis(redisConnection));
    ff4j.setEventRepository(new EventRepositoryRedis(redisConnection));

    ff4j.audit();
    ff4j.autoCreate();

    XmlConfig xmlConfig = ff4j.parseXmlConfig("ff4j-features.xml");
    ff4j.getFeatureStore().importFeatures(xmlConfig.getFeatures().values());
    ff4j.getPropertiesStore().importProperties(xmlConfig.getProperties().values());
    return ff4j;
  }
}
