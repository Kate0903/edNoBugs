package org.example.practice7_hw.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    //Задача 1:
    //Создайте PriorityQueue и добавьте 5 чисел. Выведите их в порядке удаления.
    Queue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.offer(30);
    priorityQueue.offer(5);
    priorityQueue.offer(10);
    priorityQueue.offer(15);
    priorityQueue.offer(20);
    while(!priorityQueue.isEmpty()){
      System.out.println(priorityQueue.poll());
    }
    System.out.println("Элементы в очереди отсутствуют.");
  }
}
