package org.example.practice5_hw.task7;

/**
 * Сущности: Парк, Аттракцион, Американские горки, Карусель
 * Свойства: Парк-аттракцион
 * Действия: сервис(сохранение, поддержка), добавить аттракцион, описание, удаление аттракциона, управлять
 * Связи: Общие свойства у всех аттракционов → базовый класс Аттракцион. Специфичные действия добавляются в дочерние классы - Американские горки требуют регулярной проверки безопасности,
 * Карусель — частого технического обслуживания.
 * <p>
 * Примерная структура:
 * abstract class Attraction{
 * abstract void maintain();
 * abstract void description(); *
 * }
 * class RollerCoaster extends Attraction{
 * void maintain();
 * void description();
 * }
 * class RollerCoaster extends Roundabout{
 * void maintain();
 * void description();
 * }
 * class Park{
 * private Attraction attraction;
 * void addAttraction();
 * void manageAttraction();
 * void removeAttraction();
 * }
 *
 *
 */
public class Main {

  public static void main(String[] args) {
    Park park = new Park();
    RollerCoaster rollerCoaster = new RollerCoaster();
    Roundabout roundabout = new Roundabout();

    park.addAttraction(rollerCoaster);
    park.manageAttraction();

    park.removeAttraction();

    park.addAttraction(roundabout);
    park.manageAttraction();

  }
}
