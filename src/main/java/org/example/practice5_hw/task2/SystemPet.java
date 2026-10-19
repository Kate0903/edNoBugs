package org.example.practice5_hw.task2;

public class SystemPet {
  private Pet pet;

  public void addPet(Pet pet) {
    this.pet = pet;
    System.out.println("Домашнее животное было добавлено в систему " + this.pet.toString());
  }

  void forceFeed() {
    System.out.println("Домашнее животное покормили: " + this.pet.toString());
    pet.feed();

  }

  void forceInteract() {
    System.out.println("С домашним животным провзаимодействовали: " + this.pet.toString());
    pet.interact();

  }

  void removePet() {
    this.pet = null;
    System.out.println("Домашнее животное удалили из системы " + this.pet);
  }


}
