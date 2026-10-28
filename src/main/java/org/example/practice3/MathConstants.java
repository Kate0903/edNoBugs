package org.example.practice3;

public class MathConstants {
  static final double PI = 3.14159;
  static final double E = 2.71828;

  public static double calculateCircleArea(double r){
    return PI*r*r;
  }

  public static double calculateCircumference(double r){
    return 2*PI*r;
  }

  public static double calculateExponentialGrowth(double initialValue, double rate, double time){
    return initialValue*Math.pow(E,rate*time);
  }


}
