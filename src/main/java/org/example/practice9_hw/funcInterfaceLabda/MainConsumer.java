package org.example.practice9_hw.funcInterfaceLabda;

import java.util.function.Consumer;

public class MainConsumer {
  // 5. Использование Consumer
  //Задача: Напишите лямбду, которая принимает строку и печатает её в консоль.
  static void main() {
    Consumer<String> printString = System.out::println;
    printString.accept("Привет!");
  }

}
