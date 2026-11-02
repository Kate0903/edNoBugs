package org.example.practice8_hw.additional_tasks.task6;

public class Book implements Container {
  private Object name;

  @Override
  public void add(Object item) {
    this.name = item;
  }

  @Override
  public Object get() {
    return this.name;
  }
}
