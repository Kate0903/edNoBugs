package org.example.practice8_hw.native_exceptions.checked;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileNotFound {
  //Напишите программу, которая пытается открыть файл с именем "data.txt".
  // Если файл не найден, программа должна обработать исключение и вывести сообщение:
  // "Файл не найден".

  public static void main(String[] args) {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader("data.txt"));
      String line = null;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (FileNotFoundException e) {
      System.err.println("Файл не найден.");
    } catch (IOException e) {
      System.err.println("Ошибка при чтении файла: " + e.getMessage());
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          System.out.println("Ошибка при закрытии файла: " + e.getMessage());
        }
      }
    }
  }
}
