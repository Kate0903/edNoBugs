package org.example.practice10_hw.two_threads;

public class Main {
  static void main() {


    TwoThreads twoThreads = new TwoThreads();
    Thread t1 = new Thread(() -> {
      try {
        twoThreads.printA();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    });

    Thread t2 = new Thread(() -> {
      try {
        twoThreads.printB();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    });

    t1.start();
    t2.start();
  }
}
