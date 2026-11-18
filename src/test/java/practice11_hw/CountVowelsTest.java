package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountVowelsTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки кол-ва гласных в строке:
   * happy path:
   * hello -> 2
   * java -> 2
   * AEIOU -> 5
   * corner cases:
   * str -> 0
   * null -> IllegalArgumentException
   */
  @ParameterizedTest
  @CsvSource({
          "hello, 2",
          "java, 2",
          "AEIOU, 5",
          "str, 0"})
  public void userCanCountOfVowelsForString(String initialString, int expectedCountOfVowels) {
    int actualCountOfVowels = differentMathOperations.countVowels(initialString);
    assertEquals(expectedCountOfVowels, actualCountOfVowels);
  }

  @Test
  public void userCanNotCountOfVowelsForNullString() {
    assertThrows(IllegalArgumentException.class, () -> {
      differentMathOperations.countVowels(null);
    }, "Count vowels of null string should lead to IllegalArgumentException");

  }


}





