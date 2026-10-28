package org.example.practice5_cw.task1;

public class Plane extends Transport {
  public Plane(){
    super(900,100000);

  }

  @Override
  public void start() {
    System.out.println("Самолет полетел");
  }
}
