package org.example.practice5_hw.task5;

public class Farm {
  private Pet pet;

  public void addPet(Pet pet) {
    this.pet = pet;
    System.out.println("Домашнее животное было добавлено " + this.pet);
  }

  public void servicePet() {
    System.out.println("Получение информации по обслуживанию домашнего животного " + this.pet + ":");
    pet.feed();
    pet.care();
    pet.produce();
  }

  public void removePet() {
    System.out.println("Домашнее животное удаляется " + this.pet);
    this.pet = null;
  }
}
