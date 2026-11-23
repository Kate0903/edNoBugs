package org.example.practice13.manager_of_entity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class EntityManager <T extends Entity>{
  CopyOnWriteArrayList<T> entities = new CopyOnWriteArrayList<>();

  public void add(T entity){
  if(entity == null){
     throw new NullPointerException();
  }
    entities.add(entity);
  }

  public boolean remove(T entity){
    return entities.remove(entity);
  }

  public List<T> getAll(){
    return List.copyOf(entities);
  }

  public List<T> filterByAge(int from, int to){
    return entities.stream().filter(entity -> entity.getAge() >= from && entity.getAge() <= to)
            .collect(Collectors.toList());
  }
  public List<T> filterByName(String name){
    return entities.stream().filter(entity -> entity.getName().equals(name))
            .collect(Collectors.toList());
  }
public List<T> filterByActive(boolean isActive){
    return entities.stream().filter(entity -> entity.isActive() == isActive).collect(Collectors.toList());
    }

    

}
