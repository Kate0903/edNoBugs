package org.example.practice5_hw.task8;

/**
 * Сущности: Музей, Экспонат, Древний манускрипт, Скульптура
 * Свойства: Музей - экспонат
 * Действия: описание экспоната, условия хранения, добавление нового экспоната,
 * удаление нового экспоната, показать информация об экспонате
 * <p>
 * Связи: Общие свойства у всех экспонатов → базовый класс Экспонат. Специфичные действия
 * добавляются в дочерние классы - Древний манускрипт нуждается в контроле температуры и влажности
 * Скульптура требует регулярной реставрации.
 * <p>
 * Примерная структура:
 * abstract class Exhibit{
 * abstract void description();
 * abstract void preserve();
 * }
 * class Manuscript extends Exhibit{
 * void description();
 * void preserve();
 * }
 * class Sculpture extends Exhibit{
 * void description();
 * *   void preserve();
 * }
 * class Museum{
 * private Exhibit exhibit;
 * void addExhibit();
 * void showInfoExhibit();
 * void removeExhibit();
 * }
 *
 *
 */
public class Main {
  public static void main(String[] args) {
    Sculpture sculpture = new Sculpture();
    Manuscript manuscript = new Manuscript();
    Museum museumCulture = new Museum();

    museumCulture.addExhibit(sculpture);
    museumCulture.showInfoExhibit();

    museumCulture.removeExhibit();

    museumCulture.addExhibit(manuscript);
    museumCulture.showInfoExhibit();
  }
}
