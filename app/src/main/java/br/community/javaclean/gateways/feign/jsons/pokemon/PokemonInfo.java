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

  @JsonProperty("gameIndices")
  private List<GameIndexInfo> game_indices;

  private Integer height;
  private Integer id;

  @JsonProperty("isDefault")
  private Boolean is_default;

  @JsonProperty("locationAreaEncounters")
  private String location_area_encounters;

  private String name;
  private Integer order;
  private LinkInfo species;
  private Integer weight;
}
