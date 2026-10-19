package practice5_cw.task2;

public class Clothes extends Item{
  private final static char DEFAULT_SIZE = 'M';
  private char size;

  public Clothes(String name, double price, int count){
    super(name,price,count);
    this.size = DEFAULT_SIZE;
  }
  @Override
  public void print() {
    super.print();
    System.out.println(", размер " + this.size);}
}

