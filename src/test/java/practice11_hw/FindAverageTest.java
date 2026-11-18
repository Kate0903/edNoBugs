package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindAverageTest extends DifferentMathOperationsTest {
  /**
   * Тесты для нахождения среднего значения массива чисел:
   * happy path:
   * [1, 2, 3, 4, 5] → 3.0
   * [10] ->  10.0
   * [-1, -2, -3, -4, -5] → - 3.0
   * corner cases:
   * [] -> NoSuchElementException
   * null -> NullPointerException
   */
  public static Stream<Arguments> validArraysToFindAverageNumber() {
    return Stream.of(
            //happy path:
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 3.0),
            Arguments.of(new int[]{-1, -2, -3, -4, -5}, -3.0),
            Arguments.of(new int[]{10}, 10.0)

    );
  }

  @ParameterizedTest
  @MethodSource("validArraysToFindAverageNumber")
  public void userCanFindAverageForValidArray(int[] initialArray, double expectedAvarage) {
    double actualAvarage = differentMathOperations.findAverage(initialArray);
    assertEquals(expectedAvarage, actualAvarage);
  }

  @Test
  public void userCanNotFindAverageForArrayIsNull() {
    assertThrows(NullPointerException.class, () -> {
      differentMathOperations.findAverage(null);
    }, "Find average number for null array should lead to NullPointerException");

  }

  @Test
  public void userCanNotFindAverageForArrayIsEmpty() {
    assertThrows(NoSuchElementException.class, () -> {
      differentMathOperations.findAverage(new int[]{});
    }, "Find average number for empty array should lead to NoSuchElementException");

  }

}
