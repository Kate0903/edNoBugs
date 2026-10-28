package org.example.practice7_hw.linkedhashset;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    //Задача 1:
    //Создайте HashSet из 5 чисел и выведите его содержимое.
    Set<String> linkedHashSet = new LinkedHashSet<>();
    linkedHashSet.add("I");
    linkedHashSet.add("am");
    linkedHashSet.add("doing");
    linkedHashSet.add("my");
    linkedHashSet.add("homework.");
    System.out.println(linkedHashSet);

  }
}
