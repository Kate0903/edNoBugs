package practice11_hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckValidJsonTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки корректности json:
   * positive tests:
   * "{"key":"value"}" -> true
   * negative tests:
   * "invalid json" -> false
   * corner cases:
   * null -> false
   *
   */

  @ParameterizedTest
  @ValueSource(strings = {
          //  positive tests
          "{\"key\":\"value\"}"

  })
  public void userCanCheckValidJsonIsCorrect(String initialJson) {
    boolean actualJson = differentMathOperations.isValidJson(initialJson);
    assertTrue(actualJson);
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {
          //  positive tests
          "invalid json",


  })
  public void userCanCheckNotValidJson(String initialJson) {
    boolean actualJson = differentMathOperations.isValidJson(initialJson);
    assertFalse(actualJson);
  }


}
