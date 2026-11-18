package practice11_hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckEvenNumberTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки числа на четность:
   * happy path: 4 -> true
   * corner cases:
   * 0 -> true
   * -2 -> true
   * negative cases:
   * 5 -> false
   * -1 -> false
   */

  @ParameterizedTest
  @ValueSource(ints = {
          // happy path
          4,
          //corner cases:
          0, -2})
  public void userCanCheckIfValidNumberIsEvenNumber(int initialInt) {
    boolean expectResult = differentMathOperations.isEven(initialInt);
    assertTrue(expectResult);
  }

  @ParameterizedTest
  @ValueSource(ints = {
          //  negative cases
          5, -1})
  public void userCanCheckIfValidNumberIsNotEvenNumber(int initialInt) {
    boolean expectResult = differentMathOperations.isEven(initialInt);
    assertFalse(expectResult);
  }


}
