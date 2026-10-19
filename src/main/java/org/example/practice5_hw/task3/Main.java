package org.example.practice5_hw.task3;

/**
 * Сущности: Блюдо, Горячее блюдо, Напиток, Меню
 * <p>
 * Свойства: Горячее блюдо — температура.  Напиток — объем. Меню - блюдо.
 * Действия: добавление блюда в меню, показать характеристики, удаление блюда
 * <p>
 * Связи: Общие свойства у всех блюд → базовый класс Блюдо. Специфичные действия добавляются в дочерние классы
 * - Горячее блюдо подаётся с указанием температуры, Напиток — с указанием объёма.
 * <p>
 * Примернуая структура:
 * abstract class Dish{
 * abstract showCharacteristics();
 * }
 * <p>
 * class MainCourse extends Dish{
 * private temperature;
 * showCharacteristics();
 * class Drink extends Dish{
 * private value;
 * showCharacteristics();
 * <p>
 * class MenuRestaurent{
 * private Dish dish;
 * addDish();
 * dish.showCharacteristics();
 * removeDish();
 * }
 * }
 * <p>
 * }
 *
 */
public class Main {
  public static void main(String[] args) {
    Dish steak = new MainCourse(180);
    Drink cola = new Drink(1000);
    MenuRestaurent menu = new MenuRestaurent();

    menu.addDish(steak);
    menu.showCharacteristics();

    menu.removeDish();

    menu.addDish(cola);
    menu.showCharacteristics();

  }
}
