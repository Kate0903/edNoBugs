package org.example.practice7_cw.contact_book;

public class Main {
  public static void main(String[] args) {
ContactBook contactBook = new ContactBook();

contactBook.addContact("Никита", 1233);
contactBook.addContact("Коля", 2344);

contactBook.printContacts();

contactBook.updatePhone("Коля", 4444);
contactBook.printContacts();

  }
}
