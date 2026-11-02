package org.example.practice8_cw.generics;

public class Main {
  public static void main(String[] args) {
    Box<String> boxString = new Box<>();
    boxString.setElement("Элемент");
    System.out.println(boxString.getElement());

    Box<Integer> boxInteger= new Box<>();
    boxInteger.setElement(3);

    Box<Book> boxWithBook = new Box<>();
    boxWithBook.setElement(new Book("книга"));
  }

}
