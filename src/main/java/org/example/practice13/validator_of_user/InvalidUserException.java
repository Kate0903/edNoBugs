package org.example.practice13.validator_of_user;

public class InvalidUserException extends RuntimeException {
  public InvalidUserException(String message) {
    super(message);
  }
}
