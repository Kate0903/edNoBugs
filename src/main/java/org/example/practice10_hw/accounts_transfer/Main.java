package org.example.practice10_hw.accounts_transfer;

import java.util.concurrent.TimeUnit;

public class Main {


  static void main() throws InterruptedException {
    Account account1 = new Account("User1", 10000);
    Account account2 = new Account("User2", 10000);
    Thread t1 = new Thread(() -> transfer(account1, account2, 40));
    Thread t2 = new Thread(() -> transfer(account2, account1, 100));

    t1.start();
    t2.start();

    t1.join();
    t2.join();
    System.out.println("Пользователь: " + account1.getName() + ", балланс на счете:" + account1.getBalance());
    System.out.println("Пользователь: " + account2.getName() + ", балланс на счете:" + account2.getBalance());

  }

  public static void transfer(Account from, Account to, double amount) {
    while (true) {
      try {
        if (from.getLock().tryLock(50, TimeUnit.MILLISECONDS)) {
          try {
            if (to.getLock().tryLock(50, TimeUnit.MILLISECONDS)) {
              try {
                if (from.getBalance() >= amount) {
                  from.withdrawal(amount);
                  to.deposit(amount);
                  System.out.println(Thread.currentThread().getName() +
                          ": перевел " + amount + " от [" + from.getName() + "] к [" + to.getName() + "]");
                }
                return;
              } finally {
                to.getLock().unlock();
              }
            }

          } finally {
            from.getLock().unlock();
          }

        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
      }
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
      }
    }
  }
}


