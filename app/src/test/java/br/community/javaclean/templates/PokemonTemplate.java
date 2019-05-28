package br.community.javaclean.templates;

import java.util.Arrays;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.community.javaclean.confs.fixtures.TemplateJsonLoader;
import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.domains.enums.Ability;

public class PokemonTemplate extends TemplateJsonLoader {

  @Override
  public void load() {
    Fixture.of(Pokemon.class)
        .addTemplate(
            "a valid pokemon",
            new Rule() {
              {
                add("id", 1);
                add("name", "ditto");
                add("abilities", Arrays.asList(Ability.LIMBER, Ability.OVERGROW));
                add("baseExperience", 2000);
                add("weight", 21);
                add("height", 12);
              }
            });
  }
}
