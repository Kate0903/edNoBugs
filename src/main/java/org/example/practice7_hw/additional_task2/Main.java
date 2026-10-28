package org.example.practice7_hw.additional_task2;

import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    //1. Хранение уникальных идентификаторов пользователей
    //Задача: Проверить, есть ли пользователь с заданным ID.
    TaskQueue tasks = new TaskQueue(new LinkedList());
    tasks.addElement("Задача 3");
    tasks.addElement("Задача 2");
    tasks.addElement("Задача 1");
    tasks.print();
    tasks.processing();
  }
}
