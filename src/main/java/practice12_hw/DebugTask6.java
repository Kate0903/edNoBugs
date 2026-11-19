package practice12_hw;

public class DebugTask6 {
  public static void main(String[] args) {
    countdown(5);
  }

  public static void countdown(int n) {
    System.out.println(n);
    if (n > 0) {
      countdown(n - 1);
    }
  }
}
