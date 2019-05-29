package br.community.javaclean.gateways.http.jsons.pokemon;

import java.util.List;

import br.community.javaclean.domains.types.Ability;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@ApiModel
public class PokemonResponse {

  @ApiModelProperty(value = "Name", example = "ditto")
  private String name;

  @ApiModelProperty(value = "Abilities", example = "[LIMBER]")
  private List<Ability> abilities;

  @ApiModelProperty(value = "Base experience", example = "200")
  private Integer baseExperience;

  @ApiModelProperty(value = "Weight", example = "20")
  private Integer weight;

  @ApiModelProperty(value = "Height", example = "12")
  private Integer height;
}
