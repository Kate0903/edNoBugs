package org.example.practice5_hw.task1;

/**
 * Сущности: Животное, Слон, Птица, Зоопарк
 * <p>
 * Свойства: зоопарк- животное.
 * <p>
 * Действия: издавать звук, передвижение, добавить животное,
 * удалить животное, заставить издавать звук, заставить передвигаться
 * <p>
 * Связи: Общие свойства у всех животных -> базовый класс Животное(Animal) - наследование
 * Специфичные действия добавляются в дочерние классы-> Слон трубит и ходит, Птица чирикает и летает.
 * <p>
 * Примерная структура:
 * <p>
 * abstract class Animal{
 * abstract void makeSound{};
 * abstract void makeMove{}
 * }
 * <p>
 * class Elephant extends Animal{
 * void makeSound{
 * sout (Труу)};
 * void makeMove{
 * sout (ходит)}
 * }
 * <p>
 * class Bird extends Animal{
 * void makeSound{
 * sout (чик-чирик)};
 * void makeMove{
 * sout (летает)}
 * }
 * <p>
 * class Zoo{
 * private Animal animal;
 * <p>
 * void addAnimal(){};
 * void forceMakeSound(){
 * }
 * void forceMakeMove(){}
 * void removeAnimal(){}
 * }
 */
public class Main {
  public static void main(String[] args) {
    Animal magpie = new Bird();
    Animal elephant = new Elephant();
    Zoo admin = new Zoo(magpie);

    admin.forceMakeMove();
    admin.forceMakeSound();

    admin.removeAnimal();

    admin.addAnimal(elephant);
    admin.forceMakeMove();
    admin.forceMakeSound();

  }
}
