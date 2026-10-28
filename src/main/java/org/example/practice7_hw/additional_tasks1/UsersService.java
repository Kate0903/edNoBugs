package org.example.practice7_hw.additional_tasks1;

import java.util.HashSet;

public class UsersService {


  private HashSet<Integer> idUsers;

  public UsersService(HashSet<Integer> idUsers) {
    this.idUsers = idUsers;
  }


  public void searchId(int id){
    System.out.println(idUsers.contains(id));
  }


}
