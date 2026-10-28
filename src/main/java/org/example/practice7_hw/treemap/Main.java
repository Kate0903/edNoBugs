package org.example.practice7_hw.treemap;

import java.util.Map;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    //Задача 1:
    //Создайте TreeMap и добавьте 5 ключей (имена) и значений (баллы). Выведите отсортированные данные.
    Map<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("Коля", 60);
    treeMap.put("Вася", 76);
    treeMap.put("Лиля", 80);
    treeMap.put("Зарина", 55);
    treeMap.put("Лиля", 95);
    System.out.println(treeMap);


  }


}
