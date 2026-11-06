package org.example.practice9_cw.streamapi;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedUniqueElements {
  static void main() {
    //список с дублированными значениями
    //вывести все уникальные значения в отсортированном порядке

    List<Integer> numbers = Arrays.asList(3,2,3,1,4,2,5);
    List<Integer> uniqueSorted = numbers.stream()
            .distinct()
            .sorted()
            .peek(n -> System.out.println("sorted: " + n))
            .collect(Collectors.toList());
    System.out.println(uniqueSorted);
  }

}
