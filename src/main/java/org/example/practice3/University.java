package org.example.practice3;

public class University {
  static String universityName;
  final int studentID;
  String studentName;

  public University(int newStudentID, String newStudentName){
    this.studentID = newStudentID;
    this.studentName = newStudentName;
  }
  static void changeUniversityName(String newName){
    universityName = newName;
  }

  public String getStudentName(){
    return this.studentName;
  }

  public void printStudentInfo(){
    System.out.println("Идентификатор студента " + studentID + ". Имя студента " + studentName +
            " Название университета " + universityName + ".");
  }






}
