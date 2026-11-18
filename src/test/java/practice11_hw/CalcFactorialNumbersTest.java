package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcFactorialNumbersTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки вычисления факториала:
   * happy path:
   * 1 -> 1
   * 5 -> 120
   * 7 -> 5040
   * corner cases:
   * 0 -> 1
   * -1 -> IllegalArgumentException
   */

  @CsvSource({
          //happy path
          "1, 1",
          "5, 120",
          "7, 5040",
          //corner cases
          "0, 1"
  })
  @ParameterizedTest
  public void userCanCalcFactorialFromValidNumber(int initialNumber, int expectedFactorial) {
    int actualFactorial = differentMathOperations.factorial(initialNumber);
    assertEquals(expectedFactorial, actualFactorial);
  }

  @Test
  public void userCanNotCalcFactorialForNegativeNumber() {
    assertThrows(IllegalArgumentException.class, () -> {
      differentMathOperations.factorial(-1);
    }, "Factorial of negative  string should lead to IllegalArgumentException");

  }

}
