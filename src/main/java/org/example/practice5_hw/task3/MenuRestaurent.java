package org.example.practice5_hw.task3;

public class MenuRestaurent {
  private Dish dish;

  public void addDish(Dish newDish) {
    this.dish = newDish;
    System.out.println("Блюдо было добавлено " + this.dish.toString());
  }

  public void showCharacteristics() {
    System.out.print("Отображение характеристик блюда " + this.dish.toString());
    dish.showCharacteristics();
  }

  public void removeDish() {
    System.out.println("Блюдо было удалено " + this.dish.toString());
    this.dish = null;
  }

}
