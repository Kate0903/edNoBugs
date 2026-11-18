package practice11_cw;

import org.example.practice11_cw.StringProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@DisplayName("class StringProcessor, method reverse")
public class ReverseStringTest extends StringProcessorTest{
  /**
   * Тесты для переворота строки:
   *  happy path: "sasha" -> "ahsas"
   *  corner cases:
   *        "" -> ""
   *        "a" -> "a"
   *        null -> IllegalArgument Exception
   */

  public static Stream<Arguments> validStringToReverse(){
    return Stream.of(
            //happy path:
            Arguments.of("sasha", "ahsas"),
            //corner cases: "" -> ""
            Arguments.of("", ""),
            //corner cases: "a" -> "a"
            Arguments.of("a", "a"));

  }
  @ParameterizedTest
  @MethodSource("validStringToReverse")
  public void userCanReverseValidString(String initialString, String expectedString){



    String reverseString = stringProcessor.reverse(initialString);
    assertEquals(expectedString, reverseString, "String reversed incorrectly!!!");
  }

  @Test
  public void userCannotReverseNullString() {


    assertThrows(IllegalArgumentException.class, () -> {
      stringProcessor.reverse(null);
    }, "Reversing of null string should lead to IllegalArgumentException");
  }



}
