package org.example.practice5_hw.task7;

public abstract class Attraction {
  abstract void maintain();

  abstract void description();

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
