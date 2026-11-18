package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindSecondMaxTest extends DifferentMathOperationsTest {
  /**
   * Тесты для нахождения второго максимального числа:
   * happy path:
   * [3,5,7,8] -> 7
   * [-2,-1,-5] -> -2
   * [0,-3] -> 0
   * [-1,2,-3] -> -1
   * corner cases:
   * [4,4,4,4,4] -> NoSuchElementException
   * [2] -> IllegalArgumentException
   * [] -> IllegalArgumentException
   * null -> IllegalArgumentException
   */
  public static Stream<Arguments> validArraysToFindSecondMax() {
    return Stream.of(
            //happy path:
            Arguments.of(new int[]{3, 5, 7, 8}, 7),
            Arguments.of(new int[]{-2, -1, -5}, -2),
            Arguments.of(new int[]{0, 1}, 0),
            Arguments.of(new int[]{-1, 2, -3}, -1)

    );
  }

  @ParameterizedTest
  @MethodSource("validArraysToFindSecondMax")
  public void userCanFindSecondMaxForValidArray(int[] initialArray, int expectedSecondMax) {
    int actualSecondMax = differentMathOperations.findSecondMax(initialArray);
    assertEquals(expectedSecondMax, actualSecondMax);
  }

  @Test
  public void userCanNotFindSecondMaxForEmptyArray() {
    assertThrows(IllegalArgumentException.class, () -> {
      differentMathOperations.findSecondMax(new int[]{});
    }, "Serch Second Max for empty array should lead to IllegalArgumentException");

  }

  @Test
  public void userCanNotFindSecondMaxForEqualsElementsArray() {
    assertThrows(NoSuchElementException.class, () -> {
      differentMathOperations.findSecondMax(new int[]{4, 4, 4, 4});
    }, "Serch Second Max for array with equals elements should lead to NoSuchElementException");

  }

  @Test
  public void userCanNotFindSecondMaxForArrayWithOneElement() {
    assertThrows(IllegalArgumentException.class, () -> {
      differentMathOperations.findSecondMax(new int[]{3});
    }, "Serch Second Max for array with one element should lead to IllegalArgumentException");

  }

  @Test
  public void userCanNotFindSecondMaxForArrayIsNull() {
    assertThrows(NullPointerException.class, () -> {
      differentMathOperations.findSecondMax(null);
    }, "Serch Second Max for null array should lead to NullPointerException");

  }

}
