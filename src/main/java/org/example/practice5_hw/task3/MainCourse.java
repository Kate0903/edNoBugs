package org.example.practice5_hw.task3;

public class MainCourse extends Dish {
  private int temperature;

  public MainCourse(int temperature) {
    this.temperature = temperature;
  }

  @Override
  void showCharacteristics() {
    System.out.println(" температура блюда " + this.temperature);
  }
}
