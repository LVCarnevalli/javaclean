package br.community.javaclean.gateways.ff4j;

import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeatureGatewayImpl implements FeatureGateway {

  private final FF4j ff4j;

  @Autowired
  public FeatureGatewayImpl(FF4j ff4j) {
    this.ff4j = ff4j;
  }

  @Override
  public boolean check(String key) {
    return ff4j.check(key);
  }
}
