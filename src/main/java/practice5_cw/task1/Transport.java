package practice5_cw.task1;

public abstract class Transport {
  private double speed; // км/ч
  private int capacity; // м в куб.

  public Transport(double speed, int capacity){
    this.speed = speed;
    this.capacity = capacity;
  }
  public double getSpeed(){
    return this.speed;
  }
  public int getCapacity(){
    return this.capacity;
  }

  abstract void start();

  ;
}
