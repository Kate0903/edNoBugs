package org.example.practice7_cw.photo_editor;

import java.util.Stack;

public class PhotoEditor {
  //Хранить последние действия
  private Stack<String> actions;
  public PhotoEditor(){
    this.actions = new Stack<>();
  }
  //Добавление нового действия
  public void addNewAction(String action){
    actions.push(action);
  }

  // иметь возможность откатить последние действия
  public  void undoLastAction(){
    actions.pop();
  }

  public void printActions(){
    System.out.println("Все действия: ");
    actions.forEach(System.out::println);
  }
}
