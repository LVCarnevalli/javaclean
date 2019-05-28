package br.community.javaclean.confs;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import io.github.glytching.junit.extension.random.RandomBeansExtension;

@ExtendWith({RandomBeansExtension.class})
public abstract class HTTPIntegrationTest {

  @Autowired public MockMvc mockMvc;
}
