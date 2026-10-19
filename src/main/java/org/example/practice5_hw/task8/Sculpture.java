package org.example.practice5_hw.task8;

public class Sculpture extends Exhibit {
  @Override
  void description() {
    System.out.print("скульптурный объект, ");
  }

  @Override
  void preserve() {
    System.out.println("реставрация.");
  }
}
