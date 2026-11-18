package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchMaxNumberTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки поиска максимального числа в массиве:
   * happy path:
   * [3,5,7,2] -> 7
   * [-3,-9,-7,-10] -> -3
   * [-3,-5,2,6] -> 6
   * [-3,0,-2,-6] -> 0
   * corner cases:
   * [4] -> 4
   * [""] -> NoSuchElementException
   * null -> IllegalArgumentException
   */
  public static Stream<Arguments> validArraysToReverse() {
    return Stream.of(
            //happy path:
            Arguments.of(new int[]{3, 5, 7, 2}, 7),
            Arguments.of(new int[]{-3, -9, -7, -10}, -3),
            Arguments.of(new int[]{-3, -5, 2, 6}, 6),
            Arguments.of(new int[]{-3, 0, -2, -6}, 0),
            //corner cases:
            Arguments.of(new int[]{4}, 4)
    );
  }

  @ParameterizedTest
  @MethodSource("validArraysToReverse")
  public void userCanGetMaxNumberFromValidArray(int[] initialArray, int expectedMaxNumber) {
    int actualMax = differentMathOperations.findMax(initialArray);
    assertEquals(expectedMaxNumber, actualMax);

  }

  @Test
  public void userCanNotSearchMaxForNullArray() {
    assertThrows(NullPointerException.class, () -> {
      differentMathOperations.findMax(null);
    }, "Serch Max number of null array should lead to NullPointerException");

  }

  @Test
  public void userCanNotSearchMaxForEmptyArray() {
    assertThrows(NoSuchElementException.class, () -> {
      differentMathOperations.findMax(new int[]{});
    }, "Serch Max in empty array should lead to NoSuchElementException");

  }
}
