package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CheckValidEmailTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки корректности email:
   * positive tests:
   * "test@example.com" -> true
   * "noreply@eastlink.ca" -> true
   * negative tests:
   * "bad@.com" -> false
   * "no-at-symbol" -> false
   * "@test.com" -> false
   * "check@gmail" ->false
   * corner cases:
   * null -> false
   * "" -> false
   * "b@t.cc" -> true
   *
   *
   */

  @ParameterizedTest
  @ValueSource(strings = {
          //  positive tests
          "test@example.com",
          "noreply@eastlink.ca",
          //corner cases
          "b@t.cc"
  })
  public void userCanCheckValidEmailIsCorrect(String initialEmail) {
    boolean actualResult = differentMathOperations.isValidEmail(initialEmail);
    assertTrue(actualResult);
  }


  @ParameterizedTest
  @ValueSource(strings = {
          "bad@.com",
          "no-at-symbol",
          "@test.com",
          "check@gmail"
  })
  public void userCanCheckNotValidEmailIsNotCorrect(String initialEmail) {
    boolean actualResult = differentMathOperations.isValidEmail(initialEmail);
    assertFalse(actualResult);
  }

  @Test
  public void userCanCheckNullEmail() {
    boolean actualResult = differentMathOperations.isValidEmail(null);
    assertFalse(actualResult);
  }

  @Test
  public void userCanCheckEmptyValueEmail() {
    boolean actualResult = differentMathOperations.isValidEmail("");
    assertFalse(actualResult);
  }


}
