package org.example.practice9_cw.lambda;

public class Main {
  static void main() {
    //анонимный класс
    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Привет, мир!");
      }
    };
    r1.run();

    Runnable r2 = () -> System.out.println("Привет, мир!");
    r2.run();
  }


}
