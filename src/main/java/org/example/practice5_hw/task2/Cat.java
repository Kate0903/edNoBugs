package org.example.practice5_hw.task2;

public class Cat extends Pet {
  @Override
  void interact() {
    System.out.println("поиграли");
  }

  @Override
  void feed() {
    System.out.println("влажным кормом");
  }
}
