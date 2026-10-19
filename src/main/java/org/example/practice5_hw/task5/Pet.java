package org.example.practice5_hw.task5;

public abstract class Pet {
  abstract void feed();

  abstract void care();

  abstract void produce();

  public String toString() {
    return getClass().getSimpleName();
  }

}
