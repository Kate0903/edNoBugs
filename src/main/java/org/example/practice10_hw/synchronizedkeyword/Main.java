package org.example.practice10_hw.synchronizedkeyword;

public class Main {
  static void main() throws InterruptedException {
    Counter counter = new Counter();
    Thread t1 = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        counter.increment();
      }
    });

    Thread t2 = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        counter.increment();
      }
    });
    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println("Значение count: " + counter.getCount());


  }
}
