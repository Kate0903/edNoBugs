package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseStringTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки разворота строки:
   * happy path:
   * trast -> tsart
   * set5 -> 5tes
   * 8234 -> 4328
   * Chat -> tahC
   * MAX -> XAM
   * corner cases:
   * t -> t
   * "" -> ""
   * null -> IllegalArgumentException
   */

  @ParameterizedTest
  @CsvSource({
          //happy path:
          "trast, tsart",
          "set5, 5tes",
          "8234, 4328",
          "Chat, tahC",
          "MAX, XAM",
          //corner cases:
          "t, t",
          "'', ''"
  })
  public void userCanReverseValidString(String initialString, String expectedReverseString) {
    String actualReverseString = differentMathOperations.reverse(initialString);
    assertEquals(actualReverseString, expectedReverseString);
  }

  @Test
  public void userCanGetNullReverseStringForNullString() {
    String actualReverseNullString = differentMathOperations.reverse(null);
    assertNull(actualReverseNullString);

  }
}
