package org.example.practice5_hw.task6;

public abstract class HomePlant {
  abstract void care();

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

}
