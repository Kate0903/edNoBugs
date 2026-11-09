package org.example.practice8_hw.additional_tasks.task3;

import java.util.List;

public class NumberBox<T extends Number> {

  private List<T> listOfNumbers;

  public NumberBox(List<T> listOfNumbers) {
    this.listOfNumbers = listOfNumbers;
  }

  public double sumOfNumbers() {
    double sum = 0;
    for (T e : listOfNumbers) {
      sum = sum + e.doubleValue();
    }
    return sum;

  }
}
