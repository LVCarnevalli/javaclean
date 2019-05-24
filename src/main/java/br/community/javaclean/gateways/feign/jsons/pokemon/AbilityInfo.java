package br.community.javaclean.gateways.feign.jsons.pokemon;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class AbilityInfo {

  private LinkInfo ability;
  private Boolean is_hidden;
  private Integer slot;
}
