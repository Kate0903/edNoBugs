package org.example.practice8_hw.additional_tasks.task7;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
  static void main() {
    Map<String, Integer> contactsBook = new HashMap<>();
    contactsBook.put("Иванов С.И.", 234235);
    contactsBook.put("Грибкова Л.С.", 4567);
    contactsBook.put("Самарин С.Т.", 35354);
    contactsBook.put("Трегубова Д.Н.", 43225);
    printMap(contactsBook);

  }

  public static <K, V> void printMap(Map<K, V> map) {
    map.entrySet().forEach(System.out::println);
  }
}
