package br.community.javaclean.steps;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import cucumber.api.java.Before;
import io.github.osvaldjr.core.EasyCucumberContextLoader;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.NONE,
    classes = {EasyCucumberContextLoader.class})
@EnableAutoConfiguration
public class ContextLoader {

  @Before
  public void setUp() {
    // Empty method, just to setup Application Test Context
  }
}
