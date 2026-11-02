package org.example.practice8_hw.generics.class_task1;

public class Box<T> {
  private T element;

  public void setElement(T element) {
    this.element = element;
  }

  public T getElement() {
    return this.element;
  }
}
