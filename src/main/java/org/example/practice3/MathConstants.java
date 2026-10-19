package org.example.practice3;

public class MathConstants {
  final double PI = 3.14159;
  final double E = 2.71828;

  public double calculateCircleArea(double r){
    return PI*r*r;
  }

  public double calculateCircumference(double r){
    return 2*PI*r;
  }

  public double calculateExponentialGrowth(double initialValue, double rate, double time){
    return initialValue*Math.pow(E,rate*time);
  }


}
