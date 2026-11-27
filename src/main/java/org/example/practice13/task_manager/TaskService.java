package org.example.practice13.task_manager;

import java.util.*;
import java.util.stream.Collectors;

public class TaskService<T> {
  private final Map<T, Task<T>> taskMap = new LinkedHashMap<>();

  public void addTask(Task<T> task) {
    taskMap.put(task.getId(), task);
  }

  public synchronized boolean removeTask(T id) {
    if (id == null) {
      return false;
    }
    return taskMap.remove(id) != null;
  }

  public List<Task<T>> filterByStatus(String status) {
    if (status == null || status.equals("")) {
      throw new IllegalArgumentException("Статус не может быть null или пустой строкой.");
    }
    String normalizedStatus = status.toLowerCase().trim();
    if (normalizedStatus.equals("")) {
      throw new IllegalArgumentException("Статус не может быть пустой строкой.");
    }
    List<Task<T>> filterTaskByStatus = taskMap.values().stream()
            .filter(e -> e.getStatus().equals(normalizedStatus)).collect(Collectors.toList());
    return filterTaskByStatus;
  }


  public List<Task<T>> filterByPriority(String priority) {
    if (priority == null || priority.equals("")) {
      throw new IllegalArgumentException("Приоритет не может быть null или пустой строкой.");
    }
    String normalizedPriority = priority.toLowerCase().trim();
    if (normalizedPriority.equals("")) {
      throw new IllegalArgumentException("Приоритет не может быть пустой строкой.");
    }
    List<Task<T>> filterTaskByPriority = taskMap.values().stream()
            .filter(e -> e.getPriority().equals(normalizedPriority)).collect(Collectors.toList());
    return filterTaskByPriority;
  }

  public Map<T, Task<T>> sortByDate() {
    Map<T, Task<T>> sortMapByDate = taskMap.entrySet().stream().sorted(
                    Comparator.comparing((e1) -> e1.getValue().getDate()))
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),
                    (e1, e2) -> e1, () -> new LinkedHashMap<>())).reversed();
    return sortMapByDate;
  }

  public Map<T, Task<T>> getTaskMap() {
    return taskMap.entrySet().stream()
            .collect(Collectors.toUnmodifiableMap(
                    Map.Entry::getKey,
                    entry -> entry.getValue()));
  }
}
