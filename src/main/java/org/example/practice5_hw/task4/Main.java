package org.example.practice5_hw.task4;

/**
 * Сущности: Морское существо, Акула, Морская звезда, Аквариум
 * <p>
 * Свойства: Аквариум - морское существо.
 * Действия: движение, добавить существо, удалить существо
 * <p>
 * Связи: Общие свойства у всех морских существ → базовый класс Морское существо. Специфичные действия добавляются в дочерние классы - Акула плавает быстро и агрессивно,
 * Морская звезда ползает медленно по дну.
 * <p>
 * Примерная структура:
 * <p>
 * abstract class SeaEntity{
 * abstract void move();
 * }
 * <p>
 * class Shark extends SeaEntity{
 * void move();
 * }
 * <p>
 * class StarFish extends SeaEntity{
 * void move();
 * }
 * <p>
 * class Aquarium {
 * private SeaEntity seaEntity;
 * addSeaEntity();
 * demonstrateMove();
 * removeSeaEntity();
 * }
 *
 */
public class Main {


  public static void main(String[] args) {
    Shark shark = new Shark();
    StarFish starFish = new StarFish();
    Aquarium aquarium = new Aquarium();

    aquarium.addSeaEntity(shark);
    aquarium.demonstrateMove();

    aquarium.removeSeaEntity();

    aquarium.addSeaEntity(starFish);
    aquarium.demonstrateMove();


  }
}
