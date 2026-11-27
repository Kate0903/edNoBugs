package org.example.practice13.student_grade;

import java.util.ArrayList;
import java.util.List;

public class GradeService<T extends Number> {
  private List<StudentGrade<T>> listGrade = new ArrayList<>();


  public synchronized void addGrade(StudentGrade<T> student) {
    if (student == null) {
      throw new InvalidGradeException("Значение элемента не может быть null.");
    }
    if (student.getGrade().doubleValue() < 0) {
      throw new InvalidGradeException("Оценка указано неверно.");
    }
    listGrade.add(student);
  }

  public <T extends Number> double calcAverageGrade(List<StudentGrade<T>> listGrade, String subject) {
    double averageGrade = listGrade.stream().filter(e -> e.getSubject().equals(subject))
            .mapToDouble(e -> e.getGrade().doubleValue()).average().orElse(0.0);
    return averageGrade;
  }

  public List<StudentGrade<T>> getListGrade() {
    return List.copyOf(listGrade);
  }
}
