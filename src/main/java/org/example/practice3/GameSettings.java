package org.example.practice3;

public class GameSettings {
  static int maxPlayers;
  final String gameName;
  int currentPlayers;

  GameSettings(String someGameName, int someCurrentPlayers){
    this.currentPlayers = someCurrentPlayers;
    this.gameName = someGameName;
  }

  static void setMaxPlayers(int newSetMaxPlayers){
    maxPlayers = newSetMaxPlayers;
  }

  public int addPlayer(){
    return ++currentPlayers;
  }

  public void printGameStatus(){
    System.out.println("Название игры " + gameName + ". Текущее кол-во игроков " + currentPlayers
            + ". Максимальное количество игроков " + maxPlayers + ".");
  }
}
