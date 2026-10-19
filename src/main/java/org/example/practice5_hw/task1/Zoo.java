package org.example.practice5_hw.task1;

public class Zoo {
  private Animal animal;

  public Zoo(Animal animal) {
    this.animal = animal;
  }

  public void addAnimal(Animal animal) {
    this.animal = animal;
    System.out.println("Добавляем животное в зоопарк. " + this.animal.toString());
  }

  public void forceMakeSound() {
    System.out.println("Заставляем животное издавать звук. " + this.animal);
    animal.makeSound();
  }

  public void forceMakeMove() {
    System.out.println("Заставляем животное двигаться. " + this.animal);
    animal.makeMove();
  }

  public void removeAnimal() {
    System.out.println("Удаляем животное из зоопарка. " + this.animal);
    this.animal = null;
  }

}
