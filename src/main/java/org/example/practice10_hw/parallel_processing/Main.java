package org.example.practice10_hw.parallel_processing;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
  private List<Integer> listInt;
  private static List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

  static void main() throws InterruptedException {
    Map<Integer, Integer> map1 = listProcessing(list);
    Map<Integer, Integer> map2 = listProcessing(list);
    Map<Integer, Integer> map3 = listProcessing(list);

    ParallelProcessing parallelProcessing1 = new ParallelProcessing(map1);
    ParallelProcessing parallelProcessing2 = new ParallelProcessing(map2);
    ParallelProcessing parallelProcessing3 = new ParallelProcessing(map3);


    Thread t1 = new Thread(parallelProcessing1);
    Thread t2 = new Thread(parallelProcessing2);
    Thread t3 = new Thread(parallelProcessing3);


    t1.start();
    t2.start();
    t3.start();

    t1.join();
    t2.join();
    t3.join();

    System.out.println("Сумма всех обработанных элементов: " +
            (parallelProcessing1.getSum() + parallelProcessing2.getSum() + parallelProcessing3.getSum()));

    System.out.println("Кол-во всего обработанных элементов: " +
            (parallelProcessing1.getCount() + parallelProcessing2.getCount() + parallelProcessing3.getCount()));
    System.out.println("Список 1: " + map1);
    System.out.println("Список 2: " + map2);
    System.out.println("Список 3: " + map3);

  }

  public static Map<Integer, Integer> listProcessing(List<Integer> listInt) {
    Random random = new Random();
    Map<Integer, Integer> randomElements = random.ints(0, listInt.size())
            .distinct()
            .limit(3)
            .boxed() // преобразуем примитивный int в Integer
            .collect(Collectors.toMap(
                    index -> index,       // Ключ: сам индекс
                    listInt::get             // Значение: элемент по этому индексу
            ));
    return randomElements;
  }
}
