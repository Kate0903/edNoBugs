package org.example.practice8_hw.own_exceptions.unchecked;

public class Main {
  public static void main(String[] args) {
    User user1 = new User("@test.com");
    User user2 = new User("test@test.com");
    User user3 = new User("user@test.com");

    try {
      user2.checkEmail();
      user1.checkEmail();
      user3.checkEmail();
    } catch (InvalidEmailUserException e) {
      System.out.println("Поймали исключение!");
    }


  }
}
