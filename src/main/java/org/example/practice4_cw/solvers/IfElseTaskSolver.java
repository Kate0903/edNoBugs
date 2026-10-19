package org.example.practice4_cw.solvers;

public class IfElseTaskSolver {
  public static void main(String[] args) {

    //проверка метода четности
    System.out.println(checkParity(4));
    System.out.println(checkParity(7));

    //проверка метода определения возраста
    System.out.println(checkAge(4));
    System.out.println(checkAge(21));
    System.out.println(checkAge(71));

    // проверка метода по нахождению max среди 3 чисел
    System.out.println(checkMax(3,7,5));
  }

  public static String checkParity(int number){
    String parity = "Нечетное";

    if(number % 2 == 0){
      parity = "Четное";
    }
    return parity;
  }

  public static String checkAge(int age){
    String ageDescription = "";
    if (age < 18){
      ageDescription = "Несовершеннолетний";
    }
    if (age >= 18 && age <= 60){
      ageDescription = "Взрослый";
    }
    if(age > 60){
      ageDescription = "Пожилой";
    }
    return ageDescription;
  }

  public static int checkMax(int a, int b, int c){
    int maxAB = b;
    if (a > b){
      maxAB = a;
    }
    int max = maxAB;
    if(c > maxAB){
      max = c;
    }
    return max;
  }
}
