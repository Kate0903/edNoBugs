package org.example.practice13.warehouse_inventory;

public class OutOfStockException extends RuntimeException {
  public OutOfStockException(String message) {
    super(message);
  }
}
