package org.example.practice5_hw.task5;

public class Cow extends Pet {
  @Override
  void feed() {
    System.out.println("ест траву");
  }

  @Override
  void care() {
    System.out.println("требует выпас");
  }

  @Override
  void produce() {
    System.out.println("дает молоко");
  }
}
