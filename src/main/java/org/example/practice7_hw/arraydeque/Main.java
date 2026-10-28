package org.example.practice7_hw.arraydeque;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    //Задача 1:
    //Создайте ArrayDeque, добавьте 5 элементов и выведите их.
    Queue<String> arrayDeque = new ArrayDeque<>();
    arrayDeque.offer("Элемент 2");
    arrayDeque.offer("Элемент 1");
    arrayDeque.offer("Элемент 3");
    arrayDeque.offer("Элемент 4");
    arrayDeque.offer("Элемент 5");

    System.out.println(arrayDeque);
  }
}
