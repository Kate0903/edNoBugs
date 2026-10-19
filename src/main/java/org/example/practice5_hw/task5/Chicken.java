package org.example.practice5_hw.task5;

public class Chicken extends Pet {

  @Override
  void feed() {
    System.out.println("ест зерно");
  }

  @Override
  void care() {
    System.out.println("требует кормушку");
  }

  @Override
  void produce() {
    System.out.println("несет яйца");
  }
}
