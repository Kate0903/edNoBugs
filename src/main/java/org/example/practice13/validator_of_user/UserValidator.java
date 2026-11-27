package org.example.practice13.validator_of_user;

import org.example.practice8_hw.own_exceptions.checked.InvalidAgeUserException;

import java.util.regex.Pattern;

import static java.lang.Character.toUpperCase;

public class UserValidator {
  private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
  private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
  private boolean flagValidate;

  public UserValidator(GlobalFlagValidate flagValidate) {
    this.flagValidate = flagValidate.isValidationEnabled();
  }

  public void userValidate(User user) {
    if (user == null) {
      throw new InvalidUserException("Значение объекта не может быть null.");
    }
    if (!flagValidate) {
      return;
    }
    nameValidate(user.getName());
    AgeValidate(user.getAge());
    emailValidate(user.getEmail());
  }

  private void nameValidate(String name) {
    if (name == null || name.isEmpty()) {
      throw new InvalidUserException("Имя пользователя не может быть null или пустым.");
    }
    if (!Character.isUpperCase(name.charAt(0))) {
      throw new InvalidUserException("Имя пользователя должно быть указано с заглавной буквы.");
    }
  }

  private void AgeValidate(int age) {
    if (age < 18 || age > 100) {
      throw new InvalidUserException("Возраст пользователя должен быть от 18 до 100 включительно.");
    }
  }

  private void emailValidate(String email) {
    if (email == null) {
      throw new InvalidUserException("Email пользователя не должен быть равен null.");
    }
    if (!EMAIL_PATTERN.matcher(email.trim()).matches()) {
      throw new InvalidUserException("Email пользователя указан неверно.");
    }

  }


}
