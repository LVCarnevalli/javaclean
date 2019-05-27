package br.community.javaclean.domains.logs;

import com.google.common.base.CaseFormat;

import net.logstash.logback.argument.StructuredArgument;
import net.logstash.logback.argument.StructuredArguments;

public enum LogKey {
  POKEMON_ID,
  POKEMON_NAME;

  @Override
  public String toString() {
    return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, this.name().toLowerCase());
  }

  public static StructuredArgument value(LogKey key, Object object) {
    return StructuredArguments.value(key.toString(), object);
  }
}
