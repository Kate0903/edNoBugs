package org.example.practice4_hw;

import java.util.Scanner;

import static org.example.practice4_hw.Command.*;


public class SwitchTaskSolver {
  public static void main(String[] args) {
    //проверка метода определения дня недели
    //System.out.println(dayOfWeek());

    //проверка определения стоимости билета по дню недели
    //System.out.println("Стоимость билета: " + checkCostTicket());

    //проверка перевода числовых оценок в буквенные
    //System.out.println(numberToLetter());

    //проверка обработки метода тестовых команд
    //System.out.println(descriptionCommands());

    //проверка метода калькулятор
    System.out.println("Результат вычисления: " + calculate());
  }

  public static String dayOfWeek(){
    Scanner scanner= new Scanner(System.in);
    int day;
    String descriptionDay;
    day = scanner.nextInt();
    switch (day) {
      case 1:
        descriptionDay = "Понедельник";
        break;
      case 2:
        descriptionDay = "Вторник";
        break;
      case 3:
        descriptionDay = "Среда";
        break;
      case 4:
        descriptionDay = "Четверг";
        break;
      case 5:
        descriptionDay = "Пятница";
        break;
      case 6:
        descriptionDay = "Суббота";
        break;
      case 7:
        descriptionDay = "Воскресенье";
        break;
      default: descriptionDay = "Значение указано неверно.";
    }
    return descriptionDay;
  }

  public static int checkCostTicket(){
    Scanner scanner= new Scanner(System.in);
    int day;
    int cost;
    System.out.println("Укажите порядковый номер дня недели: ");
    day = scanner.nextInt();
    switch (day) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        cost = 300;
        break;
      case 6:
      case 7:
        cost = 450;
        break;
      default: cost = 450;
        }
    return cost;
    }

  public static String numberToLetter(){
    Scanner scanner= new Scanner(System.in);
    int number;
    String letter;
    System.out.println("Укажите оценку от 0 до 100(включительно) для перевода: ");
    number = scanner.nextInt();
    if(number >= 90 && number <= 100){
      letter = "A";
    } else if (number >= 80 && number <= 89){
      letter = "B";
    } else if (number >= 70 && number <= 79) {
      letter = "C";
    } else if(number >= 60 && number <= 69){
      letter = "D";
    } else if(number < 60 && number >= 0){
      letter = "F";
    } else {
      letter = "Значение оценки должно быть от 1 до 100(включительно)";
    }
    return letter;
  }
  public static String descriptionCommands(){
    Scanner scanner= new Scanner(System.in);
    String description;
    System.out.println("Укажите одну из команд \"start\", \"stop\", \"restart\" или \"status\": ");
    String commandUser = scanner.nextLine();
    switch(Command.valueOf(commandUser.toUpperCase().trim())) {
      case START:
        description = "Система запущена";
        break;
      case STOP:
        description = "Система остановлена";
        break;
      case RESTART:
        description = "Система перезапущена";
        break;

      case STATUS:
        description = "Система работает";
        break;

        default:
          throw new IllegalArgumentException();
    }
    return description;
  }

  public static int calculate(){
    Scanner scanner = new Scanner(System.in);
    int result;
    String operation;
    int a;
    int b;
    System.out.println("Укажите значение первого числа: ");
    a = scanner.nextInt();
    System.out.println("Укажите значение второго числа: ");
    b = scanner.nextInt();
    System.out.println("Укажите один из операторов (+, -, *, /): ");
    scanner.nextLine();
    operation = scanner.nextLine();
    switch(operation){
      case "+":
        result = a + b;
        break;
      case "-":
        result = a - b;
        break;
      case "*":
        result = a * b;
        break;
      case "/":
        if(b == 0){
          throw new IllegalArgumentException();
        }
        result = a / b;
        break;
      default: throw new IllegalArgumentException();
    }
    return result;
  }

  }

