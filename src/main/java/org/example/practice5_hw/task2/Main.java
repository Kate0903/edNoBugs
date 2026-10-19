package org.example.practice5_hw.task2;

/**
 * Сущности: Домашний питомец, Собака, Кошка, Система
 * <p>
 * Свойства: Система- домашний питомец.
 * Действия: взаимодействие, добавление питомца, кормление,
 * заставить есть питомца, совершить взаимодействие
 * <p>
 * Связи: Общие свойства у всех питомцев → базовый класс домашний питомец. Специфичные действия добавляются в дочерние классы - Собака гуляет и ест сухой корм,
 * Кошка играет и ест влажный корм
 * <p>
 * Примерная структура:
 * abstract class Pet{
 * abstract void interact();
 * abstract void feed();
 * }
 * <p>
 * <p>
 * class Dog extends Pet{
 * void interact("гуляет");
 * void feed("ест сухой корм");
 * }
 * <p>
 * class Cat extends Pet{
 * void interact("играет");
 * void feed("ест влажный корм");
 * }
 * <p>
 * class System{
 * private Pet pet;
 * void addPet(){};
 * void forceFeed(){};
 * void forceInteract(){};
 * void removePet(){};
 * }
 */

public class Main {
  public static void main(String[] args) {
    Cat barsik = new Cat();
    Dog sharik = new Dog();
    SystemPet systemPet = new SystemPet();

    systemPet.addPet(barsik);
    systemPet.forceFeed();
    systemPet.forceInteract();

    systemPet.removePet();

    systemPet.addPet(sharik);
    systemPet.forceFeed();
    systemPet.forceInteract();


  }
}
