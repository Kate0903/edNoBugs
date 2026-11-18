package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilterEvenNumbersTest extends DifferentMathOperationsTest {
  /**
   * Тесты для фильтрации списка чисел(оставляем четные):
   * happy path:
   * [1, 2, 3, 4, 5, 6] → [2, 4, 6]
   * [2,10,8] ->  [2,10,8]
   * [0, 7] -> [0]
   * [-1,5,-3] -> []
   * corner cases:
   * [] -> []
   * null -> NullPointerException
   */

  public static Stream<Arguments> validArraysToFilter() {
    return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 4, 6}),
            Arguments.of(new int[]{2, 10, 8}, new int[]{2, 10, 8}),
            Arguments.of(new int[]{0, 7}, new int[]{0}),
            Arguments.of(new int[]{-1, 5, -3}, new int[]{}),
            Arguments.of(new int[]{}, new int[]{})
    );
  }

  @ParameterizedTest
  @MethodSource("validArraysToFilter")
  public void userCanFilterEvenNumbersFromValidList(int[] initialArray, int[] expectedArray) {
    List<Integer> initialList = Arrays.stream(initialArray)
            .boxed()
            .collect(Collectors.toList());
    List<Integer> expectedList = Arrays.stream(expectedArray)
            .boxed()
            .collect(Collectors.toList());
    List<Integer> actualList = differentMathOperations.filterEvenNumbers(initialList);
    assertEquals(expectedList, actualList);

  }

  @Test
  public void userCanNotFilterEvenNumbersFromNullList() {
    assertThrows(NullPointerException.class, () -> {
      differentMathOperations.filterEvenNumbers(null);
    }, "Filter even numbers for null list should lead to NullPointerException");

  }

}
