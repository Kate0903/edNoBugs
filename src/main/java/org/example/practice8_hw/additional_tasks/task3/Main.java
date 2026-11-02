package org.example.practice8_hw.additional_tasks.task3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    NumberBox numberBox = new NumberBox(new ArrayList(Arrays.asList(1, 3, 5, 4, 50)));
    System.out.println(numberBox.sumOfNumbers());

  }
}
