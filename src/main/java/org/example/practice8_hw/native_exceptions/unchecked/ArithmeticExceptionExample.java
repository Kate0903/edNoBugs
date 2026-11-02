package org.example.practice8_hw.native_exceptions.unchecked;

import java.util.Scanner;

public class ArithmeticExceptionExample {
  public static void main(String[] args) {
    System.out.println("Результат деления: " + divide());
  }

  public static double divide() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите число (делимое): ");
    int a = scanner.nextInt();
    System.out.println("Введите число (делитель): ");
    int b = scanner.nextInt();
    if (b == 0) {
      throw new ArithmeticException("Деление на ноль недопустимо.");
    }
    return (double) a / b;
  }
}
