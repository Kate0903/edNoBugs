package org.example.practice8_hw.own_exceptions.checked;

public class InvalidAgeUserException extends Exception {
  public InvalidAgeUserException(String message) {
    super(message);
  }
}
