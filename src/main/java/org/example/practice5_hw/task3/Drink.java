package org.example.practice5_hw.task3;

public class Drink extends Dish {
  private int value;

  public Drink(int value) {
    this.value = value;
  }

  @Override
  void showCharacteristics() {
    System.out.println(" объем напитка " + this.value);
  }
}
