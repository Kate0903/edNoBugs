package org.example.practice7_hw.hashset;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    //Задача 1:
    //Создайте HashSet из 5 чисел и выведите его содержимое.

    Set<Integer> hashSetInt = new HashSet<>();
    hashSetInt.add(4);
    hashSetInt.add(5);
    hashSetInt.add(5);
    hashSetInt.add(4);
    hashSetInt.add(10);
    //System.out.println(hashSetInt);

    //Задача 2:
    //Добавьте в HashSet 10 чисел. Проверьте, содержит ли он заданное число.

    Set<Integer> hashSetInt2 = new HashSet<>(Arrays.asList(2, 3, 3, 4, 5, 22, 55, 65, 21, 34));
    //System.out.println(hashSetInt2);
    //System.out.println(hashSetInt2.contains(3));

    //Задача 3:
    //Реализуйте метод, который принимает List<String> и возвращает Set<String> без дубликатов.
    Set<String> hashSetInt3 = new HashSet<>();
    List<String> arrayList = new ArrayList<>(Arrays.asList("go", "move", "verify",
            "jump", "step", "stop", "remove", "go"));

    hashSetInt3.addAll(arrayList);
    System.out.println(hashSetInt3);
    System.out.println(arrayList);


  }


}
