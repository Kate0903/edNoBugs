package org.example.practice4_hw;

import java.util.Scanner;

public class IfElseTaskSolvers {
  public static void main(String[] args) {
  //проверка метода по определению знака числа
    //System.out.println(checkSignOfNumber());

  //проверка метода по определению максимального числа из двух
    //System.out.println("Максимальное число: " + maxNumber());

  //проверка метода по выводу оценки
    //System.out.println(descriptionOfEstimate());

  //проверка метода определения четности числа
    //System.out.println(checkParity());

    //проверка метода определения скидки по возрасту
    System.out.println("Размер скидки для указанного вами возраста: " + checkDiscount() +"%");

    //проверка метода оценки результат теста по баллам
    //System.out.println(checkEstimateTest());
  }



  public static String checkSignOfNumber(){
    Scanner scanner = new Scanner(System.in);
    int number;
    String descriptionNumber;
    System.out.println("Введите число: ");
    number = scanner.nextInt();
    if(number>0){
      descriptionNumber = "Число положительное.";
    }
    else if (number<0){
      descriptionNumber = "Число отрицательное.";
    } else {
      descriptionNumber = "Число равно нулю.";
    }
    return descriptionNumber;
  }

  public static int maxNumber(){
    Scanner scanner = new Scanner(System.in);
    int number1;
    int number2;
    int max;
    System.out.println("Введите первое число: ");
    number1 = scanner.nextInt();
    System.out.println("Введите второе число: ");
    number2 = scanner.nextInt();
    max = number1;
    if (number1<number2){
      max = number2;
    }
    return max;
  }

  public static String descriptionOfEstimate(){
    Scanner scanner = new Scanner(System.in);
    int estimate;
    String descriptionEstimate;
    System.out.println("Укажите оценку от 1 до 5(включительно): ");
    estimate = scanner.nextInt();
    if(estimate == 5){
      descriptionEstimate = "Отлично";
    } else if(estimate == 4){
      descriptionEstimate = "Хорошо";
    } else if (estimate == 3){
      descriptionEstimate = "Удовлетворительно";
    } else if(estimate == 2 || estimate == 1){
      descriptionEstimate = "Неудовлетворительно";
    } else {
      descriptionEstimate = "Указанная вами оценка не существует.";
    }
    return descriptionEstimate;
  }

  public static String checkParity(){
    Scanner scanner = new Scanner(System.in);
    String parity;
    System.out.println("Введите число: ");
    int number = scanner.nextInt();
    parity = (number % 2 == 0) ? "Число четное" : "Число нечетное";
    return parity;
  }

  public static int checkDiscount(){
    Scanner scanner = new Scanner(System.in);
    int discount;
    int age;
    System.out.println("Введите возраст для определения скидки: ");
    age = scanner.nextInt();
    if(age < 1){
      System.out.println("Возраст указан неверно.");
    }
    if(age >= 1 && age < 18){
      discount = 25;
    } else if(age >= 65){
      discount = 30;
    } else {
      discount = 0;
    }
    return discount;
  }

  public static String checkEstimateTest(){
    Scanner scanner = new Scanner(System.in);
    int score;
    String descriptionScore;
    System.out.println("Введите результат теста в баллах: ");
    score = scanner.nextInt();
    if(score >= 90){
      descriptionScore = "Отлично";
    } else if(score >= 75 && score <= 89){
      descriptionScore = "Хорошо";
    } else if (score >= 60 && score <= 74){
      descriptionScore = "Удовлетворительно";
    } else {
      descriptionScore = "Неудовлетворительно";
    }
    return descriptionScore;

  }

}
