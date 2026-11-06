package org.example.practice9_cw.funcInterfaces;

public class MainForChecker {
  static void main() {
    Checker isPositive = n -> n > 0;
    isPositive.printIfValid(5);
    isPositive.printIfValid(-1);
  }

}
