package org.example.practice8_hw.generics.twotypes_class_task3;

public class Pair<T, E> {
  private T element1;
  private E element2;


  public void setElement1(T element1) {
    this.element1 = element1;
  }

  public void setElement2(E element2) {
    this.element2 = element2;
  }

  public T getElement1() {
    return element1;
  }

  public E getElement2() {
    return element2;
  }
}
