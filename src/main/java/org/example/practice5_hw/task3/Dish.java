package org.example.practice5_hw.task3;

public abstract class Dish {
  abstract void showCharacteristics();

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

}
