package org.example.practice8_hw.generics.class_task1;

public class Main {
  public static void main(String[] args) {
    Box<String> box1 = new Box<>();
    box1.setElement("Телефон");
    System.out.println(box1.getElement());

    Box<Integer> box2 = new Box<>();
    box2.setElement(5);
    System.out.println(box2.getElement());
  }
}
