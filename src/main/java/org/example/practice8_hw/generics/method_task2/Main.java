package org.example.practice8_hw.generics.method_task2;

import java.lang.reflect.Array;

public class Main {
  public static void main(String[] args) {
    Integer[] array1 = {1, 2, 3};
    printArray(array1);

    String[] array2 = {"go", "jump", "walk"};
    printArray(array2);

  }

  public static <T> void printArray(T[] array) {
    for (T element : array) {
      System.out.println(element);
    }
  }
}
