package org.example.practice5_hw.task8;

public class Museum {
  private Exhibit exhibit;

  public void addExhibit(Exhibit exhibit) {
    this.exhibit = exhibit;
    System.out.println("Был добавлен экспонат " + this.exhibit.toString() + ".");
  }

  public void showInfoExhibit() {
    System.out.print("Информация для экспоната " + this.exhibit.toString() + ": ");
    exhibit.description();
    exhibit.preserve();
  }

  public void removeExhibit() {
    System.out.println("Удаляется экспонат: " + this.exhibit.toString());
    this.exhibit = null;
  }

}
