package br.community.javaclean.gateways.ff4j;

@FunctionalInterface
public interface FeatureGateway {

  boolean check(String key);
}
