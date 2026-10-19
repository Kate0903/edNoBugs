package org.example.practice4_hw;

import java.util.ArrayList;
import java.util.Scanner;

public class BreakContinueTaskSolver {
  public static void main(String[] args) {
    //проверка метода суммы чисел до первого отрицательного
    //System.out.println(sumNumbers());

    //проверка метода пропуска чисел, которые делятся на 3
    //gapsNumber();

    // проверка метода вывода положительных чисел
    System.out.println(printPositiveNumbers());

    //проверка метода ввода строк до команды stop
    //System.out.println(inputStrings());


  }

  public static int sumNumbers(){
    Scanner scanner = new Scanner(System.in);
    int sum = 0;
    while (true){
      System.out.println("Введите число: ");
      int number = scanner.nextInt();
      if (number < 0){
        System.out.println("Программа завершена.");
        break;
      }
      sum = sum + number;
    }
    return sum;
    }

    public static void gapsNumber(){
    for (int i = 1; i <= 20; i++){
      if(i % 3 == 0){
        continue;
      }
      System.out.println(i);
    }
    }

    public static ArrayList<Integer> printPositiveNumbers(){
      Scanner scanner = new Scanner(System.in);
      ArrayList<Integer> arrayNumbers = new ArrayList<>();
      while (true){
        System.out.println("Введите число: ");
        int number = scanner.nextInt();
        if(number < 0){
          continue;
        }
        if (number == 0){
          break;
        }
        arrayNumbers.add(number);
      }
      return arrayNumbers;
    }

    public static ArrayList<String> inputStrings() {
      Scanner scanner = new Scanner(System.in);
      ArrayList<String> arrayComands = new ArrayList<>();
      while (true) {
        System.out.println("Введите команду: ");
        String stringUser = scanner.nextLine();
        if (stringUser.equals("stop")) {
          System.out.println("Программа завершена.");
          break;
        }
        arrayComands.add(stringUser);
      }
      return arrayComands;
    }



  }

