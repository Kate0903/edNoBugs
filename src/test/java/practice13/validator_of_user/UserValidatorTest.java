package practice13.validator_of_user;

import org.example.practice13.validator_of_user.GlobalFlagValidate;
import org.example.practice13.validator_of_user.InvalidUserException;
import org.example.practice13.validator_of_user.User;
import org.example.practice13.validator_of_user.UserValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тесты на проверку глобального флага:
 * Глобальный флаг true, на вход передаем корректно юзера, который проходит все валидации
 * Глобальный флаг false - проверяем, что валидация не осуществляется
 *
 *  Тесты на проверку валидации имени:
 * Положительный кейс проверен в п.1 при проверке флага
 * Имя из двух слов
 * Имя начинается со строчной буквы
 * Заглавная буква вторая, а не первая
 * Проверка, когда имя пустое
 * Проверка, когда имя null
 *
 * Тесты на проверку валидации возраста:
 * Положительный кейс проверен в п.1 при проверке флага
 * Возраст 18
 * Возраст 100
 * Возраст 17
 * Возраст 101
 * Возраст 0
 * Возраст -1
 *
 * Тесты на проверку email:
 *Положительный кейс проверен в п.1 при проверке флага
 * Нетривиальный положительный кейс: noreply@eastLink.ca
 * b@t.cc
 * bad@.com
 * no-at-symbol
 * @test.com
 * check@gmail
 * null
 * ""
 */

// Тесты на проверку флага
public class UserValidatorTest {

  //Тесты на флаг
  @Test
  public void userCanValidateUserDataWithTrueFlag() {
    GlobalFlagValidate globalFlagValidate = new GlobalFlagValidate(true);
    User user = new User("Иван", 20, "user@user.com");
    UserValidator userValidator = new UserValidator(globalFlagValidate);
    assertDoesNotThrow(() -> userValidator.userValidate(user));
  }

  @Test
  public void userCanValidateUserDataWithFalseFlag() {
    GlobalFlagValidate globalFlagValidate = new GlobalFlagValidate(false);
    User user = new User("", 20, "user@user.com");
    UserValidator userValidator = new UserValidator(globalFlagValidate);
    assertDoesNotThrow(() -> userValidator.userValidate(user));
  }


  // Тесты на проверку имени
  @Test
  public void userCanValidateNameWithTwoWords() {
    GlobalFlagValidate globalFlagValidate = new GlobalFlagValidate(true);
    User user = new User("Галина Петровна", 45, "user@user.com");
    UserValidator userValidator = new UserValidator(globalFlagValidate);
    assertDoesNotThrow(() -> userValidator.userValidate(user));
  }

  @ValueSource(strings = {
    "галя",
    "гАля",
    "",
    "null"
  })
  @ParameterizedTest
  public void userCanGetExceptionWithInvalideName(String name) {
    GlobalFlagValidate globalFlagValidate = new GlobalFlagValidate(true);
    User user = new User(name, 45, "user@user.com");
    UserValidator userValidator = new UserValidator(globalFlagValidate);
    assertThrows(InvalidUserException.class, () -> {userValidator.userValidate(user);
    }, "Try valid name with invalid name user should lead to InvalidUserException");
  }




  //Тесты на проверку возраста
  @ValueSource(ints = {
          18,
          100
  })
  @ParameterizedTest
  public void userCanValidateAgeWithIncludeLeftAndRightBounds(int age) {
    GlobalFlagValidate globalFlagValidate = new GlobalFlagValidate(true);
    User user = new User("Ирина", age, "user@user.com");
    UserValidator userValidator = new UserValidator(globalFlagValidate);
    assertDoesNotThrow(() -> userValidator.userValidate(user));
  }

  @ValueSource(ints = {
          17,
          101,
          0,
          -1
  })
  @ParameterizedTest
  public void userCanGetExceptionWithBoundsAndNearBoundsValuesAge(int age) {
    GlobalFlagValidate globalFlagValidate = new GlobalFlagValidate(true);
    User user = new User("Ирина", age, "user@user.com");
    UserValidator userValidator = new UserValidator(globalFlagValidate);
    assertThrows(InvalidUserException.class, () -> {userValidator.userValidate(user);
    }, "Try valid age with bounds and near bounds value should lead to InvalidUserException");
  }
  //Тесты на проверку email
  @ValueSource(strings = {
          "noreply@eastLink.ca",
          "b@t.cc"
  })
  @ParameterizedTest
  public void userCanValidateCorrectEmail(String email) {
    GlobalFlagValidate globalFlagValidate = new GlobalFlagValidate(true);
    User user = new User("Ирина", 24, email);
    UserValidator userValidator = new UserValidator(globalFlagValidate);
    assertDoesNotThrow(() -> userValidator.userValidate(user));
  }
  @ValueSource(strings = {
          "bad@.com",
          "no-at-symbol",
          "@test.com",
          "check@gmail",
          "null",
          ""

  })
  @ParameterizedTest

  public void userCanGetExceptionWithNotValidEmail(String email) {
    GlobalFlagValidate globalFlagValidate = new GlobalFlagValidate(true);
    User user = new User("Ирина", 24, email);
    UserValidator userValidator = new UserValidator(globalFlagValidate);
    assertThrows(InvalidUserException.class, () -> {userValidator.userValidate(user);
    }, "Try valid wrong email should lead to InvalidUserException");
  }



}
