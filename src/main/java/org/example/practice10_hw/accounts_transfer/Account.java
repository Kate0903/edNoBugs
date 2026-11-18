package org.example.practice10_hw.accounts_transfer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
  private double balance;
  private final Lock lock = new ReentrantLock();
  private final String name;

  public Account(String name, double ballance) {
    this.balance = ballance;
    this.name = name;
  }

  public double getBalance() {
    return balance;
  }

  public String getName() {
    return name;
  }

  public Lock getLock() {
    return lock;
  }

  public void deposit(double amount) {
    this.balance = this.balance + amount;
  }

  public void withdrawal(double amount) {
    this.balance = this.balance - amount;
  }
}
