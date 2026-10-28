package org.example.practice3;

public class Main {
  public static void main(String[] args) {
    Company employee1 = new Company(1,"Eremeev V.P.");
    Company employee2 = new Company(2,"Serov S.V.");
    System.out.println("Компания для первого сотрудника: " + employee1.getCompanyName());
    System.out.println("Компания для второго сотрудника: " + employee2.getCompanyName());
    System.out.print("Значение компании, полученное через статический метод: ");
    Company.printCompanyName();
    Company.companyName = "Lenovo";
    System.out.println("Компания для первого сотрудника: " + employee1.getCompanyName());
    System.out.println("Компания для второго сотрудника: " + employee2.getCompanyName());
    System.out.print("Значение компании, полученное через статический метод: ");
    Company.printCompanyName();


    System.out.println("Площадь окружности 1: " + MathConstants.calculateCircleArea(2));
    System.out.println("Площадь окружности 2: " + MathConstants.calculateCircleArea(3));
    System.out.println("Длина окружности 1: " + MathConstants.calculateCircumference(2));
    System.out.println("Длина окружности 2: " + MathConstants.calculateCircumference(3));

    System.out.println("Расчет по формуле экспоненциального роста: " +
            MathConstants.calculateExponentialGrowth(2,1,2));

    University student1 = new University(1, "Игнатов Р.М.");
    University student2 = new University(2, "Грибков С.В.");
    University student3 = new University(3, "Печкин В.В.");
    University.changeUniversityName("МГУ");
    student1.printStudentInfo();
    student2.printStudentInfo();
    student3.printStudentInfo();
    University.changeUniversityName("МГТУ");
    student1.printStudentInfo();
    student2.printStudentInfo();
    student3.printStudentInfo();

    GameSettings gamer1 = new GameSettings("MainCraft", 10);
    GameSettings gamer2 = new GameSettings("Stalker", 12);
    GameSettings.setMaxPlayers(50);
    gamer1.addPlayer();
    gamer1.addPlayer();
    gamer2.addPlayer();
    gamer1.printGameStatus();
    gamer2.printGameStatus();

    Person person1 = new Person("Алла", "Савельева", "123-45-6789");
    Person person2 = new Person("Петр", "Решетников", "123-00-6786");
    person1.setFirstName("Анна");
    person1.printPersonInfo();
    person2.printPersonInfo();



  }
}
