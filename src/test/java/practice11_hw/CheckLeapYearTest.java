package practice11_hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckLeapYearTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки на високосный год:
   * happy path:
   * 2020 -> true
   * 2000 -> true
   * 1600 -> true
   * negative path:
   * 2026 -> false
   * 1901 -> false
   * 1900 -> false
   * 2100 -> false
   *
   */

  @ParameterizedTest
  @ValueSource(ints = {
          2020,
          2000,
          1600

  })
  public void userCanCheckIfYearIsLeap(int initialYear) {
    boolean actualResult = differentMathOperations.isLeapYear(initialYear);
    assertTrue(actualResult);
  }

  @ParameterizedTest
  @ValueSource(ints = {
          2026,
          1901,
          1900,
          2100
  })
  public void userCanCheckIfYearIsNotLeap(int initialYear) {
    boolean actualResult = differentMathOperations.isLeapYear(initialYear);
    assertFalse(actualResult);
  }


}
