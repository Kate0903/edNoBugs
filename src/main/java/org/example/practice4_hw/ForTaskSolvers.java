package org.example.practice4_hw;

import java.util.Scanner;

public class ForTaskSolvers {
  public static void main(String[] args) {
    //проверка чисел от 1 до 100, делящихся на 3
    //divideThree();
    // проверка метода сумма чисел от 1 до n
    //System.out.println("Результат сложения чисел: " + sum());

    //проверка метода табл. умножения для числа
    //multiply();

    //проверка метода определения простого числа
    System.out.println(simpleNumber());

    //проверка метода вывода чисел от 1 до 10
    //printNumbers();

  }
  public static void divideThree(){
    for (int i = 1; i <= 100; i++){
      if (i % 3 == 0){
        System.out.println(i);
      }
    }
  }

  public static int sum(){
    Scanner scanner = new Scanner(System.in);
    int sum = 0;
    System.out.println("Укажите число (от 1) для вычисления суммы: ");
    int number = scanner.nextInt();
    for (int i=1; i <= number; i++){
      sum = sum+i;
    }
    return sum;
  }

  public static void multiply(){
    Scanner scanner = new Scanner(System.in);
    int result;
    System.out.println("Введите число: ");
    int number = scanner.nextInt();
    for (int i=1; i <= 10; i++){
      result = number * i;
      System.out.println(number + " x " + i + " = " + result);
    }
  }

  public static boolean simpleNumber(){
    Scanner scanner = new Scanner(System.in);
    boolean isPrime = true;
    System.out.println("Введите число: ");
    int number = scanner.nextInt();
    if(number < 2){
      isPrime = false;
    }
    for (int i=2; i < number; i++) {
      if(number % i == 0){
        isPrime = false;
        break;
      }

    }
    return isPrime;
  }
  public static void printNumbers(){
    for (int i=1; i <=10; i++){
      System.out.println(i);
    }
  }



}
