package org.example.practice13.task_manager;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Task<T> {
  private T id;
  private String status;
  private String priority;
  private LocalDate date;

  public Task(T id, String status, String priority, LocalDate date) {
    if (status == null || priority == null
            || status.equals("") || priority.equals("") || date == null
            || id == null || id.equals("")) {
      throw new IllegalArgumentException("Поля задачи не должны быть null или пустыми.");
    }
    this.id = id;
    String normalizedStatus = status.toLowerCase().trim();
    this.status = normalizedStatus;
    String normalizedPriority = priority.toLowerCase().trim();
    this.priority = normalizedPriority;
    this.date = date;
  }

  public T getId() {
    return id;
  }

  public String getStatus() {
    return status;
  }

  public String getPriority() {
    return priority;
  }

  public LocalDate getDate() {
    return date;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Task<?> task = (Task<?>) o;
    return Objects.equals(id, task.id) && Objects.equals(status, task.status) && Objects.equals(priority, task.priority) && Objects.equals(date, task.date);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(id);
    result = 31 * result + Objects.hashCode(status);
    result = 31 * result + Objects.hashCode(priority);
    result = 31 * result + Objects.hashCode(date);
    return result;
  }
}
