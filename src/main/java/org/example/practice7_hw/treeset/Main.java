package org.example.practice7_hw.treeset;

import java.util.Set;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    //Задача 1:
    //Создайте LinkedHashSet и добавьте в него 5 строк. Проверьте порядок элементов при выводе.
    Set<Integer> treeSet = new TreeSet<>();
    treeSet.add(10);
    treeSet.add(5);
    treeSet.add(30);
    treeSet.add(20);
    treeSet.add(15);
    System.out.println(treeSet);
  }
}
