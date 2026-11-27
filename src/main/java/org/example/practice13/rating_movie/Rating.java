package org.example.practice13.rating_movie;

import java.util.Objects;

public class Rating<T extends Number> {
  private T score;

  public Rating(T score) {
    this.score = score;
  }

  public T getScore() {
    return score;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Rating<?> rating = (Rating<?>) o;
    return Objects.equals(score, rating.score);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(score);
  }
}
