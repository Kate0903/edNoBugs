package practice11_hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CheckHasDuplicatesTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки содержит ли массив дубликаты:
   * happy path:
   * [1, 2, 2, 3] → true
   * negative cases:
   * [1, 2, 3, 4, 5] → false
   * corner cases:
   * [] -> false
   *
   */
  public static Stream<Arguments> validArraysToCheckHasDuplicates() {
    return Stream.of(
            Arguments.of(new int[]{1, 2, 2, 3})

    );
  }

  @ParameterizedTest
  @MethodSource("validArraysToCheckHasDuplicates")
  public void userCanCheckHasDuplicatesValidArray(int[] initialArray) {
    boolean actualResult = differentMathOperations.hasDuplicates(initialArray);
    assertTrue(actualResult);
  }

  public static Stream<Arguments> validArraysToCheckHasNotDuplicates() {
    return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}),
            Arguments.of(new int[]{})

    );
  }

  @ParameterizedTest
  @MethodSource("validArraysToCheckHasNotDuplicates")
  public void userCanCheckHasNotDuplicatesValidArray(int[] initialArray) {
    boolean actualResult = differentMathOperations.hasDuplicates(initialArray);
    assertFalse(actualResult);
  }

}
