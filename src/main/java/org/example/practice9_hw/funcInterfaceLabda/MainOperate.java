package org.example.practice9_hw.funcInterfaceLabda;

public class MainOperate {
  //1. Создайте свой функциональный интерфейс
  //Задача: Напишите интерфейс MathOperation, который принимает два числа и возвращает результат операции.
  // Реализуйте его с помощью лямбда-выражений: сложение, вычитание, умножение, деление.
  static void main() {
    MathOperation add = (a, b) -> a + b;
    MathOperation substruct = (a, b) -> a - b;
    MathOperation multiplication = (a, b) -> a * b;
    MathOperation divide = (a, b) -> a / b;

    System.out.println("Сложение: " + add.operate(2.5, 5));
    System.out.println("Вычетание: " + substruct.operate(5, 2.3));
    System.out.println("Умножение: " + multiplication.operate(3, 3));
    System.out.println("Деление: " + divide.operate(3, 2));
  }


}
