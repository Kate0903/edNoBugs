package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class DetermineAnagramTest extends DifferentMathOperationsTest{
  /**
   * Тесты для определения является ли строка анаграммой:
   * happy path:
   *   "listen, silent" -> true
   * negative cases:
   *    "java, python" -> false
   *    "test, set" -> false
   * corner cases:
   *     null, test -> false
   */
@CsvSource ({
        "listen, silent"
})
@ParameterizedTest
public void userCanDetermineIfStringsIsAnagram(String initialString1, String initialString2){
  boolean actualResult = differentMathOperations.isAnagram(initialString1,initialString2);
  assertTrue(actualResult);
}
  @CsvSource ({
          "java, python",
          "test, set",
          "null, test"
  })
  @ParameterizedTest
  public void userCanDetermineIfStringsIsNotAnagram(String initialString1, String initialString2){
    boolean actualResult = differentMathOperations.isAnagram(initialString1,initialString2);
    assertFalse(actualResult);
  }


}
