package practice11_hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CheckValidPhoneNumberTest extends DifferentMathOperationsTest {
  /**
   * Тесты для проверки валидности номера телефона:
   * happy path:
   * +1 1234567890 -> true
   * +555 5555555555 -> true
   * +14 1234567993 -> true
   * +1 1234567890 -> true
   * corner cases:
   * "" -> false
   * null -> NullPointerException
   * negative cases:
   * "12345" -> false
   * "invalid" -> false
   * "+1234 4567893452" -> false
   * "+4 557869" -> false
   * "3456723451" -> false
   * "+55 rtgskfthnc" -> false
   */
  @ParameterizedTest
  @ValueSource(strings = {
          "+1 1234567890",
          "+555 5555555555",
          "+14 1234567993",
          "+1 1234567890"
  }
  )
  public void userCanCheckValidNumberPhoneIsCorrect(String initialNumberPhone) {
    boolean actualResult = differentMathOperations.isValidPhoneNumber(initialNumberPhone);
    assertTrue(actualResult);
  }

  @ParameterizedTest
  @ValueSource(strings = {
          "",
          "12345",
          "invalid",
          "+1234 4567893452",
          "+4 557869",
          "3456723451",
          "+55 rtgskfthnc"
  }
  )
  public void userCanCheckValidNumberPhoneIsNotCorrect(String initialNumberPhone) {
    boolean actualResult = differentMathOperations.isValidPhoneNumber(initialNumberPhone);
    assertFalse(actualResult);
  }

  @Test
  public void userCanNotCheckNullNumberPhone() {
    assertThrows(NullPointerException.class, () -> {
      differentMathOperations.isValidPhoneNumber(null);
    }, "Check number phone of null should lead to NullPointerException");
  }

}
