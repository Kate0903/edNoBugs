package org.example.practice8_hw.additional_tasks.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 10, 65, 99));
    printList(list1);

  }

  public static <T> void printList(List<T> list) {
    list.forEach(System.out::println);
  }
}
