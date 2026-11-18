package practice11_cw;

import org.example.practice11_cw.StringProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IsPolidromeTest extends StringProcessorTest{

  /**
   * Тесты для проверки, является ли палиндромом:
   *   позитивные кейсы:
   *   - четное кол-во: "abba" -> true
   *   - нечетное кол-во: "hah" -> true
   *   негативные кейсы:
   *   - "john" -> false
   *   corner cases:
   *   - "a" -> true
   *   - "" -> true
   *   - null -> IllegalArgumentException
   */
  @ParameterizedTest
  @ValueSource(strings = {
          //позитивные кейсы
          "abba", "hah",
          //угловые кесы
          "a",""})

  public void userCanCheckIfValidStringIsPalidrom(String initialString){

    boolean actualResult = stringProcessor.isPalindrome(initialString);
    assertTrue(actualResult);
  }
  @Test
  public void userCanCheckIfValidStringIsNotPalidrom(){

    String initialString = "john";
    boolean actualResult = stringProcessor.isPalindrome(initialString);
    assertFalse(actualResult);
  }
  @Test
  public void userCannotCheckIfNullStringIsPalidrom() {


    assertThrows(IllegalArgumentException.class, () -> {
      stringProcessor.reverse(null);
    }, "Checking if null string is palidrom should lead to IllegalArgumentException");
  }
}

