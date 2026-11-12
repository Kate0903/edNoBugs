package org.example.practice10_hw.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ProcessingTasks {
  static void main() throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    List<Future<String>> futures = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      final int taskI = i;
      Callable<String> resultTask = () -> {
        System.out.println("Задача в работе: " + taskI);
        Thread.sleep(2000);
        return "Задача завершена: " + taskI;
      };
      futures.add(executorService.submit(resultTask));
    }

    for (Future<String> future : futures) {
      System.out.println(future.get());
    }
    executorService.shutdown();
  }
}

