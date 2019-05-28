package br.community.javaclean.gateways.feign.jsons.pokemon;

import java.util.List;

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
public class PokemonInfo {

  private List<AbilityInfo> abilities;

  @JsonProperty("base_experience")
  private Integer baseExperience;

  private List<LinkInfo> forms;

  @JsonProperty("game_indices")
  private List<GameIndexInfo> gameIndices;

  private Integer height;
  private Integer id;

  @JsonProperty("is_default")
  private Boolean isDefault;

  @JsonProperty("location_area_encounters")
  private String locationAreaEncounters;

  private String name;
  private Integer order;
  private LinkInfo species;
  private Integer weight;
}
