package practice11_hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindGcdTest extends DifferentMathOperationsTest {
  /**
   * Тесты для нахождения НОД:
   * positive tests:
   * 24, 36 -> 12
   * corner cases:
   * 101, 103 → 1
   * 0, 10 → 10
   *
   */
  @CsvSource({
          "24, 36, 12",
          "101, 103, 1",
          "0,10,10"
  })
  @ParameterizedTest
  public void userCanFindGcdForTwoNumbers(int initialNumber1, int initialNumber2, int expectedGcd) {
    int actualGcd = differentMathOperations.gcd(initialNumber1, initialNumber2);
    assertEquals(expectedGcd, actualGcd);
  }
}
