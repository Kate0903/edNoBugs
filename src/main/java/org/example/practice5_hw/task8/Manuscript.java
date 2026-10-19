package org.example.practice5_hw.task8;

public class Manuscript extends Exhibit {
  @Override
  void description() {
    System.out.print("древний, ");
  }

  @Override
  void preserve() {
    System.out.println("контролируемая влажность.");
  }
}
