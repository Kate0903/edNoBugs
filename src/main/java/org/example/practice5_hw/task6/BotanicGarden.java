package org.example.practice5_hw.task6;

public class BotanicGarden {
  private HomePlant homePlant;

  public void addHomePlant(HomePlant homePlant) {
    this.homePlant = homePlant;
    System.out.println("Домашнее растение было добавлено " + this.homePlant);
  }

  public void maintainHomePlant() {
    System.out.print("Уход за домашним растением: " + this.homePlant);
    homePlant.care();

  }

  public void removeHomePlant() {
    this.homePlant = null;
  }


}
