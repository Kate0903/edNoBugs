package org.example.practice13.warehouse_inventory;

public class FlagInventoryOpen {
  private final boolean isInventoryOpen;

  public FlagInventoryOpen(boolean isInventoryOpen) {
    this.isInventoryOpen = isInventoryOpen;
  }

  public boolean isInventoryOpen() {
    return isInventoryOpen;
  }
}
