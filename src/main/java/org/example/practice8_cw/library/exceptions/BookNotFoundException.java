package org.example.practice8_cw.library.exceptions;

//проверяемое -> наследник Exception
public class BookNotFoundException extends Exception{
  public BookNotFoundException (String message){
    super(message);
  }
}
