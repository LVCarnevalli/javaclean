package br.community.javaclean.domains.types;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.community.javaclean.confs.UnitTest;

class RegexTest extends UnitTest {

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
