package org.example.practice8_cw.library;

import java.util.Objects;

public class Book {
  private String Name;
  private String author;

  public Book(String author, String name) {
    this.author = author;
    Name = name;
  }

  public String getName() {
    return Name;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;
    return Objects.equals(Name, book.Name) && Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(Name);
    result = 31 * result + Objects.hashCode(author);
    return result;
  }
}
