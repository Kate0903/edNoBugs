package org.example.practice8_hw.generics.twotypes_class_task3;

public class Main {
  public static void main(String[] args) {
    Pair<Integer, String> pair = new Pair<>();
    pair.setElement1(55);
    pair.setElement2("Test");
    System.out.println(pair.getElement1() + " " + pair.getElement2());
  }
}
