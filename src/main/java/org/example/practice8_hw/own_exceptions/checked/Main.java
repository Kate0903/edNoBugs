package org.example.practice8_hw.own_exceptions.checked;

public class Main {
  public static void main(String[] args) {
    User user1 = new User(2);
    User user2 = new User(150);
    User user3 = new User(151);

    try {
      user1.checkAge();
      user2.checkAge();
      user3.checkAge();
    } catch (InvalidAgeUserException e) {
      System.out.println("Поймали исключение!");
    }


  }
}
