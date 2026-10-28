package org.example.practice7_cw.cost_counter;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
  CostCounter costCounter = new CostCounter();
  costCounter.addCosts(1, 123.5);
  costCounter.addCosts(2, 124.5);
  costCounter.addCosts(3, 125.5);
  costCounter.addCosts(4, 126.5);
    System.out.println(costCounter.getCosts(3));
    System.out.println(costCounter.minCostsPerMonth());

  }
}
