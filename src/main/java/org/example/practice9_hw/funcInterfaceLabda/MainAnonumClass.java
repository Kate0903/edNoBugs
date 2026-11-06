package org.example.practice9_hw.funcInterfaceLabda;

public class MainAnonumClass {
  //2. Использование анонимного класса
  //Задача: Создайте анонимный класс, реализующий интерфейс Runnable, который выводит сообщение
  // "Hello from anonymous class!".
  static void main() {
    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello from anonymous class!");
      }
    };
    r1.run();
  }
}
