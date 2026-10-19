package org.example.practice5_hw.task6;

/**
 * Сущности: Домашнее растение, Орхидея, Кактус, Ботанический сад
 * <p>
 * Свойства: Ботанический сад - домашнее растение.
 * <p>
 * Действия: уход, добавить растение, удалить растение, сохранение растения
 * Связи: Общие свойства у всех дом. растений → базовый класс Домашнее растение.
 * Специфичные действия добавляются в дочерние классы - Орхидея нуждается в тени и высокой влажности,
 * Кактус требует много света и редкого полива.
 * <p>
 * Примерная структура:
 * abstract class HomePlant(){
 * abstract void care();
 * }
 * <p>
 * class Orchid extends HomePlant{
 * void care();
 * }
 * class Cactus extends HomePlant{
 * void care();
 * }
 * <p>
 * class BotanicGarden{
 * private HomePlant homePlant;
 * void addHomePlant();
 * void maintain();
 * void removeHomePlant();
 * <p>
 * }
 *
 *
 */
public class Main {
  public static void main(String[] args) {
    Cactus cactus = new Cactus();
    Orchid orchid = new Orchid();
    BotanicGarden gardener = new BotanicGarden();

    gardener.addHomePlant(cactus);
    gardener.maintainHomePlant();

    gardener.removeHomePlant();

    gardener.addHomePlant(orchid);
    gardener.maintainHomePlant();


  }
}
