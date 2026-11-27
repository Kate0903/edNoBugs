package practice13.rating_movie;

import org.example.practice13.rating_movie.InvalidMovieException;
import org.example.practice13.rating_movie.Movie;
import org.example.practice13.rating_movie.MovieService;
import org.example.practice13.rating_movie.Rating;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Проверки на добавление:
 * Добавление 1 фильма в пустой список(int), все поля указаны с валидными значениями
 * Добавление последовательно несколько элементов в справочник(double), все элементы разные
 * Добавление несколько одинаковых элементов
 * Добавление одинакового наименования фильма, но с пробелом лишним
 * Добавление одинакового наименования фильма, но с заглавной буквы
 * Добавление одно и того же фильма с разными оценками
 * Добавление разных фильмов с одинаковыми оценками
 * Добавление при оценке 1
 * Добавление при оценке 10
 * Получение исключения при добавлении с оценкой 0
 * Получение исключения при добавлении с оценкой 11
 * Получение исключения при добавлении с оценкой -1
 * Получение исключения с наименованием фильма ""
 * Получение исключения с наименованием фильма null
 * <p>
 * Проверки на среднюю оценку фильма:
 * Проверить вычисление средней оценки, если указана 1 оценка для 1 фильма
 * Проверить среднюю оценку для 1 фильма с множеством оценок (в мапе есть другие также фильмы)
 * Проверить получение исключение при передаче в параметре фильма = null - исключено, т.к. нет возможности создать объект movie с таким значением
 * Проверить получение исключение при передаче в параметре фильма = "" - исключено, т.к. нет возможности создать объект movie с таким значением
 * Проверка получения средней оценки, если в функцию передано значение в другом регистре
 * Проверка получения средней оценки, если в функцию передано значение с пробелом
 * Проверка получения 0.0 в методе вычисления среднего значения в случае, если мапа пуста
 * Проверка получения 0.0 в методе вычисления среднего значения в случае, если указано наименование фильма, которого нет в мапе
 * <p>
 * Проверка сортировки по среднему рейтингу:
 * Проверить сортировку, например для 3х фильмов, у которых по 2 или 3 оценки *
 *
 *
 */
public class MovieServiceTest {
  //Тесты на добавление
  @Test
  public void userCanAddOneValidMovieRating() {
    Movie nameMovie = new Movie("Каникулы строгого режима!");
    Movie expectnameMovie = new Movie("Каникулы строгого режима!");
    Rating expectedRating = new Rating(2);

    MovieService movieService = new MovieService();

    movieService.addScoreMovie(nameMovie, 2);
    Map<Movie, List<Rating>> actualRatingMovie = movieService.getRatingMovie();


    assertAll(
            () -> assertEquals(1, actualRatingMovie.size()),
            () -> assertEquals(1, actualRatingMovie.get(nameMovie).size()),
            () -> assertTrue(movieService.getRatingMovie().containsKey(expectnameMovie)),
            () -> assertTrue(movieService.getRatingMovie().get(expectnameMovie).contains(new Rating<Integer>(2))),
            () -> assertEquals(expectnameMovie, actualRatingMovie.keySet().iterator().next()),
            () -> assertEquals(expectedRating, actualRatingMovie.values().iterator().next().getFirst()),
            () -> assertEquals(2, actualRatingMovie.values().iterator().next().getFirst().getScore()),
            () -> assertEquals(expectnameMovie.getName(), actualRatingMovie.keySet().iterator().next().getName())
    );
  }

  @Test
  public void userCanAddMoreOneValidMovieRating() {
    Movie nameMovie1 = new Movie("Каникулы строгого режима!");
    Movie nameMovie2 = new Movie("Сумерки");
    Movie nameMovie3 = new Movie("Опенгеймер");

    MovieService movieService = new MovieService();

    movieService.addScoreMovie(nameMovie1, 2.0);
    movieService.addScoreMovie(nameMovie2, 3.0);
    movieService.addScoreMovie(nameMovie3, 4.0);

    assertEquals(3, movieService.getRatingMovie().size());

  }

  @Test
  public void userCanAddMoreOneEqualValidMovieRating() {
    Movie nameMovie1 = new Movie("Сумерки");
    Movie nameMovie2 = new Movie("Сумерки");

    MovieService movieService = new MovieService();

    movieService.addScoreMovie(nameMovie1, 2.0);
    movieService.addScoreMovie(nameMovie2, 2.0);
    Map<Movie, List<Rating>> actualRatingMovie = movieService.getRatingMovie();

    assertAll(
            () -> assertEquals(1, actualRatingMovie.size()),
            () -> assertEquals(2, actualRatingMovie.get(nameMovie1).size()));
  }

  @Test
  public void userCanAddMoreOneValidMovieRatingDifferentNameSpace() {
    Movie nameMovie1 = new Movie("Сумерки");
    Movie nameMovie2 = new Movie("Сумерки ");

    MovieService movieService = new MovieService();

    movieService.addScoreMovie(nameMovie1, 2.0);
    movieService.addScoreMovie(nameMovie2, 2.0);
    Map<Movie, List<Rating>> actualRatingMovie = movieService.getRatingMovie();

    assertAll(
            () -> assertEquals(1, actualRatingMovie.size()),
            () -> assertEquals(2, actualRatingMovie.get(nameMovie1).size()));
  }

  @Test
  public void userCanAddMoreOneValidMovieRatingDifferentNameRegister() {
    Movie nameMovie1 = new Movie("Сумерки");
    Movie nameMovie2 = new Movie("сумерки");

    MovieService movieService = new MovieService();

    movieService.addScoreMovie(nameMovie1, 2.0);
    movieService.addScoreMovie(nameMovie2, 2.0);
    Map<Movie, List<Rating>> actualRatingMovie = movieService.getRatingMovie();

    assertAll(
            () -> assertEquals(1, actualRatingMovie.size()),
            () -> assertEquals(2, actualRatingMovie.get(nameMovie1).size()));
  }

  @Test
  public void userCanAddMoreOneNotEqualRatingAndEqualMovie() {
    Movie nameMovie1 = new Movie("Сумерки");
    Movie nameMovie2 = new Movie("Сумерки");

    MovieService movieService = new MovieService();

    movieService.addScoreMovie(nameMovie1, 2.0);
    movieService.addScoreMovie(nameMovie2, 3.0);
    Map<Movie, List<Rating>> actualRatingMovie = movieService.getRatingMovie();

    assertAll(
            () -> assertEquals(1, actualRatingMovie.size()),
            () -> assertEquals(2, actualRatingMovie.get(nameMovie1).size()));
  }

  @Test
  public void userCanAddMoreOneNotEqualMovieAndEqualRating() {
    Movie nameMovie1 = new Movie("Сумерки");
    Movie nameMovie2 = new Movie("Феррари");

    MovieService movieService = new MovieService();

    movieService.addScoreMovie(nameMovie1, 2.0);
    movieService.addScoreMovie(nameMovie2, 2.0);
    Map<Movie, List<Rating>> actualRatingMovie = movieService.getRatingMovie();
    assertAll(
            () -> assertEquals(2, actualRatingMovie.size()),
            () -> assertEquals(1, actualRatingMovie.get(nameMovie1).size()),
            () -> assertEquals(1, actualRatingMovie.get(nameMovie2).size()));
  }

  @ValueSource(ints = {
          1,
          10
  })
  @ParameterizedTest
  public void userCanAddIncludeBoundsValueRatingMovie(Integer score) {
    Movie nameMovie1 = new Movie("Cумерки");

    MovieService movieService = new MovieService();

    movieService.addScoreMovie(nameMovie1, score);
    Map<Movie, List<Rating>> actualRatingMovie = movieService.getRatingMovie();

    assertAll(
            () -> assertEquals(1, actualRatingMovie.size()),
            () -> assertEquals(1, actualRatingMovie.get(nameMovie1).size()),
            () -> assertEquals(score, actualRatingMovie.get(nameMovie1).getFirst().getScore()));
  }

  @ValueSource(ints = {
          0,
          11,
          -1
  })
  @ParameterizedTest
  public void userCanNotAddNotValidBoundsValueRatingMovie(Integer score) {
    Movie nameMovie1 = new Movie("Сумерки");

    MovieService movieService = new MovieService();

    assertThrows(InvalidMovieException.class, () -> {
      movieService.addScoreMovie(nameMovie1, score);
    }, "Try add rating with bounds and near bounds value should lead to InvalidMovieException");
  }

  @Test
  public void userCanNotCreateMovieRatingWithEmptyNameMovie() {
    assertThrows(InvalidMovieException.class, () -> {
      new Movie("");
    }, "Try create movie rating with empty name should lead to InvalidMovieException");
  }

  @Test
  public void userCanNotCreateMovieRatingWithNullNameMovie() {

    assertThrows(InvalidMovieException.class, () -> {
      new Movie(null);
    }, "Try create movie rating with empty name should lead to InvalidMovieException");
  }

  //Тесты на получение среднего значения оценок
  @Test
  public void userCanCalcAverageRatingOneMovieAndScore() {
    Movie nameMovie1 = new Movie("Чебурашка");

    MovieService movieService = new MovieService();
    movieService.addScoreMovie(nameMovie1, 3.0);
    Double actualAverageRating = movieService.calcAverageRating(nameMovie1.getName());

    assertEquals(3.0, actualAverageRating);

  }

  @Test
  public void userCanCalcAverageRatingOneMovieAndMoreOneScore() {
    Movie nameMovie1 = new Movie("Чебурашка");
    Movie nameMovie2 = new Movie("Опенгеймер");

    MovieService movieService = new MovieService();
    movieService.addScoreMovie(nameMovie1, 3.0);
    movieService.addScoreMovie(nameMovie1, 4.0);
    movieService.addScoreMovie(nameMovie1, 9.0);
    movieService.addScoreMovie(nameMovie2, 7.0);
    movieService.addScoreMovie(nameMovie2, 4.0);
    Double actualAverageRating1 = movieService.calcAverageRating(nameMovie1.getName());
    Double actualAverageRating2 = movieService.calcAverageRating(nameMovie2.getName());

    assertAll(
            () -> assertEquals(5.33, actualAverageRating1, 0.01),
            () -> assertEquals(5.5, actualAverageRating2, 0.01));


  }


  @Test
  public void userCanCalcAverageRatingWithNullMapMovieService() {
    Movie nameMovie1 = new Movie("Чебурашка");

    MovieService movieService = new MovieService();

    Double actualAverageRating = movieService.calcAverageRating(nameMovie1.getName());


    assertEquals(0.0, actualAverageRating);

  }

  @Test
  public void userCanCalcAverageRatingForDifferentRegisterName() {
    Movie nameMovie1 = new Movie("Чебурашка");
    Movie nameMovie2 = new Movie("Ёлки");
    Movie nameMovie3 = new Movie("ёлки");

    MovieService movieService = new MovieService();
    movieService.addScoreMovie(nameMovie1, 2.0);
    movieService.addScoreMovie(nameMovie1, 5.0);
    movieService.addScoreMovie(nameMovie2, 5.0);

    Double actualAverageRating = movieService.calcAverageRating(nameMovie3.getName());

    assertEquals(5.0, actualAverageRating);

  }

  @Test
  public void userCanCalcAverageRatingForNameWithSpace() {
    Movie nameMovie1 = new Movie("Чебурашка");
    Movie nameMovie2 = new Movie("Ёлки");
    Movie nameMovie3 = new Movie("Ёлки ");

    MovieService movieService = new MovieService();
    movieService.addScoreMovie(nameMovie1, 2.0);
    movieService.addScoreMovie(nameMovie2, 3.0);
    movieService.addScoreMovie(nameMovie2, 5.0);

    Double actualAverageRating = movieService.calcAverageRating(nameMovie3.getName());

    assertEquals(4.0, actualAverageRating);

  }

  // Тесты на проверку сортировки:
  @Test
  public void userCanSortAverageRatingForValidMap() {
    Movie nameMovie1 = new Movie("Чебурашка");
    Movie nameMovie2 = new Movie("Ёлки");
    Movie nameMovie3 = new Movie("Ёлки-2");

    MovieService movieService = new MovieService();
    movieService.addScoreMovie(nameMovie1, 10);
    movieService.addScoreMovie(nameMovie1, 10);
    movieService.addScoreMovie(nameMovie3, 6);
    movieService.addScoreMovie(nameMovie3, 2);
    movieService.addScoreMovie(nameMovie2, 10);
    movieService.addScoreMovie(nameMovie2, 8);

    Map<Movie, Double> actualSortAverageRating = movieService.sortOfRating();
    assertAll(
            () -> assertEquals("чебурашка", actualSortAverageRating.keySet().iterator().next().getName()),
            () -> assertEquals("ёлки", actualSortAverageRating
                    .keySet().stream().skip(1).map(e -> e.getName()).findFirst().orElse(null)),
            () -> assertEquals("ёлки-2", actualSortAverageRating
                    .keySet().stream().skip(2).map(e -> e.getName()).findFirst().orElse(null)),
            () -> assertEquals(10.0, actualSortAverageRating.values().iterator().next(), 0.01),
            () -> assertEquals(9.0, actualSortAverageRating.values().stream().skip(1).iterator()
                    .next(), 0.01),
            () -> assertEquals(4.0, actualSortAverageRating.values().stream().skip(2).iterator()
                    .next(), 0.01));

  }

  @Test
  public void userCanSortAverageRatingWithEmptyMap() {

    MovieService movieService = new MovieService();

    assertThrows(InvalidMovieException.class, () -> {
      movieService.sortOfRating();
    }, "Try empty map should lead to InvalidMovieException");

  }
}
