package org.example.practice10_hw.accounts_transfer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
  private double ballance;
  private final Lock lock = new ReentrantLock();
  private String name;

  public Account(String name, double ballance) {
    this.ballance = ballance;
    this.name = name;
  }

  public double getBallance() {
    return ballance;
  }

  public String getName() {
    return name;
  }

  public Lock getLock() {
    return lock;
  }

  public void deposit(double amount) {
    this.ballance = this.ballance + amount;
  }

  public void withdrawal(double amount) {
    this.ballance = this.ballance - amount;
  }
}
