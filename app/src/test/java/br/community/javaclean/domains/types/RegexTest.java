package br.community.javaclean.domains.types;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.community.javaclean.confs.UnitTest;

class RegexTest extends UnitTest {

  @Test
  void shouldForceRegexTest() {
    List<String> expected = Arrays.asList("ALPHA");

    assertThat(
        Arrays.stream(Regex.class.getDeclaredFields())
            .filter(field -> field.getType().equals(String.class))
            .map(Field::getName)
            .collect(Collectors.toList()),
        equalTo(expected));
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "qwertyuiopasdfghjklzxcvbnm",
        "QWERTYUIOPASDFGHJKLZXCVBNM",
        "QwErTyUiOpAsDfGhJkLzxCvBnM"
      })
  void shouldValidAlphaRegex(String value) {
    assertTrue(value.matches(Regex.ALPHA));
  }

  @ParameterizedTest
  @ValueSource(strings = {"123", "#$%", "abc abc"})
  void shouldInvalidAlphaRegex(String value) {
    assertFalse(value.matches(Regex.ALPHA));
  }
}
