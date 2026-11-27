package org.example.practice13.warehouse_inventory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Product {
  private String name;
  private double price;
  private String category;

  public Product(String name, double price, String category) {
    if (name == null || category == null) {
      throw new IllegalArgumentException("Имя и категория продукта не могут быть null.");
    }
    if (name.equals("") || category.equals("")) {
      throw new IllegalArgumentException("Имя и категория продукта не могут быть пустыми.");
    }
    if (price == 0 || price < 0) {
      throw new IllegalArgumentException("Цена товара не может быть 0 или отрицательной");
    }
    this.name = name;
    this.price = BigDecimal.valueOf(price)
            .setScale(2, RoundingMode.HALF_UP)
            .doubleValue();
    this.category = category;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;
    return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && Objects.equals(category, product.category);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(name);
    result = 31 * result + Double.hashCode(price);
    result = 31 * result + Objects.hashCode(category);
    return result;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }
}
