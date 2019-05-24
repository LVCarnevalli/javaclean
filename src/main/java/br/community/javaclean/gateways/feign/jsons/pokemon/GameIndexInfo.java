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
public class GameIndexInfo {

  private Integer game_index;
  private LinkInfo version;
}
