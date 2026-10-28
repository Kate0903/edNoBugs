package org.example.practice7_hw.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    //Задача 1:
    //Создайте LinkedHashMap и добавьте в него 5 элементов. Выведите их в порядке добавления.
    Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put("Сидоров М.И.", 765467);
    linkedHashMap.put("Федорова Р.С.", 765000);
    linkedHashMap.put("Трипольский Д.И.", 365677);
    linkedHashMap.put("Спиридонова Л.Г.", 744469);
    linkedHashMap.put("Сидоров М.И.", 55555);
    System.out.println(linkedHashMap);

  }
}
