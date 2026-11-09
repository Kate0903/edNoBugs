package org.example.practice8_hw.additional_tasks.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 6, 7, 8));
    System.out.println(sumOfNumbers(list1));

  }

  public static <T extends Number> double sumOfNumbers(List<T> list) {
    double sum = 0;
    for(T e : list){
      sum = sum + e.doubleValue();
    }
    return sum;


  }
}
