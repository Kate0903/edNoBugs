package org.example.practice9_hw.funcInterfaceLabda;

import java.util.function.Predicate;

public class MainPredicate {
  //3. Лямбда-выражение с Predicate
  //Задача: Напишите лямбду, которая проверяет, является ли число чётным.
  static void main() {
    Predicate<Integer> evenNumber = (x) -> x % 2 == 0;

    System.out.println(evenNumber.test(6));
    System.out.println(evenNumber.test(9));
  }
}
