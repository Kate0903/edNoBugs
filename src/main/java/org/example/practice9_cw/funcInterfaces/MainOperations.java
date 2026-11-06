package org.example.practice9_cw.funcInterfaces;

public class MainOperations {
  static void main() {
    MathOperations add = (x, y) -> x + y;
    MathOperations substract = (x,y) -> x - y;
    MathOperations multiply = (x,y) -> x * y;
    MathOperations divide = (x,y) -> x / y;

    System.out.println(add.apply(2,3));
    System.out.println(substract.apply(10,7));
    System.out.println(multiply.apply(8,3));
    System.out.println(divide.apply(15,5));




  }
}
