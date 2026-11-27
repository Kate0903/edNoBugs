package org.example.practice13.rating_movie;



import java.util.Objects;

public class Movie {
  private String name;

  public Movie(String name) {
    if (name == null || name.equals("")) {
      throw new InvalidMovieException("Наименование фильма не может быть пустой строкой или null.");
    }
    String normilizedName = name.trim().toLowerCase();
    this.name = normilizedName;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Movie movie = (Movie) o;
    return Objects.equals(name, movie.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}
