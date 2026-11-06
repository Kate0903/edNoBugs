package org.example.practice9_hw.stream_basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  static void main() {
    //1. Фильтрация строк по длине больше 5
    //Задача: Напишите программу,
    // которая принимает список строк и удаляет из него все строки длиной 5 символов и менее,
    // используя Stream API.
    List<String> listBeforeFilter1 = new ArrayList<>(List.of("function", "stream", "lambda", "loop", "exception", "fail"));
    List<String> listAfterFilter1 = listBeforeFilter1.stream()
            .filter(str -> str.length() > 5)
            .collect(Collectors.toList());

    System.out.println(listAfterFilter1);


    //2. Фильтрация чисел, кратных 5
    //Задача: Напишите программу, которая принимает список чисел и отбирает только те,
    // которые делятся на 5 без остатка, используя Stream API.
    List<Integer> listBeforeFilter2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    List<Integer> listAfterFilter2 = listBeforeFilter2.stream()
            .filter(el -> el % 5 == 0)
            .collect(Collectors.toList());

    System.out.println(listAfterFilter2);


    //3. Преобразование строк в их длины
    //Задача: Напишите программу, которая принимает список строк и заменяет
    // каждую строку на её длину, используя Stream API.
    List<String> listBeforeFilter3 = new ArrayList<>(List.of("function", "stream", "lambda", "loop", "exception", "fail"));
    List<Integer> listAfterFilter3 = listBeforeFilter3.stream()
            .map(String::length)
            .collect(Collectors.toList());

    System.out.println(listAfterFilter3);


// 4. Создание списка квадратов чисел
//Задача: Напишите программу, которая принимает список чисел и преобразует его в новый список,
// где каждое число заменено на его квадрат, используя Stream API.
    List<Integer> listBeforeFilter4 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    List<Integer> listAfterFilter4 = listBeforeFilter4.stream()
            .map(el -> el * el)
            .collect(Collectors.toList());

    System.out.println(listAfterFilter4);


    //5. Удаление дубликатов из списка
    //Задача: Напишите программу, которая принимает список элементов и
    // удаляет из него все дубликаты, используя Stream API.
    List<Integer> listBeforeFilter5 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 1, 3, 4));
    List<Integer> listAfterFilter5 = listBeforeFilter5.stream()
            .distinct()
            .toList();

    System.out.println(listAfterFilter5);


  }
}