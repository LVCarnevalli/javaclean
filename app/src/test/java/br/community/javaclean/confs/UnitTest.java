package br.community.javaclean.confs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.community.javaclean.confs.fixtures.FixtureJson;
import io.github.glytching.junit.extension.random.RandomBeansExtension;

@ExtendWith({MockitoExtension.class, RandomBeansExtension.class})
public abstract class UnitTest {

  @BeforeAll
  static void setup() {
    FixtureFactoryLoader.loadTemplates("br.community.javaclean.templates");
  }

  public <T> T fromJson(String description, Class<T> type) {
    return ((FixtureJson<T>) Fixture.from(FixtureJson.class).gimme(description)).getValue();
  }

  public <T> T from(String description, Class<T> type) {
    return Fixture.from(type).gimme(description);
  }
}
