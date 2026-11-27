package org.example.practice13.student_grade;

public class InvalidGradeException extends RuntimeException {
  public InvalidGradeException(String message) {
    super(message);
  }
}
