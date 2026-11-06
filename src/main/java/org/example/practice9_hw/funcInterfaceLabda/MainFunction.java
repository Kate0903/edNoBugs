package org.example.practice9_hw.funcInterfaceLabda;

import java.util.function.Function;

public class MainFunction {
  //4. Лямбда-выражение с Function
  //Задача: Создайте лямбду, которая принимает строку и возвращает её длину.
  static void main() {
    Function<String, Integer> calcLength = String::length;
    System.out.println(calcLength.apply("Лямбда"));
    System.out.println(calcLength.apply("Интерфейс"));
  }


}
