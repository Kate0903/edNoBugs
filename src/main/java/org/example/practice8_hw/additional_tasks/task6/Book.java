package org.example.practice8_hw.additional_tasks.task6;

public class Book<T> implements Container<T> {
  private T name;


  @Override
  public void add(T item) {
    this.name = item;
  }

  @Override
  public T get() {
    return this.name;
  }
}
