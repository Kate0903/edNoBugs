package org.example.practice10_cw.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
  // считает количество операций по всем потокам
  public static final AtomicInteger count = new AtomicInteger(0);
}