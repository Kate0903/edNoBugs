package org.example.practice8_hw.own_exceptions.unchecked;

public class InvalidEmailUserException extends RuntimeException {
  public InvalidEmailUserException(String message) {
    super(message);
  }
}
