package org.example.practice5_hw.task5;

/**
 * Сущности: Ферма, Домашнее животное, Корова, Курица
 * Свойства: Ферма-домашнее животное
 * Действия: получить информацию по обслуживанию животного,
 * добавить животное, кормление, уход, продукт производства, удалить животное
 * <p>
 * Связи: Общие свойства у всех домашних животных → базовый класс Домашнее животное. Специфичные действия добавляются в дочерние классы - Корова даёт молоко и нуждается в выпасе
 * Курица несёт яйца и требует корм с зерном.
 * <p>
 * Примерная структура:
 * abstract class Pet{
 * abstract void feed();
 * abstract void care();
 * abstract void produce();
 * }
 * class Cow extends Pet{
 * void feed();
 * void care();
 * void produce();
 * }
 * <p>
 * class Chicken extends Pet{
 * void feed();
 * void care();
 * void produce();
 * }
 * <p>
 * class Farm {
 * private Pet pet;
 * void addPet();
 * servicePet();
 * }
 *
 *
 *
 *
 *
 *
 *
 */
public class Main {
  static void main(String[] args) {
    Cow burenka = new Cow();
    Chicken chicken = new Chicken();
    Farm farm = new Farm();

    farm.addPet(burenka);
    farm.servicePet();

    farm.removePet();

    farm.addPet(chicken);
    farm.servicePet();
  }
}
