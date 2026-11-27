package org.example.practice13.rating_movie;

public class InvalidMovieException extends RuntimeException {
  public InvalidMovieException(String message) {
    super(message);
  }
}
