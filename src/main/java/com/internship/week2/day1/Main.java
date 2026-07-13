package com.internship.week2.day1;

public class Main {

    public static void main(String args[]) {

//        Address address = new Address("1", "2", "karachi", "pakistan");
//        Department department = new Department("HR");
//        Employee emp1 = new Employee("Muhammad", 22, 35000, department, address);
//        Employee emp2 = new Employee("Kamran", 23, 40000, department, address);

        Student s1 = new Student();
        s1.name = "Ali";

        Student s2 = s1;
        s2.name = "Nadeem";

        System.out.println(s1.name);
        System.out.println(s2.name);
        //Both will print Nadeem - And I was correct

        Student s3 = new Student();
        s3.name = "Nawaz";
        Student s4 = new Student();
        s4.name = "Shareef";

        System.out.println(s3.name);
        System.out.println(s4.name);






    }
}
