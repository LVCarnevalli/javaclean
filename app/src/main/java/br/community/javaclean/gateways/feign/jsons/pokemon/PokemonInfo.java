package br.community.javaclean.gateways.feign.jsons.pokemon;

import java.util.List;

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
  private Integer base_experience;
  private List<LinkInfo> forms;
  private List<GameIndexInfo> game_indices;
  private Integer height;
  private Integer id;
  private Boolean is_default;
  private String location_area_encounters;
  private String name;
  private Integer order;
  private LinkInfo species;
  private Integer weight;
}
