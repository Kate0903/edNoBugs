package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountWordsTest extends DifferentMathOperationsTest {
  /**
   * Тесты для подсчета кол-ва слов в строке:
   * happy path:
   * "Hello world!" -> 2
   * "I am Kate." -> 3
   * "My  homework ." -> 2
   * corner cases:
   * "" -> 0
   * " "-> 0
   * null -> IllegalArgumentException
   */
  @CsvSource({
          //happy path
          "'Hello world!', 2",
          "'I am Kate.', 3",
          "'My  homework. ', 2",
          //corner cases
          "'', 0",
          "' ' , 0"
  })
  @ParameterizedTest
  public void userCanCountWordsValidString(String initialString, int expectedCountWords) {
    int actualCountWords = differentMathOperations.countWords(initialString);
    assertEquals(expectedCountWords, actualCountWords);
  }

  @Test
  public void userCanNotCountWordsNullString() {
    assertThrows(NullPointerException.class, () -> {
      differentMathOperations.countWords(null);
    }, "Count words of null string should lead to NullPointerException");

  }


}
