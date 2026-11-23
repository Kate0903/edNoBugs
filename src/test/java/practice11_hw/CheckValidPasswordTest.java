package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class CheckValidPasswordTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки корректности пароля:
   * positive tests:
   * "Password1" -> true *
   * negative tests:
   * "pass" -> false
   * "assertion4" -> false
   * "Carefully" -> false
   * corner cases:
   * null -> false
   *
   */
  @CsvSource({
          "Password1"
  })
  @ParameterizedTest
  public void userCanIfPasswordIsCorrectForValidString(String initialPassString) {
    boolean resultCheckPass = differentMathOperations.isValidPassword(initialPassString);
    assertTrue(resultCheckPass);
  }

  @CsvSource({
          "pass",
          "assertion4",
          "Carefully"
  })
  @NullSource
  @ParameterizedTest
  public void userCanIfPasswordIsNotCorrectForNotValidString(String initialPassString) {
    boolean resultCheckPass = differentMathOperations.isValidPassword(initialPassString);
    assertFalse(resultCheckPass);
  }


}
