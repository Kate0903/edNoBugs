package org.example.practice10_hw.volatilekeyword;

public class VolitileField implements Runnable {
  private volatile boolean stop = false;
  private long count = 0;

  @Override
  public void run() {
    while (!stop) {
      count++;
    }
  }

  public void stop() {
    this.stop = true;
  }

  public long getCount() {
    return count;
  }
}
