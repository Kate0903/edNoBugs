package practice13.manager_of_entity;

import org.example.practice13.manager_of_entity.EntityManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Проверки по добавлению:
 * Успешный сценарий:
 * Добавление 1 элемента в пустой список
 * Добавление 1 элемента в непустой список + Добавить друг за другом несколько элементов, проверить
 * , что все добавились (желательно добавить с активностью true и false + разные элементы по содержанию)
 * Корнер:
 * Добавление элемента с идентичными свойствами
 * Добавление null элемента
 *
 * Проверки по удалению элемента:
 * Удалить существующий элемент в списке
 * Удалить последовательно несколько элементов
 * Корнер:
 * Удалить элемента, которого нет в списке
 * Попробовать удалить, если список пуст
 *
 * Проверки на получение всех элементов(копия списка):
 * Добавить 1 элемент, после создать копию, добавить еще 1 элемент и проверить, что в копии его нет
 * Добавить 2 элемента, удалить один, снять копию, удалить второй элемент и убедиться, что в копии один элемент есть.
 *
 * Проверка фильтрации по возрасту:
 * Проверка большого диапазона, куда будут входить, все созданные объекты
 * Проверка левой границы(возраст включается в фильтр)
 * Проверка правой границы(возраст включается в фильтр)
 * Проверка преграниц
 *
 * Проверка фильтрации по имени:
 * Данное имя есть в списке (1 упоминание)
 * Данное имя есть в списке (несколько упоминаний)
 * Фильтрация по имени, если сущность с именем есть только в копии?
 * Данное имя отсутствует в списке
 * Список изначально пуст
 * Передать в фильтр null
 * Передать в фильтр ""
 *
 * Проверка фильтрации по активности:
 * Отфильтровать только активных пользователей
 * Отфильтровать только неактивных пользователей
 * Список изначально пуст
 * В списке только активные, а мы запрашиваем неактивных
 *
 */


public class EntityManagerTest {
  //Тесты на добавление
@Test
  public void userCanAddEntityInEmptyList(){
  Employee employee = new Employee("Кирилл", 25, true);
  Employee expectEmployee = new Employee("Кирилл", 25, true);
  EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee);

  Employee actualEmployee = entityManager.getAll().getFirst();
  assertAll(
          () -> assertTrue(entityManager.getAll().contains(employee)),
          () -> assertEquals(expectEmployee, actualEmployee),
          () -> assertEquals(expectEmployee.getName(), entityManager.getAll().getFirst().getName()),
          () -> assertEquals(expectEmployee.getAge(), entityManager.getAll().getFirst().getAge()),
          () -> assertEquals(expectEmployee.isActive(), entityManager.getAll().getFirst().isActive()),
          () ->  assertEquals(1,entityManager.getAll().size())

  );
  }
  @Test
  public void userCanAddMoreOneEntityInList(){
    Employee employee1 = new Employee("Кирилл", 25, true);
    Employee employee2 = new Employee("Егор", 35, false);
    Employee employee3 = new Employee("Евгений", 30, true);

    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);

      assertEquals(3,entityManager.getAll().size());
  }
  @Test
  public void userCanAddEqualEntitysInList(){
    Employee employee1 = new Employee("Кирилл", 25, true);
    Employee employee2 = new Employee("Кирилл", 25, true);


    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);

    assertEquals(2,entityManager.getAll().size());
  }
  @Test
  public void userCanNotNullEntityInList(){
    EntityManager<Employee> entityManager = new EntityManager<>();
    assertThrows(NullPointerException.class, () -> {
      entityManager.add(null);}, "Add null entity should lead to NullPointerException");
  }




  //Тесты на удаление
  @Test
  public void userCanRemoveEntityFromList(){
    Employee employee = new Employee("Кирилл", 25, true);

    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee);


    assertAll(
            () -> assertTrue(entityManager.remove(employee)),
            () -> assertEquals(0, entityManager.getAll().size()),
            () -> assertTrue(entityManager.getAll().isEmpty()));
  }

  @Test
  public void userCanRemoveMoreOneEntitysFromList(){
    Employee employee1 = new Employee("Кирилл", 25, true);
    Employee employee2 = new Employee("Аркадий", 48, true);
    Employee employee3 = new Employee("Петя", 34, false);
    Employee expectEmployee = new Employee("Аркадий", 48, true);

    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);



    assertAll(
            () -> assertTrue(entityManager.remove(employee1)),
            () -> assertTrue(entityManager.remove(employee3)));
    Employee actualEmployee = entityManager.getAll().getFirst();
    assertAll(() -> assertEquals(1, entityManager.getAll().size()),
            () -> assertEquals(expectEmployee, actualEmployee));
  }
  @Test
  public void userCanNotRemoveNotExistEntityFromList(){
    Employee employee1 = new Employee("Кирилл", 25, true);
    Employee employee2 = new Employee("Роберт", 65, true);


    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);



    assertAll(
            () -> assertFalse (entityManager.remove(employee2)),
            () -> assertEquals(1, entityManager.getAll().size()));

  }

  @Test
  public void userCanNotRemoveEntityFromEmptyList(){
    Employee employee1 = new Employee("Кирилл", 25, true);


    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.remove(employee1);


    assertAll(
            () -> assertFalse (entityManager.remove(employee1)),
            () -> assertEquals(0, entityManager.getAll().size()));

  }

  //Тесты на получение всех элементов(копия списка):
  @Test
  public void userCanNotAddEntityIntoCopyList(){
    Employee employee1 = new Employee("Василий", 44, true);
    Employee employee2 = new Employee("Денис", 56, true);
    Employee expectEmployee = new Employee("Василий", 44, true);

    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    List<Employee> copyEntityManager = entityManager.getAll();
    entityManager.add(employee2);

    assertAll(
            () -> assertEquals(1, copyEntityManager.size()),
            () -> assertEquals(expectEmployee, copyEntityManager.getFirst())
    );
  }
  @Test
  public void userCanNotRemoveEntityFromCopyList(){
    Employee employee1 = new Employee("Василий", 44, true);
    Employee employee2 = new Employee("Денис", 56, true);
    Employee expectEmployee = new Employee("Василий", 44, true);

    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.remove(employee2);
    List<Employee> copyEntityManager = entityManager.getAll();
    entityManager.remove(employee1);

    assertAll(
            () -> assertEquals(1, copyEntityManager.size()),
            () -> assertEquals(expectEmployee, copyEntityManager.getFirst()));
  }

  //Тесты на проверку фильтрации по возрасту
  @Test
  public void userCanFilterEntitysByAge(){
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, true);
    Employee employee3 = new Employee("Ирина", 45, true);
    Employee employee4 = new Employee("Сергей", 60, true);

    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);
    entityManager.add(employee4);
    List<Employee> actualFilterList = entityManager.filterByAge(10,70);

    assertEquals(4,actualFilterList.size());

  }
  @Test
  public void userCanFilterEntitysByAgeWithLeftBaund(){
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, true);
    Employee employee3 = new Employee("Ирина", 45, true);
    Employee employee4 = new Employee("Сергей", 60, true);
    Employee expectEmployee = new Employee("Петр", 15, true);

    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);
    entityManager.add(employee4);
    List<Employee> actualFilterList = entityManager.filterByAge(15,17);

    assertAll(
            () -> assertEquals(1,actualFilterList.size()),
            () -> assertEquals(expectEmployee,actualFilterList.getFirst()));
  }
  @Test
  public void userCanFilterEntitysByAgeWithRightBaund(){
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, true);
    Employee employee3 = new Employee("Ирина", 45, true);
    Employee employee4 = new Employee("Сергей", 60, true);
    Employee expectEmployee = new Employee("Василий", 20, true);

    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);
    entityManager.add(employee4);
    List<Employee> actualFilterList = entityManager.filterByAge(18,20);

    assertAll(
            () -> assertEquals(1,actualFilterList.size()),
            () -> assertEquals(expectEmployee,actualFilterList.getFirst()));
  }
  @Test
  public void userCanGetEmptyListAfterFilterByAge(){
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, true);
    Employee employee3 = new Employee("Ирина", 45, true);
    Employee employee4 = new Employee("Сергей", 60, true);
    Employee expectEmployee = new Employee("Василий", 20, true);

    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);
    entityManager.add(employee4);
    List<Employee> actualFilterList = entityManager.filterByAge(21,44);
    assertEquals(0,actualFilterList.size());
  }
  //Тесты на фильтрацию по имени:
  @Test
  public void userCanFilterMoreOneEntitysByName() {
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, true);
    Employee employee3 = new Employee("Ирина", 45, true);
    Employee employee4 = new Employee("Ирина", 45, true);


    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);
    entityManager.add(employee4);

    List<Employee> actualFilterList = entityManager.filterByName("Ирина");
    assertAll(
            () -> assertEquals(2, actualFilterList.size()),
            () -> assertEquals("Ирина", actualFilterList.getFirst().getName()),
            () -> assertEquals("Ирина", actualFilterList.get(1).getName())

    );
  }

    @Test
    public void userCanFilterOneEntityByName(){
      Employee employee1 = new Employee("Петр", 15, true);
      Employee employee2 = new Employee("Василий", 20, true);
      Employee employee3 = new Employee("Ирина", 45, true);


      EntityManager<Employee> entityManager = new EntityManager<>();

      entityManager.add(employee1);
      entityManager.add(employee2);
      entityManager.add(employee3);

      List<Employee> actualFilterList = entityManager.filterByName("Василий");
      assertAll(
              () -> assertEquals(1,actualFilterList.size()),
              () -> assertEquals("Василий",actualFilterList.getFirst().getName())

      );

  }
  @Test
  public void userCanGetEmptyListAfterFilterByName(){
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, true);
    Employee employee3 = new Employee("Ирина", 45, true);


    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);

    List<Employee> actualFilterList = entityManager.filterByName("Сергей");
    assertEquals(0,actualFilterList.size());

  }
  @Test
  public void userCanNotFilterByNameEmptyList(){
   EntityManager<Employee> entityManager = new EntityManager<>();
    List<Employee> actualFilterList = entityManager.filterByName("Сергей");
    assertEquals(0,actualFilterList.size());
  }
  @Test
  public void userCanGetEmptyListAfterFilterByNullName(){
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, true);
    Employee employee3 = new Employee("Ирина", 45, true);


    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);

    List<Employee> actualFilterList = entityManager.filterByName(null);
    assertEquals(0,actualFilterList.size());
  }

  @Test
  public void userCanGetEmptyListAfterFilterByEmptyName(){
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, true);
    Employee employee3 = new Employee("Ирина", 45, true);


    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);

    List<Employee> actualFilterList = entityManager.filterByName("");
    assertEquals(0,actualFilterList.size());
  }
  @Test
  public void userCanFilterByIsActiveTrue(){
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, false);
    Employee employee3 = new Employee("Ирина", 45, true);


    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);

    List<Employee> actualFilterList = entityManager.filterByActive(true);
    assertAll(
            () -> assertEquals(2,actualFilterList.size()),
            () -> assertTrue(actualFilterList.getFirst().isActive()),
            () -> assertTrue(actualFilterList.get(1).isActive())
    );

  }
  @Test
  public void userCanFilterByIsActiveFalse(){
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, false);
    Employee employee3 = new Employee("Ирина", 45, true);


    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);

    List<Employee> actualFilterList = entityManager.filterByActive(false);
    assertAll(
            () -> assertEquals(1,actualFilterList.size()),
            () -> assertFalse(actualFilterList.getFirst().isActive())

    );

  }
  @Test
  public void userCanFilterByIsActiveNullList(){
    EntityManager<Employee> entityManager = new EntityManager<>();
    List<Employee> actualFilterList = entityManager.filterByActive(true);

    assertEquals(0,actualFilterList.size());
  }
  @Test
  public void userCanFilterByIsActiveFalseForListJustTrue(){
    Employee employee1 = new Employee("Петр", 15, true);
    Employee employee2 = new Employee("Василий", 20, true);
    Employee employee3 = new Employee("Ирина", 45, true);


    EntityManager<Employee> entityManager = new EntityManager<>();

    entityManager.add(employee1);
    entityManager.add(employee2);
    entityManager.add(employee3);

    List<Employee> actualFilterList = entityManager.filterByActive(false);
    assertEquals(0,actualFilterList.size());
  }


}
