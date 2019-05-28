package br.community.javaclean.gateways.feign.jsons.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;

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

  @JsonProperty("game_index")
  private Integer gameIndex;

  private LinkInfo version;
}
