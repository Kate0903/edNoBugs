package org.example.practice5_hw.task7;

public class RollerCoaster extends Attraction {
  @Override
  void maintain() {
    System.out.print(" проверка безопасности,");
  }

  @Override
  void description() {
    System.out.println(" острые ощущения.");
  }
}
