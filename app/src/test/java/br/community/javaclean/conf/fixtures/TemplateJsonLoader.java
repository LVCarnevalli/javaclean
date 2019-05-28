package br.community.javaclean.conf.fixtures;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import br.com.six2six.fixturefactory.loader.TemplateLoader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TemplateJsonLoader implements TemplateLoader {

  public static final String PATH_RESOURCE_FIXTURE_JSON = "/templates";
  public static final String EXTENSION_FIXTURE_JSON = ".json";

  private static ObjectMapper mapper;

  public TemplateJsonLoader() {
    if (mapper == null) {
      mapper = new ObjectMapper();
      mapper.findAndRegisterModules();
      mapper.registerModule(new SimpleModule());
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
  }

  public abstract void load();

  public <T> T json(String name, Class<T> valueType) {
    URL resource =
        getClass()
            .getResource(
                String.format("%s/%s%s", PATH_RESOURCE_FIXTURE_JSON, name, EXTENSION_FIXTURE_JSON));
    T object = null;
    try {
      object = mapper.readValue(resource, valueType);
    } catch (IOException e) {
      log.error("Error converting json {} ", e);
    }
    return object;
  }
}
