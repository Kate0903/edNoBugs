package org.example.practice5_hw.task7;

public class Roundabout extends Attraction {
  @Override
  void maintain() {
    System.out.print(" техническое обслуживание,");
  }

  @Override
  void description() {
    System.out.println(" спокойный аттракцион.");
  }
}
