package practice13.warehouse_inventory;

import org.example.practice13.warehouse_inventory.FlagInventoryOpen;
import org.example.practice13.warehouse_inventory.InventoryService;
import org.example.practice13.warehouse_inventory.OutOfStockException;
import org.example.practice13.warehouse_inventory.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Проверки на добавление товаров:
 * Добавить 1 товар, справочник пуст - успех (флаг - тру)
 * Повторить первый кейс но с флагом фолс - добавления не должно быть - список пуст.
 * Добавить подряд несколько товаров разных из разных категорий - успех
 * Добавить подряд несколько товаров из 1 категории - успех
 * Добавить одинаковые товары, но категория разная - успех
 * Добавление товаров одинаковых с одинаковой категорией(наименования категорий различаются регистром) - успех
 * Добавление товаров одинаковых с одинаковой категорией(наименования категорий различаются пробелом) - успех
 * Добавление товара с категорией - null - исключение
 * Добавление товара с категорией - "" - исключение
 * Добавление товара с категорией " "
 * Добавление товара с наименованием - null - исключение
 * Добавление товара с наименованием - "" - исключение
 * Добавление товара с 0 ценой - исключение
 * Добавление товара с минусовой ценой - исключение
 * <p>
 * Проверки на получение товаров по категории:
 * Проверка получение товаров из существующей категории, в категории есть товары, категория указана верно
 * Проверка получение товаров из существующей категории, в категории есть товары, категория указана с верхним регистром
 * Проверка получение товаров из существующей категории, в категории есть товары, категория указана с пробелами
 * Проверка отсутствия получения товаров, категория указана несуществующая-исключение
 * <p>
 * Проверки на получение товаров по цене:
 * Проверка получения товара по цене, указанная цена корректна и есть (-для 1 товара подходит цена
 * Проверка получения товара по цене - для нескольких подходит цена
 * Проверка получения исключения, если указана цена 0
 * Проверка получения исключения, если указана цена -1
 *
 */
public class InventoryServiceTest {
  //Тесты на добавление
  @Test
  public void userCanAddOneValidProductFlagTrue() {
    Product product = new Product("стул", 5000, "мебель");
    Product expectProduct = new Product("стул", 5000, "мебель");
    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product);
    Map<String, List<Product>> actualStoreProduct = inventoryService.getStoreProduct();
    assertAll(
            () -> assertEquals(1, actualStoreProduct.size()),
            () -> assertTrue(actualStoreProduct.containsKey(expectProduct.getCategory())),
            () -> assertTrue(actualStoreProduct.get(expectProduct.getCategory()).contains(expectProduct)),
            () -> assertEquals(1, actualStoreProduct.get(expectProduct.getCategory()).size()),
            () -> assertEquals(expectProduct, actualStoreProduct.values().iterator().next().getFirst()),
            () -> assertEquals(expectProduct.getName(), actualStoreProduct
                    .values().iterator().next().getFirst().getName()),
            () -> assertEquals(expectProduct.getCategory(), actualStoreProduct
                    .values().iterator().next().getFirst().getCategory()),
            () -> assertEquals(expectProduct.getPrice(), actualStoreProduct
                    .values().iterator().next().getFirst().getPrice())
    );
  }

  @Test
  public void userCanNotAddOneValidProductFlagFalse() {
    Product product = new Product("стул", 5000, "мебель");

    FlagInventoryOpen flag = new FlagInventoryOpen(false);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product);
    Map<String, List<Product>> actualStoreProduct = inventoryService.getStoreProduct();
    assertAll(
            () -> assertEquals(0, actualStoreProduct.size()),
            () -> assertTrue(actualStoreProduct.isEmpty())

    );
  }

  @Test
  public void userCanAddMoreOneValidProductsDifferentCategory() {
    Product product1 = new Product("стул", 5000, "мебель");
    Product product2 = new Product("зубная щетка", 500, "личная гигиена");
    Product product3 = new Product("сок", 200.5, "напитки");
    Product product4 = new Product("базилик", 45.8, "приправы");
    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);
    inventoryService.addProduct(product3);
    inventoryService.addProduct(product4);
    Map<String, List<Product>> actualStoreProduct = inventoryService.getStoreProduct();
    assertEquals(4, actualStoreProduct.size());
  }

  @Test
  public void userCanAddMoreOneValidProductsEqualCategory() {
    Product product1 = new Product("стул", 5000, "мебель");
    Product product2 = new Product("диван", 50000, "мебель");
    Product product3 = new Product("сок", 200.5, "напитки");
    Product product4 = new Product("стол", 30000, "мебель");
    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);
    inventoryService.addProduct(product3);
    inventoryService.addProduct(product4);
    Map<String, List<Product>> actualStoreProduct = inventoryService.getStoreProduct();
    assertEquals(2, actualStoreProduct.size());
  }

  @Test
  public void userCanAddMoreOneEqualProductsWithDifferentCategory() {
    Product product1 = new Product("скатерть", 1000.7, "праздники");
    Product product2 = new Product("скатерть", 1000.7, "текстиль");

    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);

    Map<String, List<Product>> actualStoreProduct = inventoryService.getStoreProduct();
    assertEquals(2, actualStoreProduct.size());
  }

  @Test
  public void userCanAddEqualProductsWithDifferentRegisterCategory() {
    Product product1 = new Product("скатерть", 1000.7, "текстиль");
    Product product2 = new Product("скатерть", 1000.7, "Текстиль");

    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);

    Map<String, List<Product>> actualStoreProduct = inventoryService.getStoreProduct();
    assertAll(
            () -> assertEquals(1, actualStoreProduct.size()),
            () -> assertEquals(2, actualStoreProduct.values().iterator().next().size())
    );
  }

  @Test
  public void userCanAddEqualProductsWithDifferentSpaceCategory() {
    Product product1 = new Product("скатерть", 1000.7, "текстиль");
    Product product2 = new Product("скатерть", 1000.7, "текстиль ");

    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);

    Map<String, List<Product>> actualStoreProduct = inventoryService.getStoreProduct();
    assertAll(
            () -> assertEquals(1, actualStoreProduct.size()),
            () -> assertEquals(2, actualStoreProduct.values().iterator().next().size())
    );
  }

  @Test
  public void userCanNotCreateProductsWithNullCategory() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Product("скатерть", 1000.7, null);
    }, "Try create products with null category should lead to IllegalArgumentException");
  }

  @Test
  public void userCanNotCreateProductsWithEmptyCategory() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Product("скатерть", 1000.7, "");
    }, "Try create products with null category should lead to IllegalArgumentException");
  }

  @Test
  public void userCanNotCreateProductsWithSpaceCategory() {
    Product product1 = new Product("скатерть", 1000.7, " ");
    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);

    assertThrows(IllegalArgumentException.class, () -> {
      inventoryService.addProduct(product1);
    }, "Try add products with space category should lead to IllegalArgumentException");
  }

  @Test
  public void userCanNotCreateProductsWithEmptyName() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Product("", 1000.7, "мебель");
    }, "Try create products with empty name should lead to IllegalArgumentException");
  }

  @Test
  public void userCanNotCreateProductsWithNullName() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Product(null, 1000.7, "мебель");
    }, "Try create products with null name should lead to IllegalArgumentException");
  }

  @Test
  public void userCanNotCreateProductsWithZeroPrice() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Product("скатерть", 0, "текстиль");
    }, "Try create products with zero price should lead to IllegalArgumentException");
  }

  @Test
  public void userCanNotCreateProductsWithNegativePrice() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Product("скатерть", -1, "текстиль");
    }, "Try create products with zero price should lead to IllegalArgumentException");
  }

  //Тесты на получение товаров по категории

  @Test
  public void userCanFilterProductsByCategory() {
    Product product1 = new Product("шкаф", 1000.7, "мебель");
    Product product2 = new Product("скатерть", 1000.7, "текстиль");
    Product product3 = new Product("табурет", 1000.7, "мебель");

    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);
    inventoryService.addProduct(product3);
    List<Product> listFilterByCategory = inventoryService.getProductsByCategory("мебель");

    assertAll(
            () -> assertEquals(2, listFilterByCategory.size()),
            () -> assertEquals("мебель", listFilterByCategory.get(0).getCategory()),
            () -> assertEquals("мебель", listFilterByCategory.get(1).getCategory()),
            () -> assertTrue(listFilterByCategory.get(0).getName().equals("шкаф")),
            () -> assertTrue(listFilterByCategory.get(1).getName().equals("табурет"))
    );

  }

  @Test
  public void userCanFilterProductsByCategoryWithDifferentRegister() {
    Product product1 = new Product("шкаф", 1000.7, "мебель");
    Product product2 = new Product("скатерть", 1000.7, "текстиль");
    Product product3 = new Product("табурет", 1000.7, "мебель");

    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);
    inventoryService.addProduct(product3);
    List<Product> listFilterByCategory = inventoryService.getProductsByCategory("Мебель");

    assertAll(
            () -> assertEquals(2, listFilterByCategory.size()),
            () -> assertEquals("мебель", listFilterByCategory.get(0).getCategory()),
            () -> assertEquals("мебель", listFilterByCategory.get(1).getCategory()),
            () -> assertTrue(listFilterByCategory.get(0).getName().equals("шкаф")),
            () -> assertTrue(listFilterByCategory.get(1).getName().equals("табурет"))
    );

  }

  @Test
  public void userCanFilterProductsByCategoryWithCategorySpace() {
    Product product1 = new Product("шкаф", 1000.7, "мебель");
    Product product2 = new Product("скатерть", 1000.7, "текстиль");
    Product product3 = new Product("табурет", 1000.7, "мебель");

    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);
    inventoryService.addProduct(product3);
    List<Product> listFilterByCategory = inventoryService.getProductsByCategory("мебель ");

    assertAll(
            () -> assertEquals(2, listFilterByCategory.size()),
            () -> assertEquals("мебель", listFilterByCategory.get(0).getCategory()),
            () -> assertEquals("мебель", listFilterByCategory.get(1).getCategory()),
            () -> assertTrue(listFilterByCategory.get(0).getName().equals("шкаф")),
            () -> assertTrue(listFilterByCategory.get(1).getName().equals("табурет"))
    );
  }

  @Test
  public void userCanFilterProductsByCategoryWithCategoryJustSpace() {
    Product product1 = new Product("шкаф", 1000.7, "мебель");
    Product product2 = new Product("скатерть", 1000.7, "текстиль");
    Product product3 = new Product("табурет", 1000.7, "мебель");

    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);
    inventoryService.addProduct(product3);
    assertThrows(IllegalArgumentException.class, () -> {
      inventoryService.getProductsByCategory(" ");
    }, "Try filter products by space category should lead to IllegalArgumentException");

  }

  @Test
  public void userCanFilterProductsByCategoryWithNotExistCategory() {
    Product product1 = new Product("шкаф", 1000.7, "мебель");
    Product product2 = new Product("скатерть", 1000.7, "текстиль");
    Product product3 = new Product("табурет", 1000.7, "мебель");

    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);
    inventoryService.addProduct(product3);
    assertThrows(OutOfStockException.class, () -> {
      inventoryService.getProductsByCategory("напитки");
    }, "Try filter products by not exist category should lead to OutOfStockException");
  }
// Тесты для проверки фильтрации по цене

  @Test
  public void userCanFilterProductsByPrice() {
    Product product1 = new Product("шкаф", 30000, "мебель");
    Product product2 = new Product("скатерть", 1000.7, "текстиль");
    Product product3 = new Product("табурет", 1500.9, "мебель");

    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);
    inventoryService.addProduct(product3);
    List<Product> listFilterByPrice = inventoryService.getProductsByPrice(1000.7);

    assertAll(
            () -> assertEquals(1, listFilterByPrice.size()),
            () -> assertEquals(1000.7, listFilterByPrice.getFirst().getPrice()),
            () -> assertEquals("скатерть", listFilterByPrice.getFirst().getName())
    );
  }

  @Test
  public void userCanFilterProductsByPriceForFewResult() {
    Product product1 = new Product("шкаф", 30000, "мебель");
    Product product2 = new Product("скатерть", 1500, "текстиль");
    Product product3 = new Product("штора", 1500, "текстиль");
    Product product4 = new Product("вода газированная", 1500, "напитки");

    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);
    inventoryService.addProduct(product3);
    inventoryService.addProduct(product4);
    List<Product> listFilterByPrice = inventoryService.getProductsByPrice(1500.00);

    assertEquals(3, listFilterByPrice.size());
  }

  @ValueSource(doubles = {
          0,
          -1
  })
  @ParameterizedTest
  public void userCanNotFilterProductsByPriceForZeroOrNegativePrice(double price) {
    Product product1 = new Product("шкаф", 30000, "мебель");
    Product product2 = new Product("скатерть", 1500, "текстиль");
    FlagInventoryOpen flag = new FlagInventoryOpen(true);
    InventoryService inventoryService = new InventoryService(flag);
    inventoryService.addProduct(product1);
    inventoryService.addProduct(product2);
    assertThrows(IllegalArgumentException.class, () -> {
      inventoryService.getProductsByPrice(price);
    }, "Try filter products by zero or negative price should lead to IllegalArgumentException");

  }
}

