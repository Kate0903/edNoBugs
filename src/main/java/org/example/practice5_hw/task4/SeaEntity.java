package org.example.practice5_hw.task4;

public abstract class SeaEntity {
  abstract void move();

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

}
