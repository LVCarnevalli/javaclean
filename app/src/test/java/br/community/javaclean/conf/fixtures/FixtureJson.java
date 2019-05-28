package br.community.javaclean.conf.fixtures;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FixtureJson<T> {

  private T value;
}
