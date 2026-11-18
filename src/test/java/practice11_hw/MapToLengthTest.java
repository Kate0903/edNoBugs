package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapToLengthTest extends DifferentMathOperationsTest {
  /**
   * Тесты для преобразования списка строк в список длин:
   * happy path:
   * [ "Java", "C++", "Go" ] → [ 4, 3, 2 ]
   * corner cases:
   * ["F"] -> [1]
   * [] -> []
   * null -> NullPointerException
   */

  public static Stream<Arguments> validArraysMapToLength() {
    List<String> input1 = new ArrayList<>(List.of("Java", "C++", "Go"));
    List<Integer> expected1 = new ArrayList<>(List.of(4, 3, 2));
    List<String> input2 = new ArrayList<>(List.of());
    List<Integer> expected2 = new ArrayList<>(List.of());
    List<String> input3 = new ArrayList<>(List.of("F"));
    List<Integer> expected3 = new ArrayList<>(List.of(1));
    return Stream.of(
            //happy path:
            Arguments.of(input1, expected1),
            Arguments.of(input2, expected2),
            Arguments.of(input3, expected3)


    );
  }

  @ParameterizedTest
  @MethodSource("validArraysMapToLength")
  public void userCanMapToLengthForValidList(List<String> initialList, List<Integer> expectedList) {
    List<Integer> actualList = differentMathOperations.mapToLengths(initialList);
    assertEquals(expectedList, actualList);
  }

  @Test
  public void userCanNotMapToLengthForNullList() {
    assertThrows(NullPointerException.class, () -> {
      differentMathOperations.mapToLengths(null);
    }, "Map to length for null list should lead to NullPointerException");

  }
}
