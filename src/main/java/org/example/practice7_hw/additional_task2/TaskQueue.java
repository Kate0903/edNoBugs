package org.example.practice7_hw.additional_task2;

import java.util.LinkedList;

public class TaskQueue {
  private LinkedList<String> tasks;

  public TaskQueue(LinkedList<String> tasks) {
    this.tasks = tasks;
  }

  public void addElement(String element) {
    tasks.add(element);
  }

  public void processing() {
    while (!tasks.isEmpty()) {
      System.out.println(tasks.poll());
    }
  }

  public void print() {
    System.out.println(tasks);
  }
}
