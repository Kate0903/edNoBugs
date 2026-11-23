package org.example.practice13.manager_of_entity;

import java.util.Objects;

public abstract class Entity {
  private int age;
  private String name;
  private boolean isActive;

  public Entity(String name, int age, boolean isActive) {

    this.name = name;
    this.age = age;
    this.isActive = isActive;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public boolean isActive() {
    return isActive;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Entity entity = (Entity) o;
    return age == entity.age && isActive == entity.isActive && Objects.equals(name, entity.name);
  }

  @Override
  public int hashCode() {
    int result = age;
    result = 31 * result + Objects.hashCode(name);
    result = 31 * result + Boolean.hashCode(isActive);
    return result;
  }
}
