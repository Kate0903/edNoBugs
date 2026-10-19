package org.example.practice5_hw.task1;

public abstract class Animal {

  abstract void makeSound();

  abstract void makeMove();

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

}


