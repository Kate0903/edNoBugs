package org.example.practice10_hw.volatilekeyword;

public class Main {
  static void main() throws InterruptedException {
    VolitileField volitileField = new VolitileField();
    Thread t = new Thread(volitileField);
    t.start();
    Thread.sleep(2000);
    volitileField.stop();
    t.join();
    System.out.println("Значение в счетчике: " + volitileField.getCount());
  }
}
