package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SplitStringTest extends DifferentMathOperationsTest {
  /**
   * Тесты для разбиения строки на части по разделителю:
   * happy path:
   * "Java,Python,C++", "," -> ["Java", "Python", "C++"]
   * <p>
   * corner cases:
   * "word", "," → ["word"]
   * "Java, ", "," -> ["Java", " "]
   * "", "," -> [""]
   * null -> NullPointerException
   */
  public static Stream<Arguments> validStringsToSplitStrings() {
    return Stream.of(
            //happy path:
            Arguments.of("Java,Python,C++", ",", new String[]{"Java", "Python", "C++"}),
            Arguments.of("word", ",", new String[]{"word"}),
            Arguments.of("Java, ", ",", new String[]{"Java", " "}),
            Arguments.of("", ",", new String[]{""})

    );
  }

  @ParameterizedTest
  @MethodSource("validStringsToSplitStrings")
  public void userCanSplitStringForValidString(String initialString, String delimiter, String[] expectedArrayString) {
    String[] actualArrayString = differentMathOperations.splitString(initialString, delimiter);
    assertArrayEquals(expectedArrayString, actualArrayString);
  }

  @Test
  public void userCanNotSplitStringNullString() {
    assertThrows(NullPointerException.class, () -> {
      differentMathOperations.splitString(null, ",");
    }, "Split string for null string should lead to NullPointerException");
  }


}
