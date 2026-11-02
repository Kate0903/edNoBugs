package org.example.practice8_hw.additional_tasks.task3;

import java.util.List;

public class NumberBox<T extends Number> {
  private double sum;
  private List<T> listOfNumbers;

  public NumberBox(List<T> listOfNumbers) {
    this.listOfNumbers = listOfNumbers;
  }

  public double sumOfNumbers() {
    listOfNumbers.forEach(e -> {
      sum = sum + e.doubleValue();
    });
    return sum;

  }
}
