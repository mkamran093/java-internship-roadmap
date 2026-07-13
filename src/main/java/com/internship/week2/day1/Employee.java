package com.internship.week2.day1;

public class Employee {

    private static int nextId = 1001;
    private int id;
    private String name;
    private int age;
    private double salary;
    private Department department;
    private Address address;

    public Employee() {}

    public Employee(String name, int age, double salary, Department department, Address address) {
        this.id = nextId++;

        setName(name);
        setAge(age);
        setSalary(salary);
        if (address != null) {
            this.address = address;
        }
        if (department != null) {
            this.department = department;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 18 && age < 65) {
            this.age = age;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department=" + department +
                ", address=" + address +
                '}';
    }

}
