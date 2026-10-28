package org.example.practice7_hw.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
  public static void main(String[] args) {
    //Задача 1:
    //Создайте LinkedList и добавьте в него 5 строк. Выведите все элементы списка.
    List<String> listString = new LinkedList<>();
    listString.add("go");
    listString.add("run");
    listString.add("move");
    listString.add("jump");
    listString.add("stop");
    //System.out.println(listString);


    //Задача 2:
    //Реализуйте очередь задач с LinkedList. Добавьте 3 задачи и обработайте их в порядке поступления.
    Queue<String> tasks = new LinkedList<>();
    tasks.add("Задача 1");
    tasks.add("Задача 2");
    tasks.add("Задача 3");
    while (!tasks.isEmpty()) {
      String currentTask = tasks.poll();
      //System.out.println("Задача в обработке: " + currentTask);

    }
    //System.out.println("Все задачи были обработаны.");

    //Задача 4:
    //Создайте LinkedList из целых чисел. Напишите программу, которая вычисляет сумму элементов списка.
    Queue<Integer> sumNumbers = new LinkedList<>();
    AtomicReference<Integer> sum = new AtomicReference<>(0);
    sumNumbers.add(1);
    sumNumbers.add(1);
    sumNumbers.add(4);
    sumNumbers.add(1);
    sumNumbers.add(7);
    sumNumbers.add(1);
    sumNumbers.forEach(e -> sum.set(sum.get() + e));
    System.out.println(sum);

    //Задача 5:
    //Используйте ListIterator для прохода по LinkedList в обоих направлениях.
    LinkedList<Integer> list = new LinkedList<>();
    list.add(3);
    list.add(4);
    list.add(6);
    list.add(7);
    list.add(3);
    ListIterator<Integer> it = list.listIterator();
    System.out.println("Проход с начала:");
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    System.out.println("Проход с конца:");
    while (it.hasPrevious()) {
      System.out.println(it.previous());
    }

  }


}
