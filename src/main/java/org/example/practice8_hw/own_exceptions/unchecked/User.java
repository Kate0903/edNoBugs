package org.example.practice8_hw.own_exceptions.unchecked;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
  private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
  // Компилируем паттерн один раз для повторного использования (повышает производительность)
  private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
  private String email;

  public User(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void checkEmail() throws InvalidEmailUserException {

    // Создаем Matcher для конкретной строки email
    Matcher matcher = EMAIL_PATTERN.matcher(this.email);
    if (!matcher.matches()) {
      throw new InvalidEmailUserException("Электронный адрес указан неверно.");
    } else System.out.println("Электронный адрес указан верно.");


  }
}
