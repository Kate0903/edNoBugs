package practice12_hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DebugTask10 {
  public static void main(String[] args) {
    List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
    for (int i = 0; i < names.size(); i++) {
      if (names.get(i).startsWith("A")) {
        names.remove(names.get(i));
      }
    }
  }
}
