package org.example.practice8_hw.additional_tasks.task6;

public class Main {
  public static void main(String[] args) {
    Book book = new Book();
    book.add(1948);
    System.out.println(book.get());
    book.add("Искусство тестирования программ.");
    System.out.println(book.get());

  }
}
