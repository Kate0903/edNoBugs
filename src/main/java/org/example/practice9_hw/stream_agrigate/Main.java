package org.example.practice9_hw.stream_agrigate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
  static void main() {
    //1. Поиск максимального элемента
    //Задача: Напишите программу, которая принимает список чисел и находит в нём самое
    // большое число, используя Stream API.
    List<Integer> listInt1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 1, 3, 4));
    Integer maxInt = listInt1.stream().max(Comparator.naturalOrder()).get();

    System.out.println(maxInt);

    //2. Поиск минимального элемента
    //Задача: Напишите программу, которая принимает список чисел и находит в нем наименьшее число, используя Stream API.
    List<Integer> listInt2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 1, 3, 4));
    Integer minInt = listInt2.stream().min(Comparator.naturalOrder()).get();

    System.out.println(minInt);

    //3. Сумма всех элементов списка
    //Задача: Напишите программу, которая принимает список чисел и вычисляет их сумму, используя Stream API.
    List<Integer> listInt3 = new ArrayList<>(List.of(1, 2, 3, 4));
    Integer sum = listInt3.stream().mapToInt(x -> x).sum();

    System.out.println(sum);

    //4. Поиск первого элемента, начинающегося на "Б"
    //Задача: Напишите программу, которая принимает список строк и находит первую строку,
    // начинающуюся на букву "Б", используя Stream API.
    List<String> list = new ArrayList<>(List.of("function", "stream", "book", "loop", "exception", "fail", "brain"));
    String str = list.stream()
            .filter(x -> x.startsWith("b"))
            .findFirst()
            .get();

    System.out.println(str);

    //5. Проверка наличия хотя бы одного элемента по условию
    //Задача: Напишите программу, которая проверяет, есть ли хотя бы один элемент в списке, который
    // удовлетворяет заданному условию (например, является чётным числом), используя Stream API.
    List<Integer> listInt4 = new ArrayList<>(List.of(1, 3, 4));
    boolean isElement = listInt4.stream()
            .anyMatch(x -> x % 2 == 0);

    System.out.println(isElement);
  }
}
