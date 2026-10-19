package org.example.practice4_hw;

import java.util.Scanner;

public class WhileTaskSolvers {
  public static void main(String[] args) {
  // проверка метода вычисление факториала
    //System.out.println(factorial());

    // проверка метода вывода всех четных чисел до заданного
    //evenNumbers();

    //проверка метода обратного отсчета
    countDown();
  }

  public static int factorial(){
    int result = 1;
    int i = 1;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите число для определения факториала: ");
    int number = scanner.nextInt();
    while (i <= number){
      result = result * i;
      i++;
    }
    return result;
  }

  public static void evenNumbers(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите число (от 1): ");
    int i = 1;
    int number = scanner.nextInt();
    while (i <= number){
      if (i % 2 == 0){
        System.out.println(i);
      }
      i++;
      }
    }

public static void countDown(){
  Scanner scanner = new Scanner(System.in);
  System.out.println("Введите число (от 1): ");
  int number = scanner.nextInt();
  while (number >= 1){
    System.out.println(number);
    number--;
  }
}


}



