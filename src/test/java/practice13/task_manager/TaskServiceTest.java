package practice13.task_manager;

import org.example.practice13.student_grade.InvalidGradeException;
import org.example.practice13.student_grade.StudentGrade;
import org.example.practice13.task_manager.Task;
import org.example.practice13.task_manager.TaskService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Проверки добавление таски:
 * Проверка добавления валидной таски 1 в пустой справочник (int)
 * Добавление последовательно несколько тасок-разные таски (long)
 * Проверка отсутствия добавления при попытке добавить ту таску с тем же ид
 * Получение исключения при попытке создания таски со статусом null
 * Получение исключения при попытке создания таски со статусом ""
 * Получение исключения при попытке создания таски со статусом null
 * Получение исключения при попытке создания таски с приоритетом ""
 * Получение исключения при попытке создания таски с приоритетом null
 * Проверить исключение при добавлении таски без ид
 * Проверить исключение при добавлении таски с пустым ид
 * <p>
 * Проверки на удаление по идентификатору:
 * Проверка удаления, если в мапе 1 задача-её удаляем
 * Проверка, последовательно нескольких задач, в мапе много задач
 * Проверка попытки удалить несуществующий элемент - remove вернет false
 * Проверка попытки удаление из пустой мапы - remove вернет false
 * <p>
 * Проверки на фильтрацию по статусу:
 * Проверка фильтрации валидного статуса и статус есть в мапе (фильтру соответствует 1 запись)
 * Проверка фильтрации валидного статуса и статус есть в мапе (фильтру соответствует много записей)
 * Проверка, что при передаче статуса с заглавной буквы (а сохранили с маленькой ранее), мы фильтруем
 * Проверка, что при передаче с лишним пробелом статуса, мы тоже фильтруем
 * В фильтрацию передан статус, которого нет в мапе
 * В фильтрацию передан null
 * В фильтрацию передана ""
 * <p>
 * Проверки на фильтрацию по приоритету:
 * Проверка фильтрации валидного приоритета и приоритет есть в мапе (фильтру соответствует 1 запись)
 * Проверка фильтрации валидного приоритета и приоритет есть в мапе (фильтру соответствует много записей)
 * Проверка, что при передаче приоритета с заглавной буквы (а сохранили с маленькой ранее), мы фильтруем
 * Проверка, что при передаче с лишним пробелом приоритета, мы тоже фильтруем
 * В фильтрацию передан приоритет, которого нет в мапе
 * В фильтрацию передан null
 * В фильтрацию передана ""
 * <p>
 * Проверки на сортировку задач по дате:
 * Проверка валидной сортировки по датам ( в мапе несколько тасок и у всех разные даты)
 * Проверка получения пустой связанной мапы при сортировке пустой мапы
 *
 *
 */
public class TaskServiceTest {
  // Тесты на добавление
  @Test
  public void userCanAddOneValidTaskInEmptyMap() {
    Task<Integer> task = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> expectedTask = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();
    mapTasks.addTask(task);
    assertAll(
            () -> assertEquals(1, mapTasks.getTaskMap().size()),
            () -> assertEquals(expectedTask, mapTasks.getTaskMap().get(expectedTask.getId())),
            () -> assertTrue(mapTasks.getTaskMap().containsKey(expectedTask.getId())),
            () -> assertEquals(expectedTask.getStatus(), mapTasks.getTaskMap().get(expectedTask.getId()).getStatus()),
            () -> assertEquals(expectedTask.getPriority(), mapTasks.getTaskMap().get(expectedTask.getId()).getPriority()),
            () -> assertEquals(expectedTask.getDate(), mapTasks.getTaskMap().get(expectedTask.getId()).getDate())
    );
  }

  @Test
  public void userCanAddMoreOneValidTasksInMap() {
    Task<Integer> task1 = new Task<>(130, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(131, "в работе", "высокий", LocalDate.of(2026, 11, 25));

    TaskService<Integer> mapTasks = new TaskService<>();
    mapTasks.addTask(task1);
    mapTasks.addTask(task2);

    assertEquals(2, mapTasks.getTaskMap().size());
  }

  @Test
  public void userCanNotAddMoreOneValidTasksInMapWithEqualId() {
    Task<Integer> task1 = new Task<>(130, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(130, "закрыто", "средний", LocalDate.of(2026, 11, 25));

    TaskService<Integer> mapTasks = new TaskService<>();
    mapTasks.addTask(task1);
    mapTasks.addTask(task2);

    assertEquals(1, mapTasks.getTaskMap().size());
  }

  @Test
  public void userCanNotCreatTaskWithNullStatus() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Task<>(130, null, "высокий",
              LocalDate.of(2026, 11, 26));
    }, "Try create task with null status should lead to IllegalArgumentException");

  }

  @Test
  public void userCanNotCreatTaskWithEmptyStatus() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Task<>(130, "", "высокий",
              LocalDate.of(2026, 11, 26));
    }, "Try create task with empty status should lead to IllegalArgumentException");
  }

  @Test
  public void userCanNotCreatTaskWithNullPriority() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Task<>(130, "в работе", null,
              LocalDate.of(2026, 11, 26));
    }, "Try create task with null priority should lead to IllegalArgumentException");

  }

  @Test
  public void userCanNotCreatTaskWithEmptyPriority() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Task<>(130, "в работе", "",
              LocalDate.of(2026, 11, 26));
    }, "Try create task with empty priority should lead to IllegalArgumentException");
  }

  @Test
  public void userCanNotCreatTaskWithNullId() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Task<>(null, "в работе", "высокий",
              LocalDate.of(2026, 11, 26));
    }, "Try create task with null id should lead to IllegalArgumentException");
  }

  @Test
  public void userCanNotCreatTaskWithEmptyId() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Task<>("", "в работе", "высокий",
              LocalDate.of(2026, 11, 26));
    }, "Try create task with empty id should lead to IllegalArgumentException");
  }

  // Тесты на удаление
  @Test
  public void userCanRemoveTaskFromMapWithOneTask() {
    Task<Integer> task = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));

    TaskService<Integer> mapTasks = new TaskService<>();
    mapTasks.addTask(task);
    mapTasks.removeTask(task.getId());

    assertAll(

            () -> assertTrue(mapTasks.getTaskMap().isEmpty()),
            () -> assertEquals(0, (mapTasks.getTaskMap().size()))
    );
  }

  @Test
  public void userCanRemoveTasksFromMapWithMoreOneTask() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2025, 4, 26));
    Task<Integer> task2 = new Task<>(2, "закрыта", "низкий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в ожидании", "высокий", LocalDate.of(2026, 10, 15));
    TaskService<Integer> mapTasks = new TaskService<>();
    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);

    assertAll(
            () -> assertTrue(mapTasks.removeTask(task1.getId())),
            () -> assertTrue(mapTasks.removeTask(task3.getId())),
            () -> assertEquals(1, (mapTasks.getTaskMap().size())),
            () -> assertTrue(mapTasks.getTaskMap().containsKey(task2.getId()))
    );
  }

  @Test
  public void userCanNotRemoveNotExistTaskFromMap() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2025, 4, 26));
    Task<Integer> task2 = new Task<>(2, "закрыта", "низкий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в ожидании", "высокий", LocalDate.of(2026, 10, 15));
    TaskService<Integer> mapTasks = new TaskService<>();
    mapTasks.addTask(task1);
    mapTasks.addTask(task2);


    assertAll(
            () -> assertFalse(mapTasks.removeTask(task3.getId())),
            () -> assertFalse(mapTasks.getTaskMap().containsKey(task3.getId()))
    );
  }

  @Test
  public void userCanNotRemoveFromEmptyMap() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2025, 4, 26));

    TaskService<Integer> mapTasks = new TaskService<>();


    assertAll(
            () -> assertFalse(mapTasks.removeTask(task1.getId())),
            () -> assertTrue(mapTasks.getTaskMap().isEmpty()),
            () -> assertEquals(0, mapTasks.getTaskMap().size())
    );
  }

  //Тесты на фильтрацию по статусу
  @Test
  public void userCanFilterByStatusMapWithOneTask() {
    Task<Integer> task = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> expectedTask = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task);
    List<Task<Integer>> listFilterByStatus = mapTasks.filterByStatus("в работе");
    assertAll(
            () -> assertEquals(1, listFilterByStatus.size()),
            () -> assertEquals(expectedTask, listFilterByStatus.get(0))


    );
  }

  @Test
  public void userCanFilterByStatusMapWithMoreOneTask() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "в ожидании", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    List<Task<Integer>> listFilterByStatus = mapTasks.filterByStatus("в работе");
    assertEquals(2, listFilterByStatus.size());
  }

  @Test
  public void userCanFilterByStatusMapWithDifferentRegister() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "в ожидании", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    List<Task<Integer>> listFilterByStatus = mapTasks.filterByStatus("В работе");
    assertEquals(2, listFilterByStatus.size());
  }

  @Test
  public void userCanFilterByStatusMapWithSpaceStatus() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "Закрыто", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    List<Task<Integer>> listFilterByStatus = mapTasks.filterByStatus("Закрыто ");
    assertEquals(1, listFilterByStatus.size());
  }

  @Test
  public void userCanFilterByStatusMapStatusNotExist() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "Закрыто", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    List<Task<Integer>> listFilterByStatus = mapTasks.filterByStatus("В ожидании");
    assertEquals(0, listFilterByStatus.size());
  }

  @Test
  public void userCanFilterByStatusMapStatusIsEmpty() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "Закрыто", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    assertThrows(IllegalArgumentException.class, () -> {
      mapTasks.filterByStatus("");
    }, "Try filter by status task with empty status should lead to IllegalArgumentException");
  }

  @Test
  public void userCanFilterByStatusMapStatusIsNull() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "Закрыто", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    assertThrows(IllegalArgumentException.class, () -> {
      mapTasks.filterByStatus(null);
    }, "Try filter by status task with null status should lead to IllegalArgumentException");
  }

  // Тесты на проверку фильтрации по приоритету
  @Test
  public void userCanFilterByPriorityMapWithOneTask() {
    Task<Integer> task = new Task<>(1, "в работе", "низкий", LocalDate.of(2026, 11, 26));
    Task<Integer> expectedTask = new Task<>(1, "в работе", "низкий", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task);
    List<Task<Integer>> listFilterByPriority = mapTasks.filterByPriority("низкий");
    assertAll(
            () -> assertEquals(1, listFilterByPriority.size()),
            () -> assertEquals(expectedTask, listFilterByPriority.get(0))


    );
  }

  @Test
  public void userCanFilterByPriorityMapWithMoreOneTask() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "в ожидании", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    List<Task<Integer>> listFilterByPriority = mapTasks.filterByPriority("высокий");
    assertEquals(2, listFilterByPriority.size());
  }

  @Test
  public void userCanFilterByPriorityMapWithDifferentRegister() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "в ожидании", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    List<Task<Integer>> listFilterByPriority = mapTasks.filterByPriority("Высокий");
    assertEquals(2, listFilterByPriority.size());
  }

  @Test
  public void userCanFilterByPriorityMapWithSpaceStatus() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "Закрыто", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    List<Task<Integer>> listFilterByPriority = mapTasks.filterByPriority("высокий ");
    assertEquals(2, listFilterByPriority.size());
  }

  @Test
  public void userCanFilterByPriorityMapPriorityNotExist() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "Закрыто", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    List<Task<Integer>> listFilterByPriority = mapTasks.filterByPriority("низкий");
    assertEquals(0, listFilterByPriority.size());
  }

  @Test
  public void userCanFilterByPriorityMapPriorityIsEmpty() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "Закрыто", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    assertThrows(IllegalArgumentException.class, () -> {
      mapTasks.filterByPriority("");
    }, "Try filter by priority task with empty priority should lead to IllegalArgumentException");
  }

  @Test
  public void userCanFilterByPriorityMapPriorityIsNull() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task2 = new Task<>(2, "Закрыто", "высокий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в работе", "средний", LocalDate.of(2026, 11, 26));
    TaskService<Integer> mapTasks = new TaskService<>();

    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    assertThrows(IllegalArgumentException.class, () -> {
      mapTasks.filterByPriority(null);
    }, "Try filter by priority task with null priority should lead to IllegalArgumentException");
  }

  @Test
  public void userCanSortTasksFromMap() {
    Task<Integer> task1 = new Task<>(1, "в работе", "высокий", LocalDate.of(2025, 4, 26));
    Task<Integer> task2 = new Task<>(2, "закрыта", "низкий", LocalDate.of(2026, 11, 26));
    Task<Integer> task3 = new Task<>(3, "в ожидании", "высокий", LocalDate.of(2026, 10, 15));
    TaskService<Integer> mapTasks = new TaskService<>();
    mapTasks.addTask(task1);
    mapTasks.addTask(task2);
    mapTasks.addTask(task3);
    Map<Integer, Task<Integer>> linkedHMSortByDate = mapTasks.sortByDate();

    assertAll(
            () -> assertEquals(3, linkedHMSortByDate.size()),
            () -> assertEquals(2, linkedHMSortByDate.keySet().iterator().next()),
            () -> assertEquals(3, linkedHMSortByDate.keySet().stream().skip(1).findFirst().orElse(null)),
            () -> assertEquals(1, linkedHMSortByDate.keySet().stream().skip(2).findFirst().orElse(null))

    );
  }

  @Test
  public void userCanSortTasksFromEmptyMap() {

    TaskService<Integer> mapTasks = new TaskService<>();

    Map<Integer, Task<Integer>> linkedHMSortByDate = mapTasks.sortByDate();
    assertEquals(0, linkedHMSortByDate.size());


  }


}



