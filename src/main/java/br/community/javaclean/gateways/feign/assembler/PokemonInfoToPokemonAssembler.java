package br.community.javaclean.gateways.feign.assembler;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

import br.community.javaclean.domains.Pokemon;
import br.community.javaclean.domains.enums.Ability;
import br.community.javaclean.gateways.feign.jsons.pokemon.AbilityInfo;
import br.community.javaclean.gateways.feign.jsons.pokemon.PokemonInfo;

@Component
public class PokemonInfoToPokemonAssembler {

  public Pokemon assemble(PokemonInfo data) {
    return Pokemon.builder()
        .id(data.getId())
        .name(data.getName())
        .abilities(assembleAbilities(data))
        .baseExperience(data.getBase_experience())
        .weight(data.getWeight())
        .height(data.getHeight())
        .build();
  }

  private List<Ability> assembleAbilities(PokemonInfo data) {
    return Optional.ofNullable(data.getAbilities())
        .map(
            abilities ->
                abilities
                    .stream()
                    .map(this::assembleAbilitiesLinkInfo)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()))
        .orElse(null);
  }

  private Ability assembleAbilitiesLinkInfo(AbilityInfo abilityInfo) {
    return Optional.ofNullable(abilityInfo.getAbility())
        .map(linkInfo -> EnumUtils.getEnum(Ability.class, linkInfo.getName()))
        .orElse(null);
  }
}
