package org.example.practice10_cw.collablefuture;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFutureExample {
  // Сложные расчеты ДНК
  // Наша задача - дождаться вычисления и получить результат
  static void main() throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Callable<Integer> dnaResult = () -> {
      System.out.println("Сложные вычисления DNA");
      Thread.sleep(10000);
      int randomDnaResult = new Random().nextInt();
      return  randomDnaResult;
    };
    Future<Integer> future = executorService.submit(dnaResult);
    System.out.println("Результат DNA: " + future.get());
    executorService.shutdown();
  }
}
