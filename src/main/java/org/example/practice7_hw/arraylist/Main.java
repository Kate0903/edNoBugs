package org.example.practice7_hw.arraylist;


import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    //Задача 1:
    //Создайте ArrayList из 5 чисел. Добавьте ещё одно число в конец. Выведите весь список.
    List<Integer> arrayInt = new ArrayList<>(List.of(1,2,3,4,5));
    arrayInt.add(2);
    //System.out.println(arrayInt);

    //Задача 2:
    //Напишите программу, которая выводит все чётные числа из ArrayList.
    List<Integer> arrayBefore = new ArrayList<>(List.of(1,2,3,4,5,8,44,7,77,77,22,87,100,2000,9));
    List<Integer> arrayEven = new ArrayList<>();
    for (int i= 0; i < arrayBefore.size(); i++) {
      if (arrayBefore.get(i) % 2 == 0) {
        arrayEven.add(arrayBefore.get(i));
      }
    }
    System.out.println(arrayEven);

      //Задача 2 (через forEach):
      //Напишите программу, которая выводит все чётные числа из ArrayList.
      List<Integer> arrayBefore1 = new ArrayList<>(List.of(1,2,3,4,5,8,44,7,77,77,22,87,100,2000,9));
      List<Integer> arrayEven2 = new ArrayList<>();
      arrayBefore1.forEach( e ->{
        if(e % 2 == 0){
          arrayEven2.add(e);
        }
      }
      );
      System.out.println(arrayEven2);









  }
}
