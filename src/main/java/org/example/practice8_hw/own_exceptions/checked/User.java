package org.example.practice8_hw.own_exceptions.checked;

public class User {
  private int age;

  public User(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public void checkAge() throws InvalidAgeUserException {
    if (this.age < 0 || this.age > 150) {
      throw new InvalidAgeUserException("Возраст пользователя указан неверно.");
    } else System.out.println("Возраст пользователя успешно проверен.");
  }
}
