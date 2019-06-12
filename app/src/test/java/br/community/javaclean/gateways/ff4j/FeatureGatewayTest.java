package br.community.javaclean.gateways.ff4j;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.ff4j.FF4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.community.javaclean.confs.UnitTest;
import io.github.glytching.junit.extension.random.Random;

class FeatureGatewayTest extends UnitTest {

  @Mock private FF4j ff4j;

  @InjectMocks private FeatureGatewayImpl featureGateway;

  @Test
  void shouldCheck(@Random String key) {
    when(ff4j.check(key)).thenReturn(true);

    boolean status = featureGateway.check(key);

    assertTrue(status);
    verify(ff4j, times(1)).check(key);
  }
}
