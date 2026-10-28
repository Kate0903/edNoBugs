package org.example.practice7_hw.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    //Задача 1:
    //Создайте HashMap<String, Integer>, добавьте 5 пар (имя – возраст) и выведите все записи.

    Map<String, Integer> hashMap = new HashMap<>();
    hashMap.put("Мария", 30);
    hashMap.put("Мария", 34);
    hashMap.put("Иван", 20);
    hashMap.put("Рита", 19);
    hashMap.put("Алина", 44);
    //System.out.println(hashMap);


    //Задача 2:
    //Проверьте, есть ли определённое имя в HashMap.
    Map<String, Integer> hashMap2 = new HashMap<>();
    hashMap2.put("Рита", 30);
    hashMap2.put("Ксения", 34);
    hashMap2.put("Алексей", 20);
    hashMap2.put("Рита", 19);
    hashMap2.put("Алина", 44);
    System.out.println(hashMap2);
    System.out.println(hashMap2.containsKey("Рита"));
  }

}