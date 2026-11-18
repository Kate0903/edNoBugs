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

public class SortByLengthTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки сортировки списка строк по длине:
   * happy path:
   * [ "Java", "C", "Python"] -> [ "C", "Java", "Python" ]   *
   * corner cases:
   * [ "aa", "bb", "cc" ] -> [ "aa", "bb", "cc" ]
   * [] -> []
   * null -> NullPointerException
   * ["   ", " "] ->[" ", "  "]
   */
  public static Stream<Arguments> validListToSortByLength() {
    List<String> input1 = new ArrayList<>(List.of("Java", "C", "Python"));
    List<String> expected1 = new ArrayList<>(List.of("C", "Java", "Python"));
    List<String> input2 = new ArrayList<>(List.of("aa", "bb", "cc"));
    List<String> expected2 = new ArrayList<>(List.of("aa", "bb", "cc"));
    List<String> input3 = new ArrayList<>(List.of());
    List<String> expected3 = new ArrayList<>(List.of());
    List<String> input4 = new ArrayList<>(List.of("   ", " "));
    List<String> expected4 = new ArrayList<>(List.of(" ", "  "));
    return Stream.of(
            Arguments.of(input1, expected1),
            Arguments.of(input2, expected2),
            Arguments.of(input3, expected3),
            Arguments.of(input4, expected4)
    );
  }

  @ParameterizedTest
  @MethodSource("validListToSortByLength")
  public void userCanSortByLengthValidList(ArrayList<String> initialList, ArrayList<String> expectedSortList) {
    List<String> actualSortList = differentMathOperations.sortByLength(initialList);
    assertEquals(expectedSortList, expectedSortList);
  }

  @Test
  public void userCanNotSortByLengthNullList() {
    assertThrows(NullPointerException.class, () -> {
      differentMathOperations.sortByLength(null);
    }, "Sort by length for null list should lead to NullPointerException");
  }
}
