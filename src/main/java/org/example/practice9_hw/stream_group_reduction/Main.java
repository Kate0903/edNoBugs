package org.example.practice9_hw.stream_group_reduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
  static void main() {
    // 1. Группировка строк по первой букве
    //Задача: Напишите программу, которая принимает список строк и группирует их по первой букве, используя Stream API.
    List<String> listBefore = new ArrayList<>(List.of("function", "stream", "food", "loop", "string", "fail"));
    Map<String, List<String>> mapAfter = listBefore.stream()
            .collect(Collectors.groupingBy(x -> x.substring(0, 1)));
    System.out.println(mapAfter);

    // 2. Группировка чисел по чётности
    //Задача: Напишите программу, которая принимает список чисел и группирует их
    // на чётные и нечётные, используя Stream API.
    List<Integer> listInt1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    Map<Boolean, List<Integer>> groupsInt = listInt1.stream()
            .collect(Collectors.groupingBy(x -> x % 2 == 0));
    System.out.println(groupsInt);

    //3. Поиск среднего значения чисел
    //Задача: Напишите программу, которая принимает список чисел и находит их среднее значение, используя Stream API.
    List<Integer> listInt2 = new ArrayList<>(List.of(1, 2, 3, 4));
    Double averageInt = listInt2.stream().collect(Collectors.averagingInt(n -> n));
    System.out.println(averageInt);
  }
}
