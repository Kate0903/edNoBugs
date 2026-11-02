package org.example.practice8_cw.library.exceptions;

//непроверяемое, наследник RuntimeException
public class InvalidBookException extends RuntimeException{
  public InvalidBookException (String message){
    super(message);
  }
}
