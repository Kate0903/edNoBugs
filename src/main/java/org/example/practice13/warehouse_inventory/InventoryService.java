package org.example.practice13.warehouse_inventory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryService {
  private boolean flagInventoryOpen;
  private Map<String, List<Product>> storeProduct = new HashMap<>();

  public InventoryService(FlagInventoryOpen flagInventoryOpen) {
    this.flagInventoryOpen = flagInventoryOpen.isInventoryOpen();

  }

  public void addProduct(Product product) {
    if (!flagInventoryOpen) {
      return;
    }
    if (product == null) {
      throw new IllegalArgumentException("Объект продукт не может быть null.");
    }
    String normalizedCategory = product.getCategory().trim().toLowerCase();
    if (normalizedCategory.equals("")) {
      throw new IllegalArgumentException("Категория не может быть пустой.");
    }
    if (storeProduct.containsKey(normalizedCategory)) {
      storeProduct.get(normalizedCategory).add(product);
    } else {
      storeProduct.put(normalizedCategory, new ArrayList<>(List.of(product)));
    }

  }

  public List<Product> getProductsByCategory(String category) {
    if (category == null || category.equals("")) {
      throw new IllegalArgumentException("Категория не может быть пустой или null.");
    }
    String normalizedCategory = category.toLowerCase().trim();
    if (normalizedCategory.equals("")) {
      throw new IllegalArgumentException("Категория не может быть пустой.");
    }
    List<Product> listProducts = storeProduct.entrySet().stream()
            .filter(e -> e.getKey().equals(normalizedCategory))
            .map(e -> e.getValue()).findFirst().orElse(null);
    if (listProducts == null || listProducts.isEmpty()) {
      throw new OutOfStockException("В категории" + category + " нет товаров.");
    }
    return listProducts;
  }

  public List<Product> getProductsByPrice(Double price) {
    if (price == 0 || price < 0) {
      throw new IllegalArgumentException("Стоимость товара не может быть 0 или меньше нуля.");
    }
    Double optimizedPrice = BigDecimal.valueOf(price)
            .setScale(2, RoundingMode.HALF_UP)
            .doubleValue();
    List<Product> listProducts = storeProduct.entrySet().stream()
            .flatMap(e -> e.getValue()
                    .stream().filter(s -> s.getPrice() == price)).collect(Collectors.toList());
    return listProducts;
  }


  public Map<String, List<Product>> getStoreProduct() {
    return storeProduct.entrySet().stream()
            .collect(Collectors.toUnmodifiableMap(
                    Map.Entry::getKey,
                    entry -> List.copyOf(entry.getValue()) // защищаем внутренний List от изменений
            ));
  }

}
