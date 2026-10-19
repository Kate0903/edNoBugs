package org.example.practice5_hw.task2;

public class Dog extends Pet {

  @Override
  void interact() {
    System.out.println("погуляли");
  }

  @Override
  void feed() {
    System.out.println("сухим кормом");
  }
}
