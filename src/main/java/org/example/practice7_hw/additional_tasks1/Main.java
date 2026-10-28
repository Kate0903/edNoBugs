package org.example.practice7_hw.additional_tasks1;

import java.util.HashSet;

import static java.util.Arrays.*;

public class Main {
  public static void main(String[] args) {
    UsersService saveUsers = new UsersService(new HashSet<>(asList(2,3,6,5,8)));
    saveUsers.searchId(10);
    saveUsers.searchId(3);




  }
}
