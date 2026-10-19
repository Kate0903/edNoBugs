package org.example.practice5_hw.task2;

abstract public class Pet {
  abstract void interact();

  abstract void feed();

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

}
