package br.community.javaclean;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.junit.jupiter.api.Test;

import br.community.javaclean.confs.UnitTest;
import br.community.javaclean.domains.types.Features;

public class FeaturesTest extends UnitTest {

  @Test
  void shouldConfigureFeatures() {
    FF4j ff4j = new FF4j("ff4j-features.xml");

    Map<String, Feature> features = ff4j.getFeatures();
    assertThat(features.size(), equalTo(1));

    Feature detailPokemon = features.get(Features.FEATURE_DETAIL_POKEMON);
    assertThat(detailPokemon.getUid(), equalTo("detail-pokemon"));
    assertTrue(detailPokemon.isEnable());
  }
}
