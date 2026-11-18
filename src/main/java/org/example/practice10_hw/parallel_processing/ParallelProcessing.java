package org.example.practice10_hw.parallel_processing;

import java.util.Map;

public class ParallelProcessing implements Runnable {
  private int sum = 0;
  private int count = 0;
  private final Map<Integer, Integer> mapInt;

  public ParallelProcessing(Map<Integer, Integer> mapInt) {
    this.mapInt = mapInt;
  }

  @Override
  public void run() {
    for (Map.Entry<Integer, Integer> entry : mapInt.entrySet()) {
      System.out.println("Индекс элемета: " + entry.getKey() + ". Значение элеменнта: " + entry.getValue());
      sum += entry.getValue();
      count++;
    }
  }


  public int getSum() {
    return sum;
  }

  public int getCount() {
    return count;
  }
}
