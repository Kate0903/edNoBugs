package org.example.practice10_hw.two_threads;

public class TwoThreads {
  public void printA() throws InterruptedException {
    for (int i = 0; i < 5; i++) {
      System.out.println("A");
      Thread.sleep(1000);
    }
  }

  public void printB() throws InterruptedException {
    for (int i = 0; i < 5; i++) {
      System.out.println("B");
      Thread.sleep(1000);
    }
  }

}
