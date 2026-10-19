package org.example.practice5_hw.task7;

public class Park {
  private Attraction attraction;

  public void addAttraction(Attraction attraction) {
    this.attraction = attraction;
    System.out.println("Аттракцион был добавлен " + this.attraction.toString());
  }

  public void manageAttraction() {
    System.out.print("Управление аттракционом и описание аттракциона " + this.attraction.toString() + ": ");
    attraction.maintain();
    attraction.description();
  }

  public void removeAttraction() {
    this.attraction = null;
  }

}
