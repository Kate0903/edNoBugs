package org.example.practice5_hw.task8;

public abstract class Exhibit {
  abstract void description();

  abstract void preserve();

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
