package org.example.practice5_hw.task1;

public class Bird extends Animal {
  @Override
  void makeSound() {
    System.out.println("чик-чирик");
  }

  @Override
  void makeMove() {
    System.out.println("летает");
  }
}
