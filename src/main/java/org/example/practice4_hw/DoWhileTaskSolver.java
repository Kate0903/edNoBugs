package org.example.practice4_hw;

import java.util.Scanner;

public class DoWhileTaskSolver {
  public static void main(String[] args) {
    //проверка метода по запросу положительного числа
     //positiveNumber();

    //проверка метода по проверке пароля
    //checkPassword();

    // проверка метода вывода чисел от 1 до 10
    //printNumbers();

    //проверка метода завершения программы по команде exit
    //exitProgram();

    System.out.println(countNumbers());



  }

  public static void positiveNumber(){
    Scanner scanner = new Scanner(System.in);
    int number;
    do{
      System.out.println("Введите число: ");
      number = scanner.nextInt();
    } while (number <= 0);
    System.out.println("Программа завершена, т.к. вы указали положительное число");
  }

  public static void checkPassword(){
    Scanner scanner = new Scanner(System.in);
    String password;
    String passwordTrue = "test";
    do {
      System.out.println("Введите пароль: ");
      password = scanner.nextLine();
    } while (!password.equals(passwordTrue));
    System.out.println("Пароль указан верно.");
  }

  public static void printNumbers(){
    int i = 1;
    do {
      System.out.println(i);
      i++;
    } while (i <= 10);
  }

  public static void exitProgram(){
    Scanner scanner = new Scanner(System.in);
    String commandUser;
    String commandExit = "exit";
    do {
      System.out.println("Введите команду: ");
      commandUser = scanner.nextLine();
    } while (!commandUser.equals(commandExit));
    System.out.println("Программа заверщена, т.к. вы указали команду exit.");
  }

  public static int countNumbers(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите число: ");
    int number = scanner.nextInt();
    int count = 0;
    if (number == 0){
      count = 1;
    } else {
    do{
      number = number/10;
      count++;
    } while (number > 0);}
    return count;
  }


}
