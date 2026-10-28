package org.example.practice3;

public class LibraryTest {
  public static void main(String[] args){
    Library library = new Library();
    library.setBookTitle("Война и мир");
    library.author = "Толстой Л.Н.";
    library.year = 1863;
    library.category = "Роман";
    System.out.println("Наименование книги: " + library.getBookTitle()+". Автор книги: " +library.author +
            " Год выхода книги: " + library.year + ". Категория книги: " + library.category + ".");


  }

}
