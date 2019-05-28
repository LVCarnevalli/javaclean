package br.community.javaclean.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.community.javaclean.conf.fixtures.FixtureJson;
import br.community.javaclean.conf.fixtures.TemplateJsonLoader;
import br.community.javaclean.gateways.feign.jsons.pokemon.PokemonInfo;

public class PokemonInfoTemplate extends TemplateJsonLoader {

  @Override
  public void load() {
    Fixture.of(FixtureJson.class)
        .addTemplate(
            "a valid pokemon info",
            new Rule() {
              {
                add("value", json("PokemonInfo_valid", PokemonInfo.class));
              }
            });
  }
}
