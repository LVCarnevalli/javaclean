package br.community.javaclean.domains;

import java.util.List;

import br.community.javaclean.domains.enums.Ability;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Pokemon {

  private Integer id;
  private String name;
  private List<Ability> abilities;
  private Integer baseExperience;
  private Integer weight;
  private Integer height;
}
