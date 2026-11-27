package org.example.practice13.rating_movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieService {
  private final Map<Movie, List<Rating>> ratingMovie = new HashMap<>();


  public synchronized <T extends Number> void addScoreMovie(Movie nameMovie, T score) {
    if (nameMovie.getName() == null || score == null || ratingMovie == null) {
      throw new InvalidMovieException("Элементы словаря не могут быть null.");
    }
    if (score.doubleValue() < 1.0 || score.doubleValue() > 10) {
      throw new InvalidMovieException("Оценка должна быть в пределах от 1 до 10(включительно)");
    }
    String normilizedNameMovie = nameMovie.getName().trim().toLowerCase();

    if (normilizedNameMovie.equals("")) {
      throw new InvalidMovieException("Наименование фильма не может быть пустым.");
    }
    Movie keyMovie = new Movie(normilizedNameMovie);
    if (ratingMovie.containsKey(keyMovie)) {
      ratingMovie.get(keyMovie).add(new Rating(score));
    } else {

      ratingMovie.put(new Movie(normilizedNameMovie), new ArrayList<>(List.of(new Rating(score))));
    }
  }

  public double calcAverageRating(String nameMovie) {
    if (nameMovie == null || nameMovie.equals("")) {
      throw new InvalidMovieException("Наименование фильма не может быть пустым или null.");
    }
    String normilizedNameMovie = nameMovie.trim().toLowerCase();
    if (normilizedNameMovie.equals("")) {
      throw new InvalidMovieException("Наименование фильма не может быть пустым.");
    }

    double avarageRating = ratingMovie.entrySet().stream()
            .filter(entry -> entry.getKey().getName().equals(normilizedNameMovie))
            .flatMapToDouble(e -> e.getValue().stream()
                    .mapToDouble(r -> r.getScore().doubleValue())).average().orElse(0.0);

    return avarageRating;

  }

  public Map<Movie, Double> sortOfRating() {
    if (ratingMovie == null || ratingMovie.isEmpty()) {
      throw new InvalidMovieException("Пустой справочник фильмов и рейтингов не может быть отсортирован.");
    }
    Map<Movie, Double> sortAverageRatings = ratingMovie.entrySet().stream()
            .map(entry -> Map.entry(entry.getKey(), calcAverageRating(entry.getKey().getName())))
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(e -> e.getKey(),
                    e -> e.getValue(),
                    (e1, e2) -> e1,
                    () -> new LinkedHashMap<>())).reversed();


    return sortAverageRatings;
  }

  public Map<Movie, List<Rating>> getRatingMovie() {
    return ratingMovie.entrySet().stream()
            .collect(Collectors.toUnmodifiableMap(
                    Map.Entry::getKey,
                    entry -> List.copyOf(entry.getValue()) // защищаем внутренний List от изменений
            ));
  }
}
