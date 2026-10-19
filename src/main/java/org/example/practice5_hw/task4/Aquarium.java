package org.example.practice5_hw.task4;

public class Aquarium {
  private SeaEntity seaEntity;

  public void addSeaEntity(SeaEntity seaEntity) {
    this.seaEntity = seaEntity;
    System.out.println("Морская сущность " + this.seaEntity.toString() + " добавлена. ");
  }

  public void demonstrateMove() {
    System.out.print("Морская сущность " + this.seaEntity.toString());
    seaEntity.move();
  }

  public void removeSeaEntity() {
    System.out.println("Удаление морской сущности " + this.seaEntity.toString());
    this.seaEntity = null;
  }

  ;


}
