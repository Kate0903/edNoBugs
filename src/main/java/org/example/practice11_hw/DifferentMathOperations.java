package org.example.practice11_hw;

import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DifferentMathOperations {
  //Проверка четности числа
  public boolean isEven(int number) {
    return number % 2 == 0;
  }

  //Подсчёт количества гласных в строке
  public int countVowels(String input) {
    if (input == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }
    return (int) input.toLowerCase().chars()
            .filter(c -> "aeiou".indexOf(c) != -1)
            .count();
  }

  //Разворот строки
  public String reverse(String input) {
    if (input == null) return null;
    return new StringBuilder(input).reverse().toString();
  }

  // Поиск максимального числа в массиве
  public int findMax(int[] numbers) {
    return Arrays.stream(numbers).max().orElseThrow();
  }

  //Проверка на високосный год
  public boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }

  //Проверка валидности email
  public boolean isValidEmail(String email) {
    return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
  }

  //Вычисление факториала числа
  public int factorial(int n) {
    if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
    return (n == 0) ? 1 : n * factorial(n - 1);
  }

  //Поиск второго максимального числа в массиве
  public int findSecondMax(int[] numbers) {
    return Arrays.stream(numbers).distinct().sorted().skip(numbers.length - 2).findFirst().orElseThrow();
  }

  //Подсчёт количества слов в строке
  public int countWords(String sentence) {
    return sentence.trim().isEmpty() ? 0 : sentence.split("\\s+").length;
  }

  //Проверка валидности номера телефона
  public boolean isValidPhoneNumber(String phone) {
    return phone.matches("\\+\\d{1,3} \\d{10}");
  }

  //Фильтрация списка чисел (оставить только чётные)
  public List<Integer> filterEvenNumbers(List<Integer> numbers) {
    return numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
  }

  //Сортировка списка строк по длине
  public List<String> sortByLength(List<String> words) {
    return words.stream()
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
  }

  //Проверка, является ли строка анаграммой другой
  public boolean isAnagram(String str1, String str2) {
    if (str1 == null || str2 == null) return false;
    char[] arr1 = str1.toLowerCase().replaceAll("\\s", "").toCharArray();
    char[] arr2 = str2.toLowerCase().replaceAll("\\s", "").toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    return Arrays.equals(arr1, arr2);
  }

  //Нахождение среднего значения массива чисел
  public double findAverage(int[] numbers) {
    return Arrays.stream(numbers).average().orElseThrow();
  }

  //Преобразование списка строк в список их длин
  public List<Integer> mapToLengths(List<String> words) {
    return words.stream().map(String::length).collect(Collectors.toList());
  }

  //Разбиение строки на части по разделителю
  public String[] splitString(String input, String delimiter) {
    return input.split(delimiter);
  }

  //Проверка корректности пароля (длина, символы, цифры)
  public boolean isValidPassword(String password) {
    if (password == null || password.length() < 8) return false;
    return password.matches("^(?=.*[A-Z])(?=.*\\d).+$");
  }

  //Нахождение наибольшего общего делителя (НОД)
  public int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public boolean isValidJson(String json) {
    try {
      new ObjectMapper().readTree(json);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  //Проверка, содержит ли массив дубликаты
  public boolean hasDuplicates(int[] numbers) {
    return Arrays.stream(numbers).distinct().count() != numbers.length;
  }

}
