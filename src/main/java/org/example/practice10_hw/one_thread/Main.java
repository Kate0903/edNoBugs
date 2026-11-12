package org.example.practice10_hw.one_thread;

public class Main {
  static void main() {
    OneThread oneThread = new OneThread();
    Thread t1 = new Thread(oneThread);
    t1.start();
  }
}
