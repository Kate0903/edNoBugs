package practice13.student_grade;

import org.example.practice13.student_grade.GradeService;
import org.example.practice13.student_grade.InvalidGradeException;
import org.example.practice13.student_grade.StudentGrade;
import org.example.practice13.validator_of_user.GlobalFlagValidate;
import org.example.practice13.validator_of_user.InvalidUserException;
import org.example.practice13.validator_of_user.User;
import org.example.practice13.validator_of_user.UserValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Проверки по добавлению студентов для хранения оценок:
 * Добавление 1 студента в пустой список
 * Добавление подряд несколько студентов(Одинаковые)+проверка добавление в непустой список (все студенты разные) - int
 * Добавление подряд несколько студентов(один студент и разные предметы, студент другой, но предмет тот же)-double
 * Успешное добавление с оценкой 0
 * Отрицательная оценка - исключение
 * оценка null
 * null элемент списка-исключение
 * Проверка, когда передано пустое имя ""
 * Проверка имя - null
 * Проверка предмет ""
 * Проверка предмет null
 * <p>
 * Проверки расчета среднего значения оценок по предмету:
 * Кейс с валидными значениями + в списке есть несколько студентов с одним и тем же предметом
 * Кейс с валидным значением, но с указанным предметом 1 запись
 * С указанным предметом нет элементов
 */
public class GradeServiceTest {
  //Тесты на добавление
  @Test
  public void userCanAddStudentInEmptyList() {
    StudentGrade<Integer> studentGrade = new StudentGrade<>("Ирина", "математика", 3);
    GradeService<Integer> gradeService = new GradeService<>();
    StudentGrade<Integer> expectedStudentGrade = new StudentGrade<>("Ирина", "математика", 3);

    gradeService.addGrade(studentGrade);

    List<StudentGrade<Integer>> actualGradeServiceList = gradeService.getListGrade();

    assertAll(
            () -> assertTrue(gradeService.getListGrade().contains(studentGrade)),
            () -> assertEquals(expectedStudentGrade, studentGrade),
            () -> assertEquals(expectedStudentGrade.getName(), actualGradeServiceList.getFirst().getName()),
            () -> assertEquals(expectedStudentGrade.getSubject(), actualGradeServiceList.getFirst().getSubject()),
            () -> assertEquals(expectedStudentGrade.getGrade(), actualGradeServiceList.getFirst().getGrade()),
            () -> assertEquals(1, actualGradeServiceList.size())

    );
  }

  @Test
  public void userCanAddMoreOneEqualStudentInList() {
    StudentGrade<Integer> studentGrade1 = new StudentGrade<>("Ирина", "математика", 3);
    StudentGrade<Integer> studentGrade2 = new StudentGrade<>("Ирина", "математика", 3);
    GradeService<Integer> gradeService = new GradeService<>();

    gradeService.addGrade(studentGrade1);
    gradeService.addGrade(studentGrade2);

    List<StudentGrade<Integer>> actualGradeServiceList = gradeService.getListGrade();

    assertEquals(2, actualGradeServiceList.size());
  }


  @Test
  public void userCanAddMoreOneDifferentStudentInList() {
    StudentGrade<Double> studentGrade1 = new StudentGrade<>("Ирина", "математика высшая", 4.0);
    StudentGrade<Double> studentGrade2 = new StudentGrade<>("Ирина", "физика", 4.0);
    StudentGrade<Double> studentGrade3 = new StudentGrade<>("Маргарита Ивановна", "физика", 4.0);
    GradeService<Double> gradeService = new GradeService<>();

    gradeService.addGrade(studentGrade1);
    gradeService.addGrade(studentGrade2);
    gradeService.addGrade(studentGrade3);

    List<StudentGrade<Double>> actualGradeServiceList = gradeService.getListGrade();
    assertEquals(3, actualGradeServiceList.size());
  }

  @Test
  public void userCanAddStudentWithZeroGradeInList() {
    StudentGrade<Integer> studentGrade1 = new StudentGrade<>("Ирина", "математика", 0);

    GradeService<Integer> gradeService = new GradeService<>();

    gradeService.addGrade(studentGrade1);

    List<StudentGrade<Integer>> actualGradeServiceList = gradeService.getListGrade();
    assertAll(
            () -> assertEquals(1, actualGradeServiceList.size()),
            () -> assertEquals(0, actualGradeServiceList.getFirst().getGrade())
    );
  }

  @Test
  public void userCanNotCreateAndAddStudentWithNullGradeInList() {

    assertThrows(InvalidGradeException.class, () -> {
      new StudentGrade<>("Ирина", "математика", null);
    }, "Try create student with null grade in List should lead to InvalidGradeException");
  }

  @Test
  public void userCanNotAddNullInGradeServiceList() {

    GradeService<Integer> gradeService = new GradeService<>();


    assertThrows(InvalidGradeException.class, () -> {
      gradeService.addGrade(null);
    }, "Try add null student in List should lead to InvalidGradeException");

  }

  @Test
  public void userCanNotAddStudentWithNegativeGradeInList() {
    StudentGrade<Double> studentGrade1 = new StudentGrade<>("Ирина", "математика", -1.0);

    GradeService<Double> gradeService = new GradeService<>();
    assertThrows(InvalidGradeException.class, () -> {
      gradeService.addGrade(studentGrade1);
    }, "Try add negative grade in List should lead to InvalidGradeException");
  }

  @Test
  public void userCanNotCreateAndAddStudentWithEmptyNameInList() {
    assertThrows(InvalidGradeException.class, () -> {
      new StudentGrade<>("", "математика", 5.0);
    }, "Try create student with empty name in List should lead to InvalidGradeException");
  }

  @Test
  public void userCanNotCreateAndAddStudentWithNullNameInList() {
    assertThrows(InvalidGradeException.class, () -> {
      new StudentGrade<>(null, "математика", 5.0);
    }, "Try create student with null name in List should lead to InvalidGradeException");
  }

  @Test
  public void userCanNotCreateAndAddStudentWithEmptySubjectInList() {
    assertThrows(InvalidGradeException.class, () -> {
      new StudentGrade<>("Петр", "", 5.0);
    }, "Try create student with empty subject in List should lead to InvalidGradeException");
  }

  @Test
  public void userCanNotCreateAndAddStudentWithNullSubjectInList() {
    assertThrows(InvalidGradeException.class, () -> {
      new StudentGrade<>("Рита", null, 5.0);
    }, "Try create student with null name in List should lead to InvalidGradeException");
  }

  // Тесты на проверку среднего значения оценок
  @Test
  public void userCanCalcAverageGradeWithMoreOneStudent() {
    StudentGrade<Double> studentGrade1 = new StudentGrade<>("Ирина", "математика", 4.0);
    StudentGrade<Double> studentGrade2 = new StudentGrade<>("Рита", "математика", 5.0);
    StudentGrade<Double> studentGrade3 = new StudentGrade<>("Маргарита Ивановна", "физика", 4.0);
    StudentGrade<Double> studentGrade4 = new StudentGrade<>("Лена", "математика", 3.0);
    GradeService<Double> gradeService = new GradeService<>();

    gradeService.addGrade(studentGrade1);
    gradeService.addGrade(studentGrade2);
    gradeService.addGrade(studentGrade3);
    gradeService.addGrade(studentGrade4);

    List<StudentGrade<Double>> actualGradeServiceList = gradeService.getListGrade();
    double actualAverageGrade = gradeService.calcAverageGrade(actualGradeServiceList, "математика");

    assertEquals(4, actualAverageGrade);
  }

  @Test
  public void userCanCalcAverageGradeWithOneStudent() {
    StudentGrade<Double> studentGrade1 = new StudentGrade<>("Ирина", "математика", 4.0);
    StudentGrade<Double> studentGrade2 = new StudentGrade<>("Рита", "математика", 5.0);
    StudentGrade<Double> studentGrade3 = new StudentGrade<>("Маргарита Ивановна", "физика", 4.0);
    StudentGrade<Double> studentGrade4 = new StudentGrade<>("Лена", "математика", 3.0);
    GradeService<Double> gradeService = new GradeService<>();

    gradeService.addGrade(studentGrade1);
    gradeService.addGrade(studentGrade2);
    gradeService.addGrade(studentGrade3);
    gradeService.addGrade(studentGrade4);

    List<StudentGrade<Double>> actualGradeServiceList = gradeService.getListGrade();
    double actualAverageGrade = gradeService.calcAverageGrade(actualGradeServiceList, "физика");

    assertEquals(4, actualAverageGrade);
  }

  @Test
  public void userCanCalcAverageGradeWithoutStudent() {
    StudentGrade<Double> studentGrade1 = new StudentGrade<>("Ирина", "математика", 4.0);
    StudentGrade<Double> studentGrade2 = new StudentGrade<>("Рита", "математика", 5.0);
    StudentGrade<Double> studentGrade3 = new StudentGrade<>("Маргарита Ивановна", "физика", 4.0);
    StudentGrade<Double> studentGrade4 = new StudentGrade<>("Лена", "математика", 3.0);
    GradeService<Double> gradeService = new GradeService<>();

    gradeService.addGrade(studentGrade1);
    gradeService.addGrade(studentGrade2);
    gradeService.addGrade(studentGrade3);
    gradeService.addGrade(studentGrade4);

    List<StudentGrade<Double>> actualGradeServiceList = gradeService.getListGrade();
    double actualAverageGrade = gradeService.calcAverageGrade(actualGradeServiceList, "экономика");

    assertEquals(0, actualAverageGrade);
  }
}
